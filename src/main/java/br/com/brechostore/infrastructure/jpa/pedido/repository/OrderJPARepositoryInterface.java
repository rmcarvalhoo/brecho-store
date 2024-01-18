package br.com.brechostore.infrastructure.jpa.pedido.repository;

import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJPARepositoryInterface extends CrudRepository<OrderEntity, Integer> {

    @Override
    Optional<OrderEntity> findById(Integer var1);

    @Override
    Iterable<OrderEntity> findAll();
}