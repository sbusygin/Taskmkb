package com.mcb.creditfactory.service.assessment;

import com.mcb.creditfactory.model.Assessment;
import com.mcb.creditfactory.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {
    @Autowired
    private AssessmentRepository repository1;

    @Override
    public Assessment save(Assessment assessment) {
        return repository.save(assessment);
    }

    @Override
    public Assessment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Assessment> getAll() {
        return repository.all();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Assessment save(BigDecimal value) {
        return repository.save(new Assessment(value));
    }
}
