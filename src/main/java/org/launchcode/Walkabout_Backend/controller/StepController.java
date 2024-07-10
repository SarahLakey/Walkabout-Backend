package org.launchcode.Walkabout_Backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.Step;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.service.StepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*") //allows backend to communicate with frontend
public class StepController {

    private final StepService stepService;

    @PostMapping("/stepCounter")
    public Step postStep(@RequestBody Step step){
        return stepService.postStep(step);
    }

    @GetMapping("/steps")
    public List<Step> getAllSteps(){
        return stepService.getAllSteps();
    }


    @DeleteMapping("/steps/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id")Long id){
        try {
            stepService.deleteSteps(id);
            return new ResponseEntity<>("User with ID " + id + " deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/steps/{id}")
    public ResponseEntity<?> getStepById (@PathVariable ("id") Long id){
        Step step = stepService.getStepById(id);

        if(step == null) return  ResponseEntity.notFound().build();
        return  ResponseEntity.ok(step);
    }

    @PatchMapping("/steps/{id}")
    public ResponseEntity<?> updateStep(@PathVariable("id") Long id,
                                        @RequestBody Step step){
        Step updateStep = stepService.updateStep(id, step);

        if (updateStep == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateStep);
    }


}
