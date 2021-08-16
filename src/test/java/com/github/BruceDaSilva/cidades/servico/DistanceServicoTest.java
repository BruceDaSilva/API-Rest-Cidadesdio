package com.github.BruceDaSilva.cidades.servico;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.data.Offset.offset;

import static org.mockito.ArgumentMatchers.anyList;

import static org.mockito.BDDMockito.given;

import com.github.BruceDaSilva.cidades.entidades.Cidade;

import com.github.BruceDaSilva.cidades.repositorios.CidadeRepositorio;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.data.geo.Point;

@SpringBootTest

class DistanceServicoTest {

  @Autowired
  
  private DistanceServico servico;

  @MockBean
  
  private CidadeRepositorio cidadeRepositorio;  private Cidade Guapirama;  private Cidade Ourinhos;

  @BeforeEach
  
  public void setUp() { guapirama = new Cidade(4929L, "Guapirama", 26, 3519303, "(-21.95840072631836,-47.98820114135742)",
                                    new Point(-21.95840072631836, -47.98820114135742));
                        ourinhos =  new Cidade(5254L, "Ourinhos", 26, 3548906, "(-22.01740074157715,-47.88600158691406)",
                                    new Point(-22.01740074157715, -47.88600158691406));
  }

  @Test
  public void shouldCalculateInMetersUsingMath() { given(cidadeRepositorio.findAllById(anyList())).willReturn(Arrays.asList(guapirama, ourinhos));
    Double distance = servico.distanceUsingMath(4929L, 5254L, EarthRadius.METERS);
    assertThat(distance).isEqualTo(12426.810463475855);
  }

  @Test
  public void shouldCalculateInKilometersUsingMath() { given(cidadeRepositorio.findAllById(anyList())).willReturn(Arrays.asList(guapirama, ourinhos));
    Double distance = servico.distanceUsingMath(4929L, 5254L, EarthRadius.KILOMETERS);
    assertThat(distance).isCloseTo(12.426, offset(0.001d));
  }

  @Test
  public void shouldCalculateInMilesUsingMath() { given(cidadeRepositorio.findAllById(anyList())).willReturn(Arrays.asList(guapirama, ourinhos));
    Double distance = servico.distanceUsingMath(4929L, 5254L, EarthRadius.MILES);
    assertThat(distance).isCloseTo(7.71, offset(0.01d));
  }


  @Test
  public void shouldCalculateInMetersUsingPoints() { given(cidadeRepositorio.findAllById(anyList())).willReturn(Arrays.asList(guapirama, ourinhos));
    Double distance = servico.distanceUsingPoints(4929L, 5254L, EarthRadius.METERS);
    assertThat(distance).isEqualTo(12426.810463475855);
  }
}