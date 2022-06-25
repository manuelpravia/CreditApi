package com.nttdata.credit.domain.service;

import com.nttdata.credit.infraestructure.data.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {

    Mono<Credit> validateAndGetCredit(String id);

    Flux<Credit> getCredits();

    Mono<Credit> saveCredit(Credit credit);

    Mono<Void> deleteCredit(Credit credit);
}
