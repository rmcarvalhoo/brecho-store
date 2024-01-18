package br.com.brechostore.application.pedido;

import br.com.brechostore.application.pedido.dto.request.NewOrderDTO;
import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import br.com.brechostore.infrastructure.jpa.pedido.ClientJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Service
public class CreateOrderService {

    @Autowired
    private OrderJPARepository repository;

    @Autowired
    private ClientJPARepository clientJPARepository;

    @Transactional
    public OrderDTO execute(NewOrderDTO newOrderDTO) {
        OrderDTO dto = new OrderDTO();
        ClientEntity clientEntity = clientJPARepository.findById(newOrderDTO.getClientId());
        OrderEntity orderEntity = new OrderEntity(null, clientEntity, new Date(), StatusEnum.STATUS.PENDENTE_DE_PRODUTO);
        OrderEntity entity = repository.save(orderEntity);
        BeanUtils.copyProperties(entity, dto);
        log.info("Order created with success. [{}]", dto);
        return dto;

    }

}
