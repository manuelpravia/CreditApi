package com.nttdata.credit.api;

import com.nttdata.credit.domain.dto.CreateCreditRequest;
import com.nttdata.credit.domain.dto.CreditResponse;
import com.nttdata.credit.domain.dto.UpdateCreditRequest;
import com.nttdata.credit.domain.service.CreditService;
import com.nttdata.credit.infraestructure.data.document.Credit;
import com.nttdata.credit.util.mapper.CreditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("credits")
public class CreditApi {

    @Autowired
    private CreditService creditService;

    @Autowired
    private CreditMapper creditMapper;

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<CreditResponse> getCredits(){
        return creditService.getCredits().map(creditMapper::toCreditResponse);
    }

    @GetMapping("/{id}")
    public Mono<CreditResponse> getCredit(@PathVariable String id){
        return creditService.validateAndGetCredit(id).map(creditMapper::toCreditResponse);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<CreditResponse> createCredit(@Valid @RequestBody CreateCreditRequest createCreditRequest) {
        Credit credit = creditMapper.toCredit(createCreditRequest);
        return creditService.saveCredit(credit).map(creditMapper::toCreditResponse);
    }

    @PatchMapping("/{id}")
    public Mono<CreditResponse> updateCredit(@PathVariable String id,
                                               @RequestBody UpdateCreditRequest updateCreditRequest) {
        return creditService.validateAndGetCredit(id)
                .doOnSuccess(credit -> {
                    creditMapper.updateCreditFromRquest(updateCreditRequest, credit);
                    creditService.saveCredit(credit).subscribe();
                })
                .map(creditMapper::toCreditResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<CreditResponse> deleteCredit(@PathVariable String id) {
        return creditService.validateAndGetCredit(id)
                .doOnSuccess(credit -> creditService.deleteCredit(credit).subscribe())
                .map(creditMapper::toCreditResponse);
    }
}
