package com.codex.aposta.Repository;

import com.codex.aposta.model.Apostador;
import com.codex.aposta.repository.ApostadorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ApostadorRepositoryIT {

    @Autowired
    private ApostadorRepository apostadorRepository;

    @Test
    void findById_ExistingId_ReturnsApostador() {
      
        Apostador apostador = new Apostador(0, "Marcos Silva", "marcos@gmail.com");
        Apostador savedApostador = apostadorRepository.save(apostador);

        
        Optional<Apostador> foundApostador = apostadorRepository.findById(savedApostador.getId());

        
        assertTrue(foundApostador.isPresent());
        assertEquals(savedApostador.getId(), foundApostador.get().getId());
        assertEquals(savedApostador.getNome(), foundApostador.get().getNome());
        assertEquals(savedApostador.getEmail(), foundApostador.get().getEmail());
    }

    @Test
    void findById_NonExistingId_ReturnsEmpty() {
        
        Optional<Apostador> foundApostador = apostadorRepository.findById(-1L);

       
        assertTrue(foundApostador.isEmpty());
    }

   
}