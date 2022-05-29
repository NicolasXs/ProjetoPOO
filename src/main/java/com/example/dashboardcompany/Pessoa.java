package com.example.dashboardcompany;

import javafx.scene.image.Image;

public class Pessoa {

    private String nome;
    private String endereco;
    private String fone;
    private String url;

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String e) {
        endereco = e;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setFone(String f) {
        fone = f;
    }

    public String getFone() {
        return fone;
    }

    public void setUrl(String u) {
        url = u;
    }

    public String getUrl() {
        return url;
    }
}
