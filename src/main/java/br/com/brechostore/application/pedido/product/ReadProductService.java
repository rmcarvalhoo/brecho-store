package br.com.brechostore.application.pedido.product;


import br.com.brechostore.application.pedido.dto.response.ProductDTO;
import br.com.brechostore.application.pedido.product.util.ProductUtil;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import br.com.brechostore.infrastructure.jpa.pedido.ProductJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ReadProductService {

    @Autowired
    private ProductJPARepository repository;

    @Transactional
    public ProductDTO execute(Integer id) {
        log.info("Product to find is id=[{}]", id);
        ProductEntity entity = repository.findById(id);
        ProductDTO dto = ProductUtil.convertEntityToDto(entity);
        log.info("Product found is {}", dto);
        return dto;
    }

}
