package org.szpax.plan.treningowy.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-06-05.
 */


public class TraningPlan {


    /**
     * zrobiliśmy tu plan treningowy. dziąła to tak ze mamy Mape 7 par, kluczem sa dni tygodnia a wartoscia sa puste listy
     * Listy zawieraja obiekty typu Excercise. ktore mozemy zapelniach , wprowadzajac
     * do nich konkretne cwiczenia
     */
    private static Map<String, Double> mapCaloriesByDays = new HashMap<>();
    private static Map<String, List<Excercise>> trainigByDays = new HashMap<>();

    public static final String PONIEDZIALEK = "Poniedzialek";

    public static final String WTOREK = "Wtorek";

    public static final String SRODA = "Sroda";

    public static final String CZWARTEK = "Czwartek";

    public static final String PIATEK = "Piatek";

    public static final String SOBOTA = "Sobota";

    public static final String NIEDZIELA = "Niedziela";

    static {

        trainigByDays.put(PONIEDZIALEK, new ArrayList<>());
        trainigByDays.put(WTOREK, new ArrayList<>());
        trainigByDays.put(SRODA, new ArrayList<>());
        trainigByDays.put(CZWARTEK, new ArrayList<>());
        trainigByDays.put(PIATEK, new ArrayList<>());
        trainigByDays.put(SOBOTA, new ArrayList<>());
        trainigByDays.put(NIEDZIELA, new ArrayList<>());

    }

    public static Map<String, Double> getmapCaloriesByDays() {

        mapCaloriesByDays.put(PONIEDZIALEK, caloriesPoniedzialek());
        mapCaloriesByDays.put(WTOREK, caloriesWtorek());
        mapCaloriesByDays.put(SRODA, caloriesSroda());
        mapCaloriesByDays.put(CZWARTEK, caloriesCzwartek());
        mapCaloriesByDays.put(PIATEK, caloriesPiatek());
        mapCaloriesByDays.put(SOBOTA, caloriesSobota());
        mapCaloriesByDays.put(NIEDZIELA, caloriesNiedziela());

        return mapCaloriesByDays;
    }

    public static void addExcercise(String day, String excerciseName, Integer repeats, Integer weight) {
        trainigByDays.get(day).add(new Excercise(excerciseName, repeats, weight));
    }

    public static Map<String, List<Excercise>> getTrainingByDays() {
        return trainigByDays;
    }
    // po co tam jest static w tej metodzie powyzej?
    // blad to robisz gdy tworzysz nowy obiekt w main-e - private Double suma = new suma;
    //blad to robisz gdy tworzysz nowy obiekt w main-e - private Integer n = new n;


    //__________________________________________________________________________________________________________________
    //                            Metods calculate the calories for eatch day:


    public static Double caloriesPoniedzialek() {
        Double suma = 0D;
        Integer n;  // zmienne zdefiniowane tylko dla metody ( dlatego są w Ciele metody) i dlatego nie potrzebny jest modyfikator dostepu.

        n = trainigByDays.get(PONIEDZIALEK).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(PONIEDZIALEK).get(i).calorieslocal();// no wlasnie i co dalej ;p jak dobrac sie do hipotetycznych cwiczen w tej liscie ;p


        }
        return suma;
    }

    public static Double caloriesWtorek() {
        Double suma = 0D;
        Integer n;

        n = trainigByDays.get(WTOREK).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(WTOREK).get(i).calorieslocal();


        }
        return suma;
    }

    public static Double caloriesSroda() {
        Double suma = 0D;
        Integer n;

        n = trainigByDays.get(SRODA).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(SRODA).get(i).calorieslocal();


        }
        return suma;
    }

    public static Double caloriesCzwartek() {
        Double suma = 0D;
        Integer n;

        n = trainigByDays.get(CZWARTEK).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(CZWARTEK).get(i).calorieslocal();


        }
        return suma;
    }

    public static Double caloriesPiatek() {
        Double suma = 0D;
        Integer n;

        n = trainigByDays.get(PIATEK).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(PIATEK).get(i).calorieslocal();


        }
        return suma;
    }

    public static Double caloriesSobota() {
        Double suma = 0D;
        Integer n;

        n = trainigByDays.get(SOBOTA).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(SOBOTA).get(i).calorieslocal();


        }
        return suma;
    }

    public static Double caloriesNiedziela() {
        Double suma = 0D;
        Integer n;

        n = trainigByDays.get(NIEDZIELA).size();
        for (int i = 0; i < n; i++) {
            suma = suma + trainigByDays.get(NIEDZIELA).get(i).calorieslocal();


        }
        return suma;
    }
    //_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
    //                                            Method that calculate calories for a week

    public static Double caloriesTotal() {
        Double suma;

        suma = +caloriesPoniedzialek() + caloriesWtorek() + caloriesSroda() + caloriesCzwartek() + caloriesPiatek() + caloriesSobota() + caloriesNiedziela();

        return suma;
    }
    //__________________________________________________________________________________________________________________


}