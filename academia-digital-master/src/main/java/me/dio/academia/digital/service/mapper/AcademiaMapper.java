package me.dio.academia.digital.service.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.AlunoDto;
import me.dio.academia.digital.entity.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;

@Component
public class AcademiaMapper {

	
	private static final ModelMapper MAPPER_ACADEMIA = new ModelMapper();

	public AlunoDto AlunoParaDto(Aluno aluno) {
		return MAPPER_ACADEMIA.map(aluno, AlunoDto.class);
	}
	
	public List<AlunoDto> listaAlunoParaListaDto(List<Aluno> list) {
		return list.stream().map(this::AlunoParaDto).collect(Collectors.toList());
	}
	
	public Aluno AlunoForParaAluno(AlunoForm form) {
		return MAPPER_ACADEMIA.map(form, Aluno.class);
	}

	public AvaliacaoFisicaDto AvaliacaoParaDto(AvaliacaoFisica avaliacao) {
		return MAPPER_ACADEMIA.map(avaliacao, AvaliacaoFisicaDto.class);
	}
	
	public List<AvaliacaoFisicaDto> listaAvaliacaoParaListaDto(List<AvaliacaoFisica> list) {
		return list.stream().map(this::AvaliacaoParaDto).collect(Collectors.toList());
	}
	
	public AvaliacaoFisica AvaliacaoForParaAvaliacao(AvaliacaoFisicaForm form) {
		return MAPPER_ACADEMIA.map(form, AvaliacaoFisica.class);
	}

	
}
