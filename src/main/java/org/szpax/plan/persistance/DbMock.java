package org.szpax.plan.persistance;

import java.util.*;

import org.szpax.plan.treningowy.model.TrainingPlan;
import org.szpax.plan.treningowy.model.User;

/**
 * Created by Marcin on 2016-07-30.
 */
public class DbMock {

    private static TrainingPlan trainingPlan = TrainingPlan.create();

    public static TrainingPlan getTraningPlan() {
        return trainingPlan;
    }
// dodamy klase uzytkownik wg tego co Brat  Ci napisał, a liste urzytkownikow bedziesz trzymał w dbmock

    public static List<User> usersList = new ArrayList<>();//w Tym miejscu wyświetlał mi błąd i pisał że multiple choice cannot resolve i mogłem wybrać ta moja klase lub np apatch.catalina, lub np User in JNDI realm

    public static List<User> getUsersList() {
        return usersList;
    }

    public static Map<User, TrainingPlan> getUsersPlans() { return userTrainigPlan; }

    public static Map<User,TrainingPlan> userTrainigPlan = new HashMap<>();

    public static Map<String, User> nameUser = new HashMap<>();


}