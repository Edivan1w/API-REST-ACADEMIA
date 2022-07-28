package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.AvaliacaoFisicaDto;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import me.dio.academia.digital.service.mapper.AcademiaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private AvaliacaoFisicaServiceImpl service;
  
 private AcademiaMapper mapper;
  
  public AvaliacaoFisicaController (AcademiaMapper mapper) {
	  this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<AvaliacaoFisicaDto> create(@RequestBody AvaliacaoFisicaForm form, UriComponentsBuilder builder) {
	  AvaliacaoFisica avaliacaoFisica = service.create(form);
	  URI uri = builder.path("/avaliacoes/{id}").buildAndExpand(avaliacaoFisica.getId()).toUri();
	  return ResponseEntity.created(uri).body(mapper.AvaliacaoParaDto(avaliacaoFisica));
  }

  @GetMapping
  public ResponseEntity<List<AvaliacaoFisicaDto>> getAll(){
    return ResponseEntity.ok(service.getAll());
  }
  
  @PostMapping
  public ResponseEntity<AvaliacaoFisicaDto> update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm form) {
	  return ResponseEntity.ok(service.update(id, form));
  }

}
