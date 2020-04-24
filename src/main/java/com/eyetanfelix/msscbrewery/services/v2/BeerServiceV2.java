package com.eyetanfelix.msscbrewery.services.v2;

import com.eyetanfelix.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID bearId);

    BeerDtoV2 saveNewBear(BeerDtoV2 beerDto);

    void updateBeer(UUID beeId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
