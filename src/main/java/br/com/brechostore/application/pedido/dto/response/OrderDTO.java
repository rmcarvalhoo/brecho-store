package br.com.brechostore.application.pedido.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.domain.model.pedido.entity.OrderEntity;
import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private Integer id;
    private ClientDTO client;
    private Date dataCriacao;
    private StatusEnum.STATUS status;
}
