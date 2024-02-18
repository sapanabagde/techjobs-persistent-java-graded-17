package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    //2.1 Model/Employer class, add field for location.
    //Added validation to location to make it required.
    //Enforce character limit.

   @NotBlank(message = "Location is required.")
   @Size (min = 3, max = 50, message = "Location must be between 3 to 50 characters.")
    private String location;


   //3.1-Adding private property job of type List<Job> and initializing to an empty arraylist,
   //this list will represent the list of all items in a given job
   //3.2-one to many relationship between Employer entity and its associated Job entities.
   //The employer_id column in database will be used to link these entities.

   @OneToMany
   @JoinColumn(name = "employer_id")
   private final List<Job> jobs = new ArrayList<>();

   //2.2 No-arg constructor required for Hibernate to create an object.
    public Employer() {
    }

// With Arg Constructor, As well declaring super class since inheritate in abstract class
    public Employer(String location) {
        super();
        this.location = location;
    }

//Getters and Setter for location field
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
