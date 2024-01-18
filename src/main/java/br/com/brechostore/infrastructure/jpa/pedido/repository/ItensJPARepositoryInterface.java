package br.com.brechostore.infrastructure.jpa.pedido.repository;

import java.util.Optional;

import br.com.brechostore.domain.model.pedido.entity.ItensEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensJPARepositoryInterface extends CrudRepository<ItensEntity, Integer> {

    Iterable<ItensEntity> findItensEntityByOrder(OrderEntity order);

}