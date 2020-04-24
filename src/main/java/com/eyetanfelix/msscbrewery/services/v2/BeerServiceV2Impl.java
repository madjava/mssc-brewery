package com.eyetanfelix.msscbrewery.services.v2;

import com.eyetanfelix.msscbrewery.services.BeerService;
import com.eyetanfelix.msscbrewery.web.model.v2.BeerDtoV2;
import com.eyetanfelix.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID bearId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .bearName("Galaxy Cat")
                .bearStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBear(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beeId, BeerDtoV2 beerDto) {
//TODO impl
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("delete...");
    }
}
