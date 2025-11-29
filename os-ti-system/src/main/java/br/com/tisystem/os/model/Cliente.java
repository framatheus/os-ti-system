package br.com.tisystem.os.model;

public class Cliente{

    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
    private String observacoes;

    public Cliente() {}

    public Cliente(Long id, String nome, String telefone, String endereco, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.observacoes = observacoes;
    }


    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString () {
        return "Cliente{id=" + id + ", nome='" + nome + '\'' + ", telefone='" + telefone + '\'' + ", endereço='" + endereco + '\'' + '}';
    }
}