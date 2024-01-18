package br.com.brechostore.infrastructure.jpa.pedido.repository;

import java.util.Optional;

import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepositoryInterface extends CrudRepository<ProductEntity, Integer> {

    @Override
    Optional<ProductEntity> findById(Integer var1);

    @Override
    Iterable<ProductEntity> findAll();
}