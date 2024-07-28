package model;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName="usuario")
public class Usuario {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(dataType=DataType.STRING)
    private String nome;

    @DatabaseField(dataType=DataType.STRING)
    private String email;

    @DatabaseField(dataType=DataType.STRING)
    private String senha;

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}

