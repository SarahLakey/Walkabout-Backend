package org.launchcode.Walkabout_Backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Data
@Table(name = "steps")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
//    @JsonFormat(pattern="MM-dd-YYYY", shape = JsonFormat.Shape.STRING)
    private Date date;

    private int steps;

    private String location;




}
