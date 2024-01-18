package br.com.brechostore.application.pedido;

import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import br.com.brechostore.application.pedido.util.OrderUtil;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ReadAllOrderService {

    @Autowired
    private OrderJPARepository repository;

    @Transactional
    public List<OrderDTO> execute() {
        log.info("find all products");
        Iterable<OrderEntity> entitys = repository.findAll();
        return OrderUtil.converEntitysToDtos(entitys);
    }

}
