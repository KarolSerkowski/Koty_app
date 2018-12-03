package java_test.Learning;

import java.util.Date;
public class Kot {

    private String name;
    private String ovner;
    private Date dateOfBirth;
    private Float weight;


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setOvner(String ovner) {
        this.ovner = ovner;
    }

    public String getOvner() {
        return ovner;
    }

    public String getName() {
        return name;
    }

}
