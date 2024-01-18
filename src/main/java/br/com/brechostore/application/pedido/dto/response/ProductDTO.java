package br.com.brechostore.application.pedido.dto.response;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class ProductDTO {

    private Integer id;
    private String nome;
    private BigDecimal preco;;
}
