package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="nurses")
public class Nurse {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String specialize;
    private String shift;
    @OneToMany(targetEntity = Patient.class)
    private Set<Patient> patients;

    public Nurse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecialize(String shift) {
        this.specialize = specialize;
    }
    public String getSpecialize() {
        return specialize;
    }
    public void setShift(String shift) {
        this.shift = shift;
    }
    public String getShift() {
        return shift;
    }


    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
