package org.szpax.plan.treningowy.model;

import org.szpax.plan.persistance.DbMock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-06-05.
 */


public class TrainingPlan {


    /**
     * zrobiliśmy tu plan treningowy. dziąła to tak ze mamy Mape 7 par, kluczem sa dni tygodnia a wartoscia sa puste listy
     * Listy zawieraja obiekty typu Excercise. ktore mozemy zapelniach , wprowadzajac
     * do nich konkretne cwiczenia
     */

    public static TrainingPlan create(){
        return new TrainingPlan();
    }

    private Map<String, List<Excercise>> trainigByDays = new HashMap<>();

    public static final String PONIEDZIALEK = "Poniedzialek";
    public static final String WTOREK = "Wtorek";
    public static final String SRODA = "Sroda";
    public static final String CZWARTEK = "Czwartek";
    public static final String PIATEK = "Piatek";
    public static final String SOBOTA = "Sobota";
    public static final String NIEDZIELA = "Niedziela";

    private static String[] weekDays = {PONIEDZIALEK, WTOREK, SRODA, CZWARTEK, PIATEK, SOBOTA, NIEDZIELA};

    private TrainingPlan() {
        for (String s : weekDays) {
            trainigByDays.put(s, new ArrayList<>());
        }
    }

    public Map<String, Double> getCaloriesByDays() {
        Map<String, Double> mapCaloriesByDays = new HashMap<>();
        for (String s : weekDays) {
            mapCaloriesByDays.put(s, caloriesDay(s));
        }
        return mapCaloriesByDays;
    }

    public void addExcercise(String day, String excerciseName, Integer repeats, Integer weight) {
        trainigByDays.get(day).add(new Excercise(excerciseName, repeats, weight)); // w tym miejscu ( tam gdzie dodajemy do listy nowy element new Excercise(excerciseName....) to jest jakiś magiczny skrót do tworzenie nowego obiekty excercise, na stronie Oracla funkcja add wyglada tak : .add(E e)
    }
    public Map<String, List<Excercise>> getTrainingByDays() {
        return trainigByDays;
    }
    // po co tam jest static w tej metodzie powyzej?
    // blad to robisz gdy tworzysz nowy obiekt w main-e - private Double suma = new suma;
    //blad to robisz gdy tworzysz nowy obiekt w main-e - private Integer n = new n;

    public static void addUser(String name) {
        DbMock.usersList.add( new User(name)); /// nosz kurna analogicznie do add excercise jes utworzone a nie dziala .. ;/
    }

    //__________________________________________________________________________________________________________________
    //                            Metods calculate the calories for eatch day:


    private Double caloriesDay(String day) {
        Double suma = 0D;
        Integer n;  // zmienne zdefiniowane tylko dla metody ( dlatego są w Ciele metody) i dlatego nie potrzebny jest modyfikator dostepu.

        n = trainigByDays.get(day).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(day).get(i).calorieslocal();// no wlasnie i co dalej ;p jak dobrac sie do hipotetycznych cwiczen w tej liscie ;p


        }
        return suma;
    }
    // _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
    //                                            Method that calculate calories for a week

    public Double caloriesTotal() {
        Double suma = 0D;
        for (String s : weekDays) {
            suma = +caloriesDay(s);
        }
        return suma;
    }
    //__________________________________________________________________________________________________________________


}