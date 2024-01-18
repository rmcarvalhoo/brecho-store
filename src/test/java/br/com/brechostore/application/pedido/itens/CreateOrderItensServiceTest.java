package br.com.brechostore.application.pedido.itens;

import br.com.brechostore.application.pedido.dto.request.NewItemOrderDTO;
import br.com.brechostore.application.pedido.dto.response.ItemDTO;
import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.domain.model.pedido.entity.ItensEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import br.com.brechostore.infrastructure.jpa.pedido.ItensJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.ProductJPARepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@EnableAutoConfiguration
public class CreateOrderItensServiceTest {

    @InjectMocks
    private CreateOrderItensService createOrderItensService;

    @Mock
    private OrderJPARepository orderJPARepository;

    @Mock
    private ProductJPARepository productJPARepository;

    @Mock
    private ItensJPARepository itensJPARepository;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void afterEach() throws Exception {
        closeable.close();
    }

    @Test
    void testExecute() {
        // Prepare test data
        NewItemOrderDTO newItemOrderDTO = new NewItemOrderDTO();
        newItemOrderDTO.setOrderId(123);
        newItemOrderDTO.setProductId(456);
        newItemOrderDTO.setQtd(2);

        OrderEntity orderEntity = new OrderEntity(123, new ClientEntity(), new Date(), StatusEnum.STATUS.PENDENTE_DE_PAGAMENTO);
        ProductEntity productEntity = new ProductEntity(456, "CALÇA", BigDecimal.TEN);
        ItensEntity savedItemEntity = new ItensEntity(789, orderEntity, productEntity, 2);

        // Mock repository methods
        when(orderJPARepository.findById(123)).thenReturn(orderEntity);
        when(productJPARepository.findById(456)).thenReturn(productEntity);
        when(itensJPARepository.save(any(ItensEntity.class))).thenReturn(savedItemEntity);

        // Call the method under test
        ItemDTO result = createOrderItensService.execute(newItemOrderDTO);

        // Verify the expected behavior
        assertEquals(789, result.getId());
        assertEquals(orderEntity, savedItemEntity.getOrder());
        assertEquals(productEntity, savedItemEntity.getProduct());
        assertEquals(2, savedItemEntity.getQuantidade());

        // Verify that the mocks were called correctly
        verify(orderJPARepository).findById(123);
        verify(productJPARepository).findById(456);
        verify(itensJPARepository).save(any(ItensEntity.class));
    }
}
