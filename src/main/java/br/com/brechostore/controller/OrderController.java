package br.com.brechostore.controller;


import br.com.brechostore.application.pedido.CreateOrderService;
import br.com.brechostore.application.pedido.ReadAllOrderService;
import br.com.brechostore.application.pedido.ReadOrderService;
import br.com.brechostore.application.pedido.cliente.ReadAllClientService;
import br.com.brechostore.application.pedido.cliente.ReadClientService;
import br.com.brechostore.application.pedido.dto.request.NewOrderDTO;
import br.com.brechostore.application.pedido.dto.response.ClientDTO;
import java.util.List;

import br.com.brechostore.application.pedido.dto.response.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/pedido")
public class OrderController extends BasicController{

    @Autowired
    private ReadOrderService readOrderService;

    @Autowired
    private ReadAllOrderService readAllOrderService;

    @Autowired
    private CreateOrderService createOrderService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<OrderDTO> getAll(){
        log.info("Execute the getAll");
        return readAllOrderService.execute();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public OrderDTO get(@PathVariable(value = "id") Integer id){
        log.info("Execute the get id = [{}]", id);
        return readOrderService.execute(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody @Validated NewOrderDTO newOrderDTO){
        return createOrderService.execute(newOrderDTO);
    }
}
