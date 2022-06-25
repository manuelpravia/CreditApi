package com.nttdata.credit.domain.service;

import com.nttdata.credit.exception.CreditNotFoundException;
import com.nttdata.credit.infraestructure.data.document.Credit;
import com.nttdata.credit.infraestructure.data.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Mono<Credit> validateAndGetCredit(String id) {
        return creditRepository.findById(id).switchIfEmpty(Mono.error(new CreditNotFoundException(id)));
    }

    @Override
    public Flux<Credit> getCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Mono<Void> deleteCredit(Credit credit) {
        return creditRepository.delete(credit);
    }
}
