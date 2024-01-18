package br.com.brechostore.infrastructure.jpa.pedido;

import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.infrastructure.jpa.pedido.repository.ClientJPARepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientJPARepository {

    @Autowired
    ClientJPARepositoryInterface clientJPARepositoryInterface;

    public Iterable<ClientEntity> findAll() {
        return clientJPARepositoryInterface.findAll();
    }

    public ClientEntity findById(Integer id) {
        return clientJPARepositoryInterface.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("The client %d not found", id)));
    }
}
