package com.neelesh.webfluxstockservice.service;

import com.neelesh.webfluxstockservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream(Duration period);

}
