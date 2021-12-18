package org.hua.dit.dsproject.pet;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Pet {
    @Id
    @SequenceGenerator(name = "pet_sequence", sequenceName = "pet_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_sequence")
    private int serialNumber;

    private String race;
    private char sex;
    private LocalDate birthday;

    public Pet(String race, char sex, LocalDate birthday, int serialNumber) {
        this.race = race;
        this.sex = sex;
        this.birthday = birthday;
        this.serialNumber = serialNumber;
    }

    public Pet() {

    }

    public Pet(String labrador_retriever, char m, LocalDate of) {
        this.race = labrador_retriever;
        this.sex = m;
        this.birthday = of;
    }


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "This pet is a " + (this.sex == 'M' ? "male" : "female") + " " + this.race + " born on " + this.birthday.toString();
    }
}
