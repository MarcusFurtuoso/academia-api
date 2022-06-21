package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoUpdateForm {

  private String nome;

  private String bairro;

  private String dataDeNascimento;
}
