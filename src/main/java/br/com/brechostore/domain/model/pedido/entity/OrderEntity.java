package br.com.brechostore.domain.model.pedido.entity;

import br.com.brechostore.domain.model.pedido.enuns.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name ="PEDIDO")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    ClientEntity client;

    @Column(name = "DATA_CRIACAO")
    Date dataCriacao;

    @Setter
    @Column
    StatusEnum.STATUS status;

}
