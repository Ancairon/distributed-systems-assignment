package org.hua.dit.dsproject.pet;

import javax.persistence.*;

@Entity(name = "PET")
@Table
public class Pet {
    @Id
    @Column( name = "SERIAL_NUMBER")
    //@SequenceGenerator(name = "pet_sequence", sequenceName = "pet_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_sequence")
    private int serialNumber;
    @Column( name = "RACE")
    private String race;
    @Column( name = "SEX")
    private char sex;
    @Column( name = "BIRTHDAY")
    private String birthday;
    @Column( name = "OWNER_ID")
    private String ownerID;


    public Pet() {

    }

    public Pet(String labrador_retriever, char m, String of) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Pet(String race, char sex, String birthday, String ownerID) {
        this.race = race;
        this.sex = sex;
        this.birthday = birthday;
        this.ownerID = ownerID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return "This pet is a " + (this.sex == 'M' ? "male" : "female") + " " + this.race + " born on " + this.birthday;
    }
}
