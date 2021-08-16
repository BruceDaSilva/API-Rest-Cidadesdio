package com.github.BruceDaSilva.estados.recursos;

import com.github.BruceDaSilva.estados.entidades.Estado;

import com.github.BruceDaSilva.estados.repositorios.EstadoRepositorio;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/Estados")

public class EstadoRecurso {

  private final EstadoRepositorio repositorio;

  public EstadoRecurso(final EstadoRepositorio repositorio) { this.repositorio = repositorio; }

  @GetMapping
  public List<Estado> estados() { return repositorio.findAll(); }
}
