package com.api.gastapi.controller;

import com.api.gastapi.dto.FornecedorDto;
import com.api.gastapi.model.FornecedorModel;
import com.api.gastapi.repository.FornecedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//notations @RestController @RequestMapping(o endereço que vc vai acessar, como vc se comunica com o controller)
@RestController
@RequestMapping(value = "/fornecedor", produces = {"application/json"})
public class FornecedorController {
    //fazer a primeira injecão de dependência @Autowired(classe e o nome);fazer o import do Autowired
    @Autowired
    FornecedorRepository fornecedorRepository;
//fazer o primeiro método que traz a lista do que você está fazendo(@getMapping)
    @GetMapping
    //responseEntity é o tipo de resposta, get retorna uma lista;
    public ResponseEntity<List<FornecedorModel>> listarFornecedor(){
        //execução dentro do return responseEntity(resposta),código status OK se tiver tudo certo, .body(class e o metodo);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.findAll());//findAll pega tudo da tabela que está sendo executada;
        //sempre executar no terminal após o termino do método.
    }

    @GetMapping("/{idFornecedor}")
    public ResponseEntity<Object> buscarFornecedor(@PathVariable(value = "idFornecedor") UUID id){
       Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

       if (fornecedorBuscado.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
       }
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> criarFornecedor(@RequestBody FornecedorDto fornecedorDto){
        if (fornecedorRepository.findByEmail(fornecedorDto.email()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
        }

        FornecedorModel novoFornecedor = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorDto,novoFornecedor);

        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(novoFornecedor));
    }

    @PutMapping(value = "/{idFornecedor}")
    public ResponseEntity<Object> editarFornecedor(@PathVariable(value = "idFornecedor")UUID id, @RequestBody FornecedorDto fornecedorDto){
        Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

        if (fornecedorBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        }

        FornecedorModel fornecedorBd = fornecedorBuscado.get();
        BeanUtils.copyProperties(fornecedorDto, fornecedorBd);

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.save(fornecedorBd));
    }

    @DeleteMapping("/{idFornecedor}")
    public ResponseEntity<Object> deletarFornecedor(@PathVariable(value = "idFornecedor") UUID id){
        Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

        if (fornecedorBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        }
        fornecedorRepository.delete(fornecedorBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor deletado com sucesso!");
    }
}
