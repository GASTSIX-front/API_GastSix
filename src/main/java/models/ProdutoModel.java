package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.UUID;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto", nullable = false)
    private UUID id;

    private String descricao;
    private String partnumber;

    @JsonIgnore
    private String codigoSAP;
    private String url_img;
}
