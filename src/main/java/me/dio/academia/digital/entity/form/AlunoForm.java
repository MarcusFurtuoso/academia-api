package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoForm {

  private String nome;

  private String cpf;

  private String bairro;

  private String dataDeNascimento;
}
