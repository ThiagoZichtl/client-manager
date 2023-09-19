package com.zichtl.clientmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"id"})
public class ClientDTO {

    private static final String NAME_REGEX = "([A-Z]{1}[a-z]+[ ]?)+";
    private static final String CPF_REGEX = "^[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2}";
    private static final String PHONE_REGEX = "[(][0-9]{2,3}[)][ ]?[0-9]{4,5}-[0-9]{4}";

    @NotBlank(message = "O campo do primeiro nome é obrigatório")
    @Size(min = 2, max = 150, message = "O nome deve conter pelo menos 2 letras.")
    @Pattern(regexp = NAME_REGEX, message = "O nome deve conter apenas letras.")
    private String firstName;

    @NotBlank(message = "O campo do sobrenome nome é obrigatório")
    @Size(min = 2, max = 150, message = "O nome deve conter pelo menos 2 letras.")
    @Pattern(regexp = NAME_REGEX, message = "O nome deve conter apenas letras.")
    private String lastName;

    @NotBlank(message = "O cpf não pode estar null ou vazio.")
    @Size(min = 11, max = 14, message = "O cpf deve conter 11 dígitos numéricos.")
    @Pattern(regexp = CPF_REGEX, message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Email(message = "O campo email deve conter um endereço de e-mail válido")
    @NotBlank(message = "O campo email é obrigatório")
    private String email;

    @NotBlank(message = "O campo de número de telefone é obrigatório")
    @Pattern(regexp = PHONE_REGEX, message = "O campo 'de telefone deve ter o formato (99) 99999-9999")
    @Size(min = 10, max = 20, message = "O campo de telefone deve ter 14 caracteres")
    private String phone;

//    @NotBlank(message = "O campo de data de nascimento é obrigatório")
    @Past(message = "Data de nascimento deve ser menor do que a data atual.")
    private LocalDate birthDate;

    public ClientDTO() {
    }

    public ClientDTO(String firstName, String lastName, String cpf, String email, String phone, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientDTO clientDTO = (ClientDTO) o;

        if (!cpf.equals(clientDTO.cpf)) return false;
        return email.equals(clientDTO.email);
    }

    @Override
    public int hashCode() {
        int result = cpf.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
