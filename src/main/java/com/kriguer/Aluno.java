package com.kriguer;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private String cidade;
    private String estado;

    public  Aluno(){

    }

    public Aluno(int id, String nome, int idade, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Aluno(String nome, int idade, String cidade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                " id= " + id +
                ", nome= " + nome +
                ", idade= " + idade +
                ", cidade= " + cidade +
                ", estado= " + estado +
                '}';
    }
}
