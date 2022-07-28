package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.excepions.AlunoNotFoundExcepition;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import me.dio.academia.digital.service.mapper.AcademiaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	private AcademiaMapper mapper;

	public AvaliacaoFisicaServiceImpl(AcademiaMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = mapper.AvaliacaoForParaAvaliacao(form);
		if(avaliacaoFisica != null) {
			avaliacaoFisica.setAluno(alunoRepository.findById(form.getAlunoId()).orElseThrow(
					() -> new AlunoNotFoundExcepition(form.getAlunoId())));
			return avaliacaoFisicaRepository.save(avaliacaoFisica);
		}
		 
		throw new NullPointerException("O objeto avalição está nulo");
		
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		return avaliacaoFisicaRepository.findById(id).orElseThrow(
				() -> new AlunoNotFoundExcepition(id));
	}

	@Override
	public List<AvaliacaoFisicaDto> getAll() {
		List<AvaliacaoFisica> listAvalicao = avaliacaoFisicaRepository.findAll();
		return mapper.listaAvaliacaoParaListaDto(listAvalicao);
	}

	@Override
	public AvaliacaoFisicaDto update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacaoFisica = this.get(id);
		return mapper.AvaliacaoParaDto(formUpdate.atualizar(avaliacaoFisica));
	}

	@Override
	public void delete(Long id) {

	}
}
