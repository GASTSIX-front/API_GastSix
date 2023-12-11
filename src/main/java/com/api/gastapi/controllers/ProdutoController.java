package com.api.gastapi.controllers;

import com.api.gastapi.dtos.ProdutoDto;
import com.api.gastapi.models.ProdutoModel;
import com.api.gastapi.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/produtos", produces = {"application/json"})
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Object> buscarProduto(@PathVariable(value = "idProduto") UUID id) {
        Optional<ProdutoModel> produtoBuscado = produtoRepository.findById(id);

        if (produtoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody @Valid ProdutoDto dadosRecebidos){
        if (produtoRepository.findByPartnumber(dadosRecebidos.partnumber()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PARTNUMBER JÁ CADASTRADO");
        }
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(dadosRecebidos, produtoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<Object> editarProduto(@PathVariable(value = "idProduto") UUID id, @RequestBody @Valid ProdutoDto produtoDto) {
        Optional<ProdutoModel> produtoBuscado = produtoRepository.findById(id);

        if (produtoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        ProdutoModel produtoModel = produtoBuscado.get();
        BeanUtils.copyProperties(produtoDto, produtoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Object> deletaProduto(@PathVariable(value = "idProduto") UUID id){
        Optional<ProdutoModel> produtoBuscado = produtoRepository.findById(id);

        if (produtoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepository.delete(produtoBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }

}


//
//    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    @Operation




