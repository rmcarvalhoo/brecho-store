package br.com.brechostore.controller;


import br.com.brechostore.application.pedido.cliente.ReadAllClientService;
import br.com.brechostore.application.pedido.cliente.ReadClientService;
import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import java.util.List;

import br.com.brechostore.application.pedido.dto.response.ProductDTO;
import br.com.brechostore.application.pedido.product.ReadAllProductService;
import br.com.brechostore.application.pedido.product.ReadProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/produto")
public class ProductController extends BasicController{

    @Autowired
    private ReadProductService readProductService;

    @Autowired
    private ReadAllProductService readAllProductService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<ProductDTO> getAll(){
        log.info("Execute the getAllClient");
        return readAllProductService.execute();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ProductDTO get(@PathVariable(value = "id") Integer id){
        log.info("Execute the getClient id = [{}]", id);
        return readProductService.execute(id);
    }
}
