package me.dio.academia.digital.entity.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import me.dio.academia.digital.entity.AvaliacaoFisica;

public class AlunoDto {
	
	  private Long id;
	  private String nome;
	  private String cpf;
	  private String bairro;
	  private LocalDate dataDeNascimento;
	  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
	  
	  
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public List<AvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	  
	  

}
