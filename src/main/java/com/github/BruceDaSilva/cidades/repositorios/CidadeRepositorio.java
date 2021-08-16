package com.github.BruceDaSilva.cidades.repositorios;

import com.github.BruceDaSilva.cidades.entidades.Cidade;

import org.springframework.data.jpa.repositorio.JpaRepositorio;

import org.springframework.data.jpa.repositorio.Query;

public interface CidadeRepositorio extends JpaRepositorio<Cidade, Long> {

  @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
  
  Double distanceByPoints(final Long cidadeId1, final Long cidadeId2);

  @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
  
  Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);
}
