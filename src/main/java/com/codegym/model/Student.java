package com.codegym.model;

public class Student {
    private int id;
    private String name;
    private String masv;
    private int age;
    private String address;
    public Student(){

    }
    public Student(int id, String name, String masv,int age, String address) {
        this.id = id;
        this.name = name;
        this.masv = masv;
        this.age = age;
        this.address = address;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasv() {
        return masv;
    }
    public String setMasv(String masv){return this.masv;}
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
