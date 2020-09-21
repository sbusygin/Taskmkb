package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.model.Assessment;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.assessment.AssessmentService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;
    @Autowired
    private AirplaneService airplaneService;
    @Autowired
    private AssessmentService assessmentService;

    private void fillAssessments(List<Assessment> previousAssessments, Assessment newAssessment) {
        previousAssessments.add(newAssessment);
    }

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        Assessment assessment;
        if(object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }
            assessment = assessmentService.save(car.getValue());
            return Optional.of(car)
                    .map(carService::fromDto)
                    .map(carStream -> {
                        Long id = carStream.getId();
                        List<Assessment> list = new ArrayList<>();
                        if (id != null) {
                            list = carService.load(id).get().getAssessments();
                        }
                        fillAssessments(list, assessment);
                        carStream.setAssessments(list);
                        return carService.save(carStream);
                    })
                    .map(carService::getId)
                    .orElse(null);
        } else if (object instanceof AirplaneDto) {
            AirplaneDto airplane = (AirplaneDto) object;
            boolean approved = airplaneService.approve(airplane);
            if (!approved){
                return null;
            }
            assessment = assessmentService.save(airplane.getValue());
            return Optional.of(airplane)
                    .map(airplaneService::fromDto)
                    .map(airplaneStream -> {
                        Long id = airplaneStream.getId();
                        List<Assessment> list = new ArrayList<>();
                        if (id != null) {
                            list = airplaneService.load(id).get().getAssessments();
                        }
                        fillAssessments(list, assessment);
                        airplaneStream.setAssessments(list);
                        return airplaneService.save(airplaneStream);
                    })
                    .map(airplaneService::getId)
                    .orElse(null);
        } else throw new IllegalArgumentException();
    }

    public Collateral getInfo(Collateral object) {
        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        } else if (object instanceof AirplaneDto) {
            return Optional.of((AirplaneDto) object)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::getId)
                    .flatMap(airplaneService::load)
                    .map((airplaneService::toDTO))
                    .orElse(null);
            } else throw new IllegalArgumentException();
        }
    }

