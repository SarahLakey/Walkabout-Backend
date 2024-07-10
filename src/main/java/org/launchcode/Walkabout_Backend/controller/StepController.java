package org.launchcode.Walkabout_Backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.Step;
import org.launchcode.Walkabout_Backend.service.StepService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*") //allows backend to communicate with frontend
public class StepController {

    private final StepService stepService;

    @PostMapping("/step")
    public Step postStep(@RequestBody Step step){
        return stepService.postStep(step);
    }
}
