package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

//2.1 Model/Skill class, add field for description.
//Added validation to description to make it required.
//Enforce character limit.

@Size(max = 500, message = "Description must be under 500 characters.")
private String description;


//4.1 Added list of jobs as a field
//Added Many-To-Many annotation, likewise job required many skill, any skill can be associated with several jobs.
@ManyToMany(mappedBy="skills")
@NotNull
private List<Job> jobs = new ArrayList<>();


//No-arg constructor -required for Hibernate- to create an object
    public Skill () {}

//With Arg Constructor
//    public Skill(String description) {
//        super();
//        this.description = description;
//    }

//Getters and Setter for description field
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //Add getter/setter for List Job field
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
