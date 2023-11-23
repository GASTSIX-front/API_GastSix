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

@RestController
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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "Método para cadastrar um fornecedor",method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cadastro foi efetuado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos")
    })
    public ResponseEntity<Object> criarFornecedor(@ModelAttribute @Valid FornecedorDto fornecedorDto){
        if (fornecedorRepository.findbyEmail(fornecedorDto.email()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
        }

        FornecedorModel novoFornecedor = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorDto,novoFornecedor);

        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(novoFornecedor));
    }

    @PutMapping(value = "/{idFornecedor}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> editarFornecedor(@PathVariable(value = "idFornecedor")UUID id, ModelAttribute @Valid FornecedorDto fornecedorDto){
        Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

        if (fornecedorBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        }

        FornecedorModel fornecedorBd = fornecedorBuscado.get();
        BeanUtils.copyProperties(fornecedorDto, fornecedorBd);

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.save(fornecedorBd));
    }

    @DeleteMapping("/idFornecedor")
    public ResponseEntity<Object> deletarFornecedor(@PathVariable(value = "idUsuario") UUID id){
        Optional<fornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);

        if (fornecedorBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
        }
        fornecedorRepository.delete(fornecedorBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor deletado com sucesso!");
    }
}
