package com.codex.aposta.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.codex.aposta.model.Aposta;
import com.codex.aposta.model.Apostador;
import com.codex.aposta.repository.ApostaRepository;

@DataJpaTest
class ApostaRepositoryIT {

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void createAposta_WithValidData_ReturnsAposta() {
        
        Apostador apostador = new Apostador();
       
        apostador = testEntityManager.persist(apostador);

     
        Aposta APOSTA = new Aposta("1", apostador);

        
        Aposta aposta = apostaRepository.save(APOSTA);

       
        Aposta sut = testEntityManager.find(Aposta.class, aposta.getNumeroAposta());

        
        assertThat(sut).isNotNull();
        assertThat(sut.getNumeroAposta()).isEqualTo(APOSTA.getNumeroAposta());
    }
}
