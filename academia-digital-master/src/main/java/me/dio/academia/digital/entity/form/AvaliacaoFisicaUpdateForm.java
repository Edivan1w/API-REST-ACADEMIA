package me.dio.academia.digital.entity.form;

import me.dio.academia.digital.entity.AvaliacaoFisica;

public class AvaliacaoFisicaUpdateForm {

	private double peso;

	private double altura;

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

	public  AvaliacaoFisica atualizar(AvaliacaoFisica avaliacaoFisica) {
		avaliacaoFisica.setAltura(this.altura);
		avaliacaoFisica.setPeso(this.getPeso());
		return avaliacaoFisica;
	}

}
