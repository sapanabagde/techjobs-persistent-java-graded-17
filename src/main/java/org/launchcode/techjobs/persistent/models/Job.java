package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

//3.2.1 Updated the class definition of Job to extend AbstractEntity, since name and id already existed there.
//removed name and id fields from this class.

@Entity
public class Job extends AbstractEntity {


    //3.2.2-Replaced field type(String) of employer, to type Employer
    //3.2.3-Add the @ManyToOne annotation on the field employer
    @ManyToOne
    private Employer employer;



    //4.2.1 Updated Job model class to fit its many-to-many relationship with skills
    @ManyToMany
    @NotNull(message = "Skill is required.")
    private List<Skill> skills;

    public Job() {
    }

    //3.1.2-Refactored Constructor for Type Employer
    //4.2.3- Refactored Constructor for Type Skill
    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    //3.1.2-Refactored Getter and setters with Type Employer
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }


    //4.2-Refactored Getter and setters with List <Skill>

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
