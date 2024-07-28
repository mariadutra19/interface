package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import model.UsuarioRepositorio;
import view.AppView;

public class AppController implements Initializable {
    @FXML
    private TableView<view.Usuario> tabela;
    @FXML
    private TableColumn<view.Usuario, Integer> idCol;
    @FXML
    private TableColumn<view.Usuario, String> nomeCol;
    @FXML
    private TableColumn<view.Usuario, String> senhaCol;
    @FXML
    private TableColumn<view.Usuario, String> emailCol;
    @FXML
    private TextField idField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField senhaField;
    @FXML
    private TextField emailField;
    @FXML
    private Button adicionarButton;
    @FXML
    private Button atualizarButton;
    @FXML
    private Button deletarButton;
    @FXML
    private Button cancelarButton;
    @FXML
    private Button salvarButton;

    AppView appView;

    private static model.Database database = new model.Database("app.sqlite");
    private static model.UsuarioRepositorio usuarioRepo = new model.UsuarioRepositorio(database);

    public AppController() {
        this.appView = new AppView();
    }

    public static void main(String[] args) throws Exception {
        AppController appController = new AppController();
        Application.launch(AppView.class, args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(new PropertyValueFactory<view.Usuario, Integer>("id"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<view.Usuario, String>("nome"));
        senhaCol.setCellValueFactory(new PropertyValueFactory<view.Usuario, String>("senha"));
        emailCol.setCellValueFactory(new PropertyValueFactory<view.Usuario, String>("email"));

        tabela.setItems(atualizarTabela());
    }

    private ObservableList<view.Usuario> atualizarTabela() {
        List<model.Usuario> listaUsuarios = usuarioRepo.loadAll();
        ObservableList<view.Usuario> usuariosObservable = FXCollections.observableArrayList();
        for (model.Usuario usuario : listaUsuarios) {
            usuariosObservable.add(new view.Usuario(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getEmail()));
        }
        return usuariosObservable;
    }

    @FXML
    private void adicionarUsuario() {
        String nome = nomeField.getText();
        String senha = senhaField.getText();
        String email = emailField.getText();
        model.Usuario usuario = new model.Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuarioRepo.create(usuario);
        tabela.setItems(atualizarTabela());
        clearFields();
    }

    @FXML
    private void atualizarUsuario() {
        // Implementar lógica de atualização
    }

    @FXML
    private void deletarUsuario() {
        // Implementar lógica de deleção
    }

    @FXML
    private void clearFields() {
        idField.clear();
        nomeField.clear();
        senhaField.clear();
        emailField.clear();
    }

    @FXML
    private void cancelarOperacao() {
        clearFields();
    }
}
