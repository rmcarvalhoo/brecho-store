package br.com.brechostore.application.pedido.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {
    private Integer id;
    private OrderDTO order;
    private ProductDTO product;
    private Integer quantidade;
}
