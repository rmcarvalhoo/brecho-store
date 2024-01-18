package br.com.brechostore.application.pedido.itens;

import br.com.brechostore.application.pedido.CreateOrderService;
import br.com.brechostore.application.pedido.dto.request.NewOrderDTO;
import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.ClientJPARepository;
import org.junit.jupiter.api.AfterEach;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@EnableAutoConfiguration
public class CreateOrderServiceTest {

    @InjectMocks
    private CreateOrderService createOrderService;

    @Mock
    private OrderJPARepository orderJPARepository;

    @Mock
    private ClientJPARepository clientJPARepository;

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
        NewOrderDTO newOrderDTO = new NewOrderDTO();
        newOrderDTO.setClientId(123);

        ClientEntity clientEntity = new ClientEntity(123, "Jose", "jose@gmail.com", null);
        OrderEntity savedOrderEntity = new OrderEntity(456, clientEntity, new Date(), StatusEnum.STATUS.PENDENTE_DE_PRODUTO);

        // Mock repository methods
        when(clientJPARepository.findById(123)).thenReturn(clientEntity);
        when(orderJPARepository.save(any(OrderEntity.class))).thenReturn(savedOrderEntity);

        // Call the method under test
        OrderDTO result = createOrderService.execute(newOrderDTO);

        // Verify the expected behavior
        assertEquals(456, result.getId());
        assertEquals(clientEntity, savedOrderEntity.getClient());
        assertEquals(StatusEnum.STATUS.PENDENTE_DE_PRODUTO, savedOrderEntity.getStatus());

        // Verify that the mocks were called correctly
        verify(clientJPARepository).findById(123);
        verify(orderJPARepository).save(any(OrderEntity.class));
    }
}
