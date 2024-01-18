package br.com.brechostore.application.pedido.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private Integer id;
    private String nome;
    private String email;
    private List<OrderDTO> orders;




}
