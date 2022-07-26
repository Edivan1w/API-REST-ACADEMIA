package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.dto.AlunoDto;
import me.dio.academia.digital.entity.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoServiceImpl service;

	@PostMapping
	public ResponseEntity<AlunoDto> create(@Valid @RequestBody AlunoForm form) {
		return ResponseEntity.ok(service.create(form));
	}

	@GetMapping("/avaliacoes/{id}")
	public ResponseEntity<List<AvaliacaoFisicaDto>> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return ResponseEntity.ok(service.getAllAvaliacaoFisicaId(id));
	}

	@GetMapping
	public ResponseEntity<List<AlunoDto>> getAll(
			@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento) {
		return ResponseEntity.ok(service.getAll(dataDeNacimento));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDto> get(Long id){
		return ResponseEntity.ok(service.get(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
