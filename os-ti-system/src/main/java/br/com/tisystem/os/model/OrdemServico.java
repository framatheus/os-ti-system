package br.com.tisystem.os.model;

import java.time.LocalDate;

public class OrdemServico {

    private Long id;
    private Cliente cliente;
    private LocalDate dataAbertura;
    private String descricaoProblema;
    private Double valor;
    private String status;

    public OrdemServico() {}

    public OrdemServico(Long id, Cliente cliente, LocalDate dataAbertura, String descricaoProblema, Double valor, String status) {
        this.id = id;
        this.cliente = cliente;
        this.dataAbertura = dataAbertura;
        this.descricaoProblema = descricaoProblema;
        this.valor = valor;
        this.status = status;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OS(id=" + id + ", cliente=" + cliente.getNome() +
                ", data=" + dataAbertura +
                ", status='" + status + '\'' +
                ", valor=" + valor + '}';
    }
}