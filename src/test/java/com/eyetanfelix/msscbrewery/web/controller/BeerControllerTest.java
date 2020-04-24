package com.eyetanfelix.msscbrewery.web.controller;

import com.eyetanfelix.msscbrewery.services.BeerService;
import com.eyetanfelix.msscbrewery.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    private BeerDto validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .bearName("Beer1")
                .bearStyle("PALE_ALE")
                .upc(1234L)
                .build();
    }

    @Test
    void testGetBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.bearName", is("Beer1")));
    }

    @Test
    void testHandlePost() throws Exception {
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto savedBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .bearStyle("New Beer")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String beerDtoJson = objectMapper.writeValueAsString(validBeer);

        given(beerService.saveNewBear(any())).willReturn(savedBeer);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void testHandleUpdate() throws Exception {

        BeerDto beerDto = validBeer;
        ObjectMapper objectMapper = new ObjectMapper();
        String beerDtoJson = objectMapper.writeValueAsString(validBeer);

        mockMvc.perform(put("/api/v1/beer/" + validBeer.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }

    @Test
    void testDeleteBeer() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/" + validBeer.getId().toString()))
                .andExpect(status().isNoContent());
    }
}