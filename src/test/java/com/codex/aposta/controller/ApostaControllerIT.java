package com.codex.aposta.controller;

import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.model.dto.ApostaOut;
import com.codex.aposta.model.dto.ApostasOut;
import com.codex.aposta.service.ApostaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ApostaController.class)
class ApostaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ApostaService apostaService;

    @Test
    void createAposta_WithValidData_ReturnsCreated() throws Exception {
       
        ApostaIn apostaIn = new ApostaIn(1L);
        ApostaOut apostaOut = new ApostaOut("123456", "Marcos Silva", "marcos@gmail.com");
        when(apostaService.salvaAposta(apostaIn)).thenReturn(apostaOut);

       
        mockMvc.perform(post("/aposta")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apostaIn)))
                .andExpect(status().isCreated());
    }

    @Test
    void buscaApostasPorIdApostador_WithValidId_ReturnsApostas() throws Exception {
        
        Long idApostador = 1L;
        List<ApostasOut> apostas = Collections.singletonList(new ApostasOut("123456", "Marcos Silva", "marcos@gmail.com"));
        when(apostaService.buscaApostasPorIdApostador(idApostador)).thenReturn(apostas);

        
        mockMvc.perform(get("/buscaApostasPorIdApostador/{idApostador}", idApostador)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                
    }

}