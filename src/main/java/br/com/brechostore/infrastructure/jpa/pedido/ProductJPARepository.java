package br.com.brechostore.infrastructure.jpa.pedido;

import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import br.com.brechostore.infrastructure.jpa.pedido.repository.ProductJPARepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductJPARepository {

    @Autowired
    ProductJPARepositoryInterface productJPARepositoryInterface;

    public Iterable<ProductEntity> findAll() {
        return productJPARepositoryInterface.findAll();
    }

    public ProductEntity findById(Integer id) {
        return productJPARepositoryInterface.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("The produtct %d not found", id)));
    }
}
