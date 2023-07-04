package com.trabalho.poo.servicesimpl;

import com.trabalho.poo.entities.Pedido;
import com.trabalho.poo.repositories.GenericRepository;
import com.trabalho.poo.repositories.PedidoRepository;
import com.trabalho.poo.services.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    final PedidoRepository pedidoRepository;
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super();
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public GenericRepository<Pedido> getRepository() {
        return pedidoRepository;
    }
}
