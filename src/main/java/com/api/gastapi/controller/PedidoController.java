package com.api.gastapi.controller;

import com.api.gastapi.dto.PedidoAtualizacaoDto;
import com.api.gastapi.dto.PedidoDto;
import com.api.gastapi.dto.PedidoListagemDto;
import com.api.gastapi.model.PedidoModel;
import com.api.gastapi.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPedido(@RequestBody @Valid PedidoDto dados){
        repository.save(new PedidoModel(dados));
    }

    @GetMapping
    public List<PedidoListagemDto> listarPedido(){
        return repository.findAll().stream().map(PedidoListagemDto::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizarPedido(@RequestBody @Valid PedidoAtualizacaoDto dados){
        var pedido = repository.getReferenceById(dados.id_pedido());
        pedido.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id_pedido}")
    @Transactional
    public void excluirPedido(@PathVariable UUID id_pedido){
        repository.deleteById(id_pedido);
    }
}
