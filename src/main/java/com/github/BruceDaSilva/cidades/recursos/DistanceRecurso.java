package com.github.BruceDaSilva.cidades.recursos;

import com.github.BruceDaSilva.cidades.servico.DistanceServico;

import com.github.BruceDaSilva.cidades.servico.EarthRadius;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/distancias")

public class DistanceRecurso {

  Logger log = LoggerFactory.getLogger(DistanceRecurso.class);

  private final DistanceServico servico;

  public DistanciaRecurso(DistanceServico servico) { this.servico = servico; }

  @GetMapping("/by-points")
  
  public Double byPoints(@RequestParam(name = "from") final Long cidade1,
  
  @RequestParam(name = "to") final Long cidade2) {  log.info("byPoints");  return service.distanceByPointsInMiles(cidade1, cidade2); }

  @GetMapping("/by-cube")
  
  public Double byCube(@RequestParam(name = "from") final Long cidade1,
  @RequestParam(name = "to") final Long cidade2) {  log.info("byCube"); return service.distanceByCubeInMeters(cidade1, cidade2); }

  @GetMapping("/by-math")
  public Double byMath(@RequestParam(name = "from") final Long cidade1, @RequestParam(name = "to") final Long cidade2,
  @RequestParam final EarthRadius unit) {
	  
    log.info("byMath"); return service.distanceUsingMath(cidade1, cidade2, unit);
	
  }
}
