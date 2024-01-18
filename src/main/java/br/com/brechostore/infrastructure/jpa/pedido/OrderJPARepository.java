package br.com.brechostore.infrastructure.jpa.pedido;

import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.infrastructure.jpa.pedido.repository.OrderJPARepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderJPARepository {

    @Autowired
    private OrderJPARepositoryInterface orderJPARepositoryInterface;

    public Iterable<OrderEntity> findAll() {
        return orderJPARepositoryInterface.findAll();
    }

    public OrderEntity findById(Integer id) {
        return orderJPARepositoryInterface.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("The Order %d not found", id)));
    }

    public OrderEntity save(OrderEntity entity) {
        return orderJPARepositoryInterface.save(entity);
    }
}
