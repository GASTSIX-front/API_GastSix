package com.api.gastapi.controllers;

import com.api.gastapi.models.PedidoProdutoModel;
import com.api.gastapi.repositories.PedidoProdutoRepository;
import com.api.gastapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidoproduto", produces = {"application/json"})
public class PedidoProdutoController {
    @Autowired
    PedidoProdutoRepository pedidoProdutoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoProdutoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<PedidoProdutoModel>> listarPedidosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoProdutoRepository.findAll());
    }
}
