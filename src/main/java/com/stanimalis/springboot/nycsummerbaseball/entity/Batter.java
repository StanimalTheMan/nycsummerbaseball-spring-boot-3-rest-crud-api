package com.stanimalis.springboot.nycsummerbaseball.entity;

import jakarta.persistence.*;

@Entity
@Table(name="batter")
public class Batter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="avg")
    private double avg;

    @Column(name="hr")
    private short hr;

    @Column(name="rbi")
    private short rbi;

    @Column(name="ops")
    private double ops;

    // need default constructor for entity to avoid error
    public Batter() {

    }

    public Batter(String firstName, String lastName, double avg, short hr, short rbi, double ops) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avg = avg;
        this.hr = hr;
        this.rbi = rbi;
        this.ops = ops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public short getHr() {
        return hr;
    }

    public void setHr(short hr) {
        this.hr = hr;
    }

    public short getRbi() {
        return rbi;
    }

    public void setRbi(short rbi) {
        this.rbi = rbi;
    }

    public double getOps() {
        return ops;
    }

    public void setOps(double ops) {
        this.ops = ops;
    }

    @Override
    public String toString() {
        return "Batter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avg=" + avg +
                ", hr=" + hr +
                ", rbi=" + rbi +
                ", ops=" + ops +
                '}';
    }
}
