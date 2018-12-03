package java_test.Learning;

import java.util.ArrayList;
import java.util.List;

public class KotDao {

    List<Kot> catList = new ArrayList<Kot>();

    public void addCat(Kot addedCat){
        catList.add(addedCat);
        System.out.println("Kot został dodany");

    }

    public List<Kot> getCats(){
        return catList;


    }

}

