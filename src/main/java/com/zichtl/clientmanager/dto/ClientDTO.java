package com.zichtl.clientmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class ClientDTO {
    private static final String NAME_REGEX = "[A-Za-z]*";

    @NotBlank(message = "O nome não pode estar null ou vazio.")
    @Pattern(regexp = NAME_REGEX, message = "O nome deve conter apenas letras.")
    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
