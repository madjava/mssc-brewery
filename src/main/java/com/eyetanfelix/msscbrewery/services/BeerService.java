package com.eyetanfelix.msscbrewery.services;

import com.eyetanfelix.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID bearId);

    BeerDto saveNewBear(BeerDto beerDto);

    void updateBeer(UUID beeId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
