package com.example.dashboardcompany;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Controller {
    public ToggleGroup Cargo;
    //    Buttons
    public Button btn_buscar;
    public Button btn_buscar2;
    public Button btn_gravar;
    public Button btn_alterar;
    public Button btn_apagar;
    public Label txtErro;
    //    Inicio - LOG
    @FXML
    private Label log_cargo;
    @FXML
    private Label log_nome;
    @FXML
    private Label log_entrada;
    @FXML
    ImageView img_url;
    //    Fim - LOG

    //Inicio - Radio Button Seleção de cargo.
    @FXML
    private RadioButton rButton1, rButton2;

    public void addCargo() {
        if (rButton1.isSelected()) {
            cargo.setText(rButton1.getText());
        } else if (rButton2.isSelected()) {
            cargo.setText(rButton2.getText());
        }
    }
    //Fim - Radio Button Seleção de cargo.
    //Inicio - cadastro.

    DAO_Pessoa dp = new DAO_Pessoa();
    Pessoa p = new Pessoa();

    @FXML
    private TextField c_nome;
    @FXML
    private TextField c_digital;
    @FXML
    public TextField c_url;
    @FXML
    private Label cargo;

    public void btnGravar() {
        p.setNome(c_nome.getText());
        p.setCargo(cargo.getText());
        p.setDigital(c_digital2.getText());
        p.setUrl(c_url.getText());
        if (Objects.equals(p.getUrl(), "")) {
            p.setUrl(null);
        }
        dp.insere(p);

        c_nome.setText("");
        cargo.setText("");
        c_digital2.setText("");
        c_url.setText("");
    }

    @FXML
    private TextField c_digital2;

    public void btnBuscar() {
        p = dp.busca(c_digital.getText());
        log_nome.setText(p.getNome());
        log_cargo.setText(p.getCargo());
        c_digital.setText(p.getDigital());

        if (p.getUrl() != null) {
            img_url.setImage(new Image(p.getUrl()));
        } else {
            img_url.setImage(new Image("https://cdn.discordapp.com/attachments/903051081637044265/981065994569154591/unknown.png"));
        }
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if (p.getEntrada() == null) {
            log_entrada.setText("Horario de entrada: " + dtf3.format(LocalDateTime.now()));
            p.setEntrada(log_entrada.getText());
        } else {
            log_entrada.setText("Horario de saida: " + dtf3.format(LocalDateTime.now()));
            p.setSaida(log_entrada.getText());
        }
        dp.altera(p);
        c_digital.setText("");
    }

    public void btnBuscar2() {
        p = dp.busca(c_digital2.getText());
        c_digital.setText(p.getDigital());
        c_nome.setText(p.getNome());
        c_url.setText(p.getUrl());
    }

    public void btnAlterar() {
        p.setNome(c_nome.getText());
        p.setDigital(c_digital2.getText());
        p.setCargo(cargo.getText());
        p.setUrl(c_url.getText());
        p.setEntrada(null);
        p.setSaida(null);

        dp.altera(p);

        c_nome.setText("");
        cargo.setText("");
        c_digital2.setText("");
        c_url.setText("");

    }

    public void btnApaga() {
        dp.apaga(c_digital.getText());

        c_nome.setText("");
        cargo.setText("");
        c_digital2.setText("");
        c_url.setText("");
    }
    //Fim - cadastro.
}