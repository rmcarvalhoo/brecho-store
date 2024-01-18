package br.com.brechostore.domain.model.pedido.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name ="PRODUTO")
public class ProductEntity {

    @Id
    Integer id;

    @Column
    String nome;

    @Column
    BigDecimal preco;

}
