package br.com.brechostore.application.pedido.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewItemOrderDTO {

    @NotNull
    @JsonProperty("pedidoId")
    private Integer orderId;

    @NotNull
    @JsonProperty("produtoId")
    private Integer productId;

    @NotNull
    @JsonProperty("quantidade")
    private Integer qtd;

}
