package com.example.dashboardcompany;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    //Inicio - Mostrar erro de conexão com o banco de dados.
//    @FXML
//    private Label txtErro;


    //Fim - Mostrar erro de conexão com o banco de dados.

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
    @FXML
    ImageView img_url;
    Button myButton;

    Image avatar = new Image(String.valueOf(getClass().getResourceAsStream("https://mudae.net/uploads/8675696/nYV4Axktn_y36zfSIzYM~FAvIhFz.png")));
    public void displayImage() {
        img_url.setImage(avatar);
    }
}