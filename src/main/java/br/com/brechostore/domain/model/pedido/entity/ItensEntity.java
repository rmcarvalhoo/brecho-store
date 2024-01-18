package br.com.brechostore.domain.model.pedido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name ="ITENSDOPEDIDO")
public class ItensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    ProductEntity product;

    @Column
    Integer quantidade;

}
