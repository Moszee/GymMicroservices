package org.szpax.plan.treningowy.model;

/**
 * Created by Marcin on 2016-06-05.
 */
public class Excercise {
    private String name;
    private Integer repeats;
    private Integer weight;
    private static Double CALORIES_CONSTANT = 4.1868;
    private static Double SHIFT = 0.7;
    private static Double ACCELERATION_MOD = 1D;


    public Excercise (String name,Integer repeats,Integer weight){
        this.name = name;
        this.repeats = repeats;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Integer getRepeats() {
        return repeats;
    }

    public Integer getWeight() {
        return weight;
    }

    Integer sumaKalorii = 0;

    public Double calorieslocal () {
        return (repeats * weight * SHIFT * ACCELERATION_MOD) / CALORIES_CONSTANT;
    }
}
