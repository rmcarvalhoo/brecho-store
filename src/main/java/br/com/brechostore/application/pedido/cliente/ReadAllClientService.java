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
public class ReadAllClientService {

    @Autowired
    private ClientJPARepository repository;


    @Transactional
    public List<ClientDTO> execute() {
        log.info("find all clients");
        Iterable<ClientEntity> entitys = repository.findAll();

        return StreamSupport.stream(entitys.spliterator(), false).
                map(e -> {
                    ClientDTO dto = new ClientDTO();
                    BeanUtils.copyProperties(e, dto);
                    dto.setOrders(OrderUtil.converEntitysToDtos(e.getOrders()));
                    return dto;
                }).collect(Collectors.toList());

    }

}
