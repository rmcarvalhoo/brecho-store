package br.com.brechostore.application.pedido.product;

import br.com.brechostore.application.pedido.dto.response.ProductDTO;
import br.com.brechostore.application.pedido.product.util.ProductUtil;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import java.util.List;

import br.com.brechostore.infrastructure.jpa.pedido.ProductJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ReadAllProductService {

    @Autowired
    private ProductJPARepository repository;

    @Transactional
    public List<ProductDTO> execute() {
        log.info("find all products");
        Iterable<ProductEntity> entitys = repository.findAll();
        return ProductUtil.converEntitysToDtos(entitys);

    }

}
