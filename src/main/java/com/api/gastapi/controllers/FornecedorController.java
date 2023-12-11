package com.api.gastapi.controllers;

import com.api.gastapi.dtos.FornecedorDto;
import com.api.gastapi.models.FornecedorModel;
import com.api.gastapi.repositories.FornecedorRepository;
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
@RequestMapping(value = "/fornecedor", produces = {"application/json"})
public class FornecedorController {
    @Autowired
    FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listarFornecedor(){
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.findAll());
    }

    @GetMapping("/idFornecedor")
    public ResponseEntity<Object> buscarFornecedor(@PathVariable(value = "idFornecedor") UUID id){
       Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

       if (fornecedorBuscado.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
       }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorBuscado.get());
    }

    @RequestMapping
    @PostMapping
    public ResponseEntity<Object> criarUsuario(@RequestBody @Valid FornecedorDto fornecedorDto){

        FornecedorModel novoFornecedor = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorDto, novoFornecedor);

        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(novoFornecedor));
    }


    @PutMapping(value = "/{idFornecedor}")
    public ResponseEntity<Object> editarFornecedor(@PathVariable(value = "idFornecedor")UUID id, @ModelAttribute @Valid FornecedorDto fornecedorDto){

        Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

        if (fornecedorBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        }

        FornecedorModel fornecedorBd = fornecedorBuscado.get();
        BeanUtils.copyProperties(fornecedorDto, fornecedorBd);

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.save(fornecedorBd));
    }
    

    @DeleteMapping("/idFornecedor")
    public ResponseEntity<Object> deletarFornecedor(@PathVariable(value = "idFornecedor") UUID id){
        Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

        if (fornecedorBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        }
        fornecedorRepository.delete(fornecedorBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor deletado com sucesso!");
    }


}
