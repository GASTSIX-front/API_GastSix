
package com.api.gastapi.models;

public enum TipoModel {
    ADMIN("admin"),
    SUPERVISOR("supervisor"),
    OPERADOR("operador");

    private String tipo;

    TipoModel(String tipoRecebido){
        this.tipo = tipoRecebido;
    }

    public String getRole(){
        return tipo;
    }
}


