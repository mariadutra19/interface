package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario {

    private SimpleIntegerProperty id;
    private SimpleStringProperty nome;
    private SimpleStringProperty senha;
    private SimpleStringProperty email;

    public Usuario(int id, String nome, String senha, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.senha = new SimpleStringProperty(senha);
        this.email = new SimpleStringProperty(email);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getSenha() {
        return senha.get();
    }

    public void setSenha(String senha) {
        this.senha.set(senha);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
