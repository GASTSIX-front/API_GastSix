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

    @GetMapping("/{idFornecedor}") //colocar a variavel dentro do parenteses e dentro de chaves;
    //metodo public. O @path variable é o caminho pra pegar o valor, UUID tipo da variavel e o nome dela;
    public ResponseEntity<Object> buscarFornecedor(@PathVariable(value = "idFornecedor") UUID id){
        //criar uma variavel(optional) do tipo model pra buscar no repository o item que vc está buscando(fornecedorBuscado);
       Optional<FornecedorModel> fornecedorBuscado = fornecedorRepository.findById(id);
        //fazer uma verificação através do if;
       if (fornecedorBuscado.isEmpty()){
           //tipo de resposta; Se ele não encontrar NOT_Found da fornecedor nao encontrado;
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado");
       }
       //Tipo de resposta se estiver tudo OK;
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorBuscado.get());
    }

    @PostMapping
    //@requestBody é um atributo do corpo da requisição o tipo de dado que vai receber(sera um objeto do DTO)colocar o atributo e o nome da variavel;
    //caso no dto tenha algum notblank notNull precisa colocar o @valid.
    public ResponseEntity<Object> criarFornecedor(@RequestBody FornecedorDto fornecedorDto){
        //faz um if e dentor do parenteses mandar procurar pelo metodo que está dentro do repository
        if (fornecedorRepository.findByEmail(fornecedorDto.email()) != null){
            //tipo de resposta do if
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
        }
        if (fornecedorRepository.findByCnpj(fornecedorDto.cnpj())!= null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado");

        }

        //criar novo fornecedor
        FornecedorModel novoFornecedor = new FornecedorModel();
        //beanUtils ja faz a copia das propriedades de quem esta copiando pra quem está passando de forma automatica
        BeanUtils.copyProperties(fornecedorDto,novoFornecedor);
        //Tipo de resposta
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(novoFornecedor));
    }
    //Post com imagem no dto coloca uma string IMG, criar a pasta services no com.api.gastapi(dentro da service criar arquivo FileUploadservice colocar um @Service em cima do método)é um servico de upload de arquivo.
    //variavel path atributo para um caminho de pastas
    //@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    //    @Operation(summary = "Método para cadastrar um Usuário", method = "POST")
    //    @ApiResponses(value = {
    //            @ApiResponse(responseCode = "201", description = "Cadastro foi efetuado com sucesso"),
    //            @ApiResponse(responseCode = "400", description = "Paramatros inválidos")
    //    })
    //    public ResponseEntity<Object> criarUsuario(@ModelAttribute(quando vem um arquivo junto com a requisicão @Valid UsuarioDto usuarioDto){
    //        if (usuarioRepository.findByEmail(usuarioDto.email()) != null){
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
    //        }
    //        UsuarioModel novoUsuario = new UsuarioModel();
    //        BeanUtils.copyProperties(usuarioDto, novoUsuario);
    //
    //        String urlImagem;
    //        try{
    //            urlImagem = fileUploadService.fazerUpload(usuarioDto.imagem());
    //        }catch (IOException e){
    //            throw new RuntimeException(e);
    //        }
    //        novoUsuario.setUrl_img(urlImagem);
    //a pasta static dentro do resources e dentro da static criar um arquivo img

    //Put é o metodo de alterar com base no id;
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

    //Delete é o metodo para apagar o fornecedor;
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
