package br.com.brechostore.domain.model.pedido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name ="CLIENTE")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String nome;

    @Column
    String email;

    @Transient
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

}
