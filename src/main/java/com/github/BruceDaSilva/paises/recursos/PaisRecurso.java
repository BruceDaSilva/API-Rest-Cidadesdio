package com.github.BruceDaSilva.paises.recursos;

import com.github.BruceDaSilva.paises.entidades.Pais;

import com.github.BruceDaSilva.paises.repositorios.PaisRepositorio;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisRecurso {

  private final PaisRepositorio repositorio;

  public PaisRecurso(final PaisRepositorio repositorio) {
    this.repositorio = repositorio;
  }

  @GetMapping("/paises")
  public List<Pais> cidades() {

    return repositorio.findAll();
  }
}