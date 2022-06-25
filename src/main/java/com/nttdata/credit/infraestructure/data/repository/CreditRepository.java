package com.nttdata.credit.infraestructure.data.repository;

import com.nttdata.credit.infraestructure.data.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepository extends ReactiveMongoRepository<Credit,String> {
}
