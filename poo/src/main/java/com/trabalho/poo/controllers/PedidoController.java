package com.trabalho.poo.controllers;

import com.trabalho.poo.entities.Pedido;
import com.trabalho.poo.services.GenericService;
import com.trabalho.poo.services.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends GenericController<Pedido>{

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        super();
        this.pedidoService = pedidoService;
    }

    @Override
    GenericService<Pedido> getService() {
        return pedidoService;
    }
}
