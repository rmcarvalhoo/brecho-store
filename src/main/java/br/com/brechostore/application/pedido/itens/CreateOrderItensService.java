package br.com.brechostore.application.pedido.itens;

import br.com.brechostore.application.pedido.dto.request.NewItemOrderDTO;
import br.com.brechostore.application.pedido.dto.response.ItemDTO;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import br.com.brechostore.domain.model.pedido.entity.ItensEntity;
import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import br.com.brechostore.infrastructure.jpa.pedido.ItensJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.ProductJPARepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CreateOrderItensService {

    @Autowired
    private OrderJPARepository orderJPARepository;

    @Autowired
    private ProductJPARepository productJPARepository;

    @Autowired
    private ItensJPARepository itensJPARepository;

    @Transactional
    public ItemDTO execute(NewItemOrderDTO newItemOrderDTO) {
        ItemDTO dto = new ItemDTO();
        OrderEntity orderEntity = orderJPARepository.findById(newItemOrderDTO.getOrderId());
        orderEntity.setStatus(StatusEnum.STATUS.PENDENTE_DE_PAGAMENTO);
        ProductEntity productEntity = productJPARepository.findById(newItemOrderDTO.getProductId());
        ItensEntity itemEntity = itensJPARepository.save(new ItensEntity(null, orderEntity, productEntity, newItemOrderDTO.getQtd()));
        BeanUtils.copyProperties(itemEntity, dto);
        log.info("Order item created with success. [{}]", dto);
        return dto;
    }

}
