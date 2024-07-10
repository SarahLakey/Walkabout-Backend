package org.launchcode.Walkabout_Backend.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.Step;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.repository.StepRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StepService {

    //injected repository
    private final StepRepository stepRepository;

    //save method
    public Step postStep(Step step){
        return stepRepository.save(step);
    }

    //return list of all steps
    public List<Step> getAllSteps(){
        return stepRepository.findAll();
    }

    //delete steps
    public void deleteSteps(Long id){

        //first check existence of steps
        if (!stepRepository.existsById(id)){
            throw new EntityNotFoundException("Step input with ID " + id + " not found");
        }
        stepRepository.deleteById(id);

    }


    //Creating Get Step Count by ID
    public Step getStepById(Long id) {
        return stepRepository.findById(id).orElse(null);
    }

    public Step updateStep(Long id, Step step){
        Optional<Step> optionalStep = stepRepository.findById(id);

        if (optionalStep.isPresent()){
            Step existingStep = optionalStep.get();

            existingStep.setDate(step.getDate());
            existingStep.setSteps(step.getSteps());
            existingStep.setLocation(step.getLocation());


            return  stepRepository.save(existingStep);
        }
        return null;
    }


}
