package br.com.brechostore.application.pedido.itens;

import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import br.com.brechostore.domain.model.pedido.entity.ClientEntity;
import br.com.brechostore.infrastructure.jpa.pedido.repository.ClientJPARepositoryInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureWebTestClient
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour
@DataJpaTest
public class ConsultantRepositoryTest {

    @Container
    static MySQLContainer postgresqlContainer = new MySQLContainer("mysql:8.0")
            .withDatabaseName("basics")
            .withUsername("xyz_one")
            .withPassword("xyz_pw");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresqlContainer::getPassword);
    }

    @Autowired
    private ClientJPARepositoryInterface repository;

    @Autowired
    WebTestClient webTestClient;

    @BeforeEach
    public void beforeEach(){
        ClientEntity entity = new ClientEntity(null, "Patricia", "patricia@gmail.com", null);
        repository.save(entity);
    }

    @AfterEach
    public void afterEach(){
        repository.deleteAll();
    }

}
