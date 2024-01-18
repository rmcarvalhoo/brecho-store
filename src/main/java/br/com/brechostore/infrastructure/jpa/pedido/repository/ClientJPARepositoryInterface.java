package br.com.brechostore.infrastructure.jpa.pedido.repository;

import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientJPARepositoryInterface extends CrudRepository<ClientEntity, Integer> {

    @Override
    Optional<ClientEntity> findById(Integer var1);

    @Override
    Iterable<ClientEntity> findAll();
}