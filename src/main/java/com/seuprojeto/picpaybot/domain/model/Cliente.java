package com.seuprojeto.picpaybot.domain.model;

public class Cliente {
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String celular;
    private String dataNascimento;

    public Cliente() {}

    public Cliente(String cpf, String nomeCompleto, String email, String celular, String dataNascimento) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
}
