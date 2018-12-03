package java_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import java_test.Learning.Kot;
import java_test.Learning.KotDao;

public class Interfejs {
    public static Scanner odczyt = new Scanner(System.in);
    public static KotDao tableCats = new KotDao();


    public static void main(String[] args) {
        String choiceUser;

        do {
            System.out.println("wybierz co chcesz zrobic:");
            System.out.println("wybierz 1 - aby dodać nowego kota do listy");
            System.out.println("wybierz 2 - aby wyświetlić liste kotów");
            System.out.println("wybierz x - aby zamknąc program");
            choiceUser = readFromUserData();

            switch (choiceUser) {
                case "1":
                    addCats();
                    break;
                case "2":
                    showCats();
                    break;
                case "x":
                    break;


            }

        }

        while (!choiceUser.equals("x"));
    }

    public static Kot addCats(){

        Kot klakier = new Kot();

        SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");


        System.out.println("Napisz imie dla kota: ");
        klakier.setName(readFromUserData());

        System.out.println(" Podaj imie wlasciciela:");
        klakier.setOvner(readFromUserData());

        do {
            System.out.println(" Podaj masę kota:");

            String weightCatFromUser = readFromUserData();
            if (validationWeight(weightCatFromUser)) {

                klakier.setWeight(Float.parseFloat(weightCatFromUser));
            } else {
                System.out.println("Podałeś niepoprawną masę kota - popraw ją!");
            }
        }
        while (klakier.getWeight() == null);

        do {
            System.out.println(" Podaj datę urodzenia kota:");

            try {
                klakier.setDateOfBirth(parseDate.parse(readFromUserData()));
            } catch (ParseException pe) {
                System.out.println("Coś jest nie tak z formatem daty! Przykładowa data: 2014.01.05");
            }
        }
        while (klakier.getDateOfBirth() == null);
        System.out.println("Kot ma na imie " + klakier.getName() + " a jego wlasiciel ma na imie " + klakier.getOvner() + " Kocur waży " + klakier.getWeight() + " kg, oraz urodził się:" + klakier.getDateOfBirth());


        tableCats.addCat(klakier);

        return klakier;
    }


    public static void showCats(){
        //                for (Kot kot : tableCats.getCats() ){
        Kot kot;
        for (int i=0; i< tableCats.getCats().size();i++ ){
            kot = tableCats.getCats().get(i);
            System.out.println("Kot numer: "+i+" "+kot.getName());
        }

        String numerKota;

        do{
            System.out.println("Wybierz nr kota którego wyswietlisz szczegóły");


            numerKota = readFromUserData();

            if ((validationNumberCats(numerKota))&& (tableCats.getCats().size()>=Integer.parseInt(numerKota)) ){
                kot = tableCats.getCats().get(Integer.parseInt(numerKota));
                System.out.println("Kot numer: "+numerKota+" "+kot.getName());
                System.out.println("Właściciel kota: "+ kot.getOvner());
                System.out.println("Waga kota: "+ kot.getWeight());
                System.out.println("urodziny kota: "+ kot.getDateOfBirth());
                numerKota = "007";
            }
            else
                System.out.println("Podaj poprawny numer Kota lub wpisz 007 aby wyjsc do menu głównego");

        }

        while (!numerKota.equals("007"));

    }

    public static String readFromUserData(){
        return odczyt.nextLine().trim();
    }

    public static  Boolean validationNumberCats (String NumberCat) {
        String NumberCatGetFromUser = NumberCat;
        Pattern patternNumberCat = Pattern.compile("[0-9]+");
        if (patternNumberCat.matcher(NumberCatGetFromUser).matches()) {
            return true;
        } else {
            return false;
        }
    }


    public static  Boolean validationWeight(String weight){
        String weightGetFromUser = weight;
        Pattern patternWeight = Pattern.compile("[1-9]{1}");
        if (patternWeight.matcher(weightGetFromUser).matches()) {
            return true;
        }
        else{
            return false;
        }



    }
}
