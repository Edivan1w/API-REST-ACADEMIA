package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.AlunoDto;
import me.dio.academia.digital.entity.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import me.dio.academia.digital.service.mapper.AcademiaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	private AlunoRepository repository;

	private final AcademiaMapper academiaMapper;

	public AlunoServiceImpl(AcademiaMapper academiaMapper) {
		this.academiaMapper = academiaMapper;
	}

	@Override
	public AlunoDto create(AlunoForm form) {
		return academiaMapper.AlunoParaDto(repository.save(academiaMapper.AlunoForParaAluno(form)));
	}

	@Override
	public AlunoDto get(Long id) {
		return academiaMapper.AlunoParaDto(repository.findById(id).get());
	}

	@Override
	public List<AlunoDto> getAll(String dataDeNascimento) {

		if (dataDeNascimento == null) {
			return academiaMapper.listaAlunoParaListaDto(repository.findAll());
		} else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return academiaMapper.listaAlunoParaListaDto(repository.findByDataDeNascimento(localDate));
		}
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<AvaliacaoFisicaDto> getAllAvaliacaoFisicaId(Long id) {
		return academiaMapper.listaAvaliacaoParaListaDto(repository.findById(id).get().getAvaliacoes());
	}

}
