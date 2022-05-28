package com.example.dashboardcompany;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    public Button btn_buscar2;
    public Label txtErro;
    public ImageView img_url;
    public ToggleGroup Cargo;
    public Button btn_buscar;
    public Button btn_gravar;
    public Button btn_alterar;
    public Button btn_apagar;
    public Button btn_listar;
    public TextField c_digital1;


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
    private Label cargo;

    public void btnGravar() {
        p.setNome(c_nome.getText());
        p.setEndereco(cargo.getText());
        p.setFone(c_digital.getText());

        dp.insere(p);
        //LOG
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        log_cargo.setText(cargo.getText());
        log_nome.setText(c_nome.getText());
        log_entrada.setText("Horario entrada " + dtf4.format(LocalDateTime.now()));
        //LOG
    }

    @FXML
    private TextField txt1;

    public void btnBuscar() {
        p = dp.busca(txt1.getText());
        log_nome.setText(p.getNome());
        log_cargo.setText(p.getEndereco());
        c_digital.setText(p.getFone());
//        img_url.setImage(avatar);
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        log_entrada.setText("Horario entrada " + dtf4.format(LocalDateTime.now()));
    }
    //Fim - cadastro.

    //    Inicio - LOG
    @FXML
    private Label log_cargo;
    @FXML
    private Label log_nome;
    @FXML
    private Label log_entrada;
    //    Fim - LOG
}