package me.dio.academia.digital.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.AlunoDto;

@Component
public class AcademiaMapper {

	
	private static final ModelMapper MAPPER_ACADEMIA = new ModelMapper();

	public AlunoDto AlunoParaDto(Aluno aluno) {
		return MAPPER_ACADEMIA.map(aluno, AlunoDto.class);
	}
	
	public List<AlunoDto> listaAlunoParaListaDto(List<Aluno> list) {
		return list.stream().map(this::AlunoParaDto).collect(Collectors.toList());
	}

	
}
