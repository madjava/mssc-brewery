package com.eyetanfelix.msscbrewery.services;

import com.eyetanfelix.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID bearId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .bearName("Galaxy Cat")
                .bearStyle("Pale Ale")
                .build();
    }
}
