package br.com.brechostore.application.pedido.util;

import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OrderUtil {
    public static List<OrderDTO> converEntitysToDtos(Iterable<OrderEntity> orders){
        return StreamSupport.stream(orders.spliterator(), false)
                .map(o -> {
                    OrderDTO orderDTO = convertEntityToDto(o);
                    return orderDTO;
                }).collect(Collectors.toList());

    }

    public static List<OrderDTO> converEntitysToDtos(List<OrderEntity> orders){
        return (StreamSupport.stream(orders.spliterator(), false).
                map(o -> {
                    OrderDTO orderDTO = convertEntityToDto(o);
                    return orderDTO;
                }).collect(Collectors.toList())
        );
    }

    public static OrderDTO convertEntityToDto(OrderEntity order){
        OrderDTO dto = new OrderDTO();
        ClientDTO cDto = new ClientDTO();
        BeanUtils.copyProperties(order, dto);
        BeanUtils.copyProperties(order.getClient(), cDto);
        dto.setClient(cDto);
        return dto;
    }
}
