package br.com.brechostore.application.pedido.cliente;

import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import br.com.brechostore.application.pedido.util.OrderUtil;
import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.infrastructure.jpa.pedido.ClientJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ReadClientService {

    @Autowired
    private ClientJPARepository repository;


    @Transactional
    public ClientDTO execute(Integer id) {
        log.info("Client to find is id=[{}]", id);
        ClientDTO dto = new ClientDTO();
        ClientEntity entity = repository.findById(id);
        BeanUtils.copyProperties(entity, dto);
        dto.setOrders(OrderUtil.converEntitysToDtos(entity.getOrders()));
        log.info("Client to found! [{}]", dto);
        return dto;
    }

}
