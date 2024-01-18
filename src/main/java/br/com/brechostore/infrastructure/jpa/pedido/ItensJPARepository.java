package br.com.brechostore.infrastructure.jpa.pedido;

import br.com.brechostore.domain.model.pedido.entity.ItensEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.infrastructure.jpa.pedido.repository.ItensJPARepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensJPARepository  {

    @Autowired
    private ItensJPARepositoryInterface itensJPARepositoryInterface;

    public Iterable<ItensEntity> findItensDoPeduidoByOrderId(OrderEntity entity) {
        return itensJPARepositoryInterface.findItensEntityByOrder(entity);
    }

    public ItensEntity save(ItensEntity entity) {
        return itensJPARepositoryInterface.save(entity);
    }
}
