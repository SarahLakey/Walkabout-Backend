package org.launchcode.Walkabout_Backend.repository;

import org.launchcode.Walkabout_Backend.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
}
