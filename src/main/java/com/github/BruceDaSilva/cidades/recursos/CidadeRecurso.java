package com.github.BruceDaSilva.cidades.recursos;

import com.github.BruceDaSilva.cidades.entidades.Cidade;

import com.github.BruceDaSilva.cidades.repositorios.CidadeRepositorio;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("cidades")
 
 public class CidadeRecurso { private final CidadeRepositorio repositorio;

  public CidadeRecurso(final CidadeRepositorio repositorio) { this.repositorio = repositorio; }

  @GetMapping
  
  public Page<Cidade> cidades(final Pageable page) { return repositorio.findAll(page); }
}
