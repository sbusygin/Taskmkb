package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Assessment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssessmentRepository extends CrudRepository<Assessment, Long> {
    List<Assessment> all();
}
