package br.com.brechostore.application.pedido.itens;

import br.com.brechostore.application.pedido.dto.request.NewItemOrderDTO;
import br.com.brechostore.application.pedido.dto.response.ItemDTO;
import br.com.brechostore.application.pedido.itens.util.ItemUtil;
import br.com.brechostore.domain.model.pedido.entity.ItensEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import br.com.brechostore.infrastructure.jpa.pedido.ItensJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.OrderJPARepository;
import br.com.brechostore.infrastructure.jpa.pedido.ProductJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ReadOrderItensService {

    @Autowired
    private OrderJPARepository orderJPARepository;

    @Autowired
    private ItensJPARepository itensJPARepository;

    @Transactional
    public List<ItemDTO> execute(Integer orderId) {
        log.info("Find ordem item by order id [{}]", orderId);
        OrderEntity orderEntity = orderJPARepository.findById(orderId);
        Iterable<ItensEntity> items = itensJPARepository.findItensDoPeduidoByOrderId(orderEntity);
        return ItemUtil.converEntitysToDtos(items);
    }

}
