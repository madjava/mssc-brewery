package com.eyetanfelix.msscbrewery.services;

import com.eyetanfelix.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID bearId);
}
