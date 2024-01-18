package br.com.brechostore.application.pedido.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewOrderDTO {
    @NotNull
    private Integer clientId;
}
