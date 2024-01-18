package br.com.brechostore.controller;


import br.com.brechostore.application.pedido.cliente.ReadAllClientService;
import br.com.brechostore.application.pedido.cliente.ReadClientService;
import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/cliente")
public class ClientController extends BasicController{

    @Autowired
    private ReadClientService readClientService;

    @Autowired
    private ReadAllClientService readAllClientService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<ClientDTO> getAllClient(){
        log.info("Execute the getAllClient");
        return readAllClientService.execute();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ClientDTO getClient(@PathVariable(value = "id") Integer id){
        log.info("Execute the getClient id = [{}]", id);
        return readClientService.execute(id);
    }
}
