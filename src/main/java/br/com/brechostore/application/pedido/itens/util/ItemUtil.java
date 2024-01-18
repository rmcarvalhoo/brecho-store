package br.com.brechostore.application.pedido.itens.util;

import br.com.brechostore.application.pedido.dto.response.ItemDTO;
import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import br.com.brechostore.application.pedido.dto.response.ProductDTO;
import br.com.brechostore.domain.model.pedido.entity.ItensEntity;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.BeanUtils;

public class ItemUtil {
    public static List<ItemDTO> converEntitysToDtos(Iterable<ItensEntity> products){
        return StreamSupport.stream(products.spliterator(), false).
                map(p -> {
                    ItemDTO dto = convertEntityToDto(p);
                    return dto;
                }).collect(Collectors.toList());
    }


    public static ItemDTO convertEntityToDto(ItensEntity item){
        ItemDTO dto = new ItemDTO();
        OrderDTO orderDto = new OrderDTO();
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(item, dto);
        BeanUtils.copyProperties(item.getOrder(), orderDto);
        BeanUtils.copyProperties(item.getProduct(), productDTO);
        dto.setProduct(productDTO);
        dto.setOrder(orderDto);
        return dto;
    }
}
