package br.com.brechostore.application.pedido;


import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import br.com.brechostore.application.pedido.util.OrderUtil;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ReadOrderService {

    @Autowired
    private OrderJPARepository repository;

    @Transactional
    public OrderDTO execute(Integer id) {
        log.info("Order to find is id=[{}]", id);
        OrderEntity entity = repository.findById(id);
        OrderDTO dto = OrderUtil.convertEntityToDto(entity);
        log.info("Client found is {}", dto);
        return dto;
    }

}
