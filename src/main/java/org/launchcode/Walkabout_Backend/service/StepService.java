package org.launchcode.Walkabout_Backend.service;

import lombok.AllArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.Step;
import org.launchcode.Walkabout_Backend.repository.StepRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StepService {

    //injected repository
    private final StepRepository stepRepository;

    //method
    public Step postStep(Step step){
        return stepRepository.save(step);
    }
}
