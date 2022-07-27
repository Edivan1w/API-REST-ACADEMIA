package me.dio.academia.digital.entity.form;


public class AvaliacaoFisicaForm {

  //@Positive(message = "O Id do aluno precisa ser positivo.")
  private Long alunoId;

  //@NotNull(message = "Preencha o campo corretamente.")
  //@Positive(message = "${validatedValue}' precisa ser positivo.")
  private double peso;

  //@NotNull(message = "Preencha o campo corretamente.")
  //@Positive(message = "${validatedValue}' precisa ser positivo.")
  //@DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double altura;

public Long getAlunoId() {
	return alunoId;
}

public void setAlunoId(Long alunoId) {
	this.alunoId = alunoId;
}

public double getPeso() {
	return peso;
}

public void setPeso(double peso) {
	this.peso = peso;
}

public double getAltura() {
	return altura;
}

public void setAltura(double altura) {
	this.altura = altura;
}
  
  
}
