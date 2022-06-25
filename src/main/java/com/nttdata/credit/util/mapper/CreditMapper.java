package com.nttdata.credit.util.mapper;

import com.nttdata.credit.domain.dto.CreateCreditRequest;
import com.nttdata.credit.domain.dto.CreditResponse;
import com.nttdata.credit.domain.dto.UpdateCreditRequest;
import com.nttdata.credit.infraestructure.data.document.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CreditMapper {

    @Mapping(target = "id",ignore = true)
    Credit toCredit(CreateCreditRequest createCreditRequest);

    CreditResponse toCreditResponse(Credit credit);

    @Mapping(target = "id", ignore = true)
    void updateCreditFromRquest(UpdateCreditRequest updateCreditRequest, @MappingTarget Credit credit);
}
