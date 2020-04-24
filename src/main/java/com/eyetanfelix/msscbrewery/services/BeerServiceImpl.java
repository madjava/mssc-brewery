package com.eyetanfelix.msscbrewery.services;

import com.eyetanfelix.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID bearId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .bearName("Galaxy Cat")
                .bearStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBear(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beeId, BeerDto beerDto) {
//TODO impl
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("delete...");
    }
}
