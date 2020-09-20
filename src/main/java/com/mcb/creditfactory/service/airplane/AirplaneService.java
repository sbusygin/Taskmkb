package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.model.Airplane;

import java.util.Optional;

public interface AirplaneService {
    boolean approve(AirplaneDto dto);
    Airplane save(Airplane car);
    Optional<Airplane> load(Long id);
    Airplane fromDto(AirplaneDto dto);
    AirplaneDto toDTO(Airplane car);
    Long getId(Airplane car);
}
