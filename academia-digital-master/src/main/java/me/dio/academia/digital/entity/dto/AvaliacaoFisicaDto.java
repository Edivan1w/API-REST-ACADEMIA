package me.dio.academia.digital.entity.dto;

import java.time.LocalDateTime;


import me.dio.academia.digital.entity.Aluno;

public class AvaliacaoFisicaDto {

	private Aluno aluno;
	private LocalDateTime dataDaAvaliacao = LocalDateTime.now();
	private double peso;
	private double altura;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDateTime getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}

	public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
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
