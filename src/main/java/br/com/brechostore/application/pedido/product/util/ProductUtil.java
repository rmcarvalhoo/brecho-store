package br.com.brechostore.application.pedido.product.util;

import br.com.brechostore.application.pedido.dto.response.ProductDTO;
import br.com.brechostore.domain.model.pedido.entity.ProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.BeanUtils;

public class ProductUtil {
    public static List<ProductDTO> converEntitysToDtos(Iterable<ProductEntity> products){
        return StreamSupport.stream(products.spliterator(), false).
                map(p -> {
                    ProductDTO dto = convertEntityToDto(p);
                    return dto;
                }).collect(Collectors.toList());
    }

    public static List<ProductDTO> converEntitysToDtos(List<ProductEntity> product){
        return (StreamSupport.stream(product.spliterator(), false).
                map(p -> {
                    ProductDTO dto = convertEntityToDto(p);
                    return dto;
                }).collect(Collectors.toList())
        );
    }

    public static ProductDTO convertEntityToDto(ProductEntity order){
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(order, dto);
        return dto;
    }
}
