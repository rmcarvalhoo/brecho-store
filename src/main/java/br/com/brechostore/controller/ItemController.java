package br.com.brechostore.controller;

import br.com.brechostore.application.pedido.dto.request.NewItemOrderDTO;
import br.com.brechostore.application.pedido.dto.response.ItemDTO;
import br.com.brechostore.application.pedido.itens.CreateOrderItensService;
import br.com.brechostore.application.pedido.itens.ReadOrderItensService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/item")
public class ItemController extends BasicController{

    @Autowired
    private CreateOrderItensService createOrderItensService;

    @Autowired
    private ReadOrderItensService readOrderItensService;

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ItemDTO create(@RequestBody @Validated NewItemOrderDTO newItemOrderDTO){
        log.info("Execute the create item for order [{}]", newItemOrderDTO);
        return createOrderItensService.execute(newItemOrderDTO);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/order/{orderId}")
    public List<ItemDTO> get(@PathVariable(value = "orderId") Integer id){
        log.info("Execute the getClient id = [{}]", id);
        return readOrderItensService.execute(id);
    }
}
