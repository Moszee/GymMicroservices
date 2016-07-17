package org.szpax.plan.treningowy;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.szpax.plan.treningowy.model.Excercise;
import org.szpax.plan.treningowy.model.TraningPlan;

import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-06-05.
 */

@RestController // to mowi ze ta klasa bedzie oblugiwaa zadania z przegladarki
@RequestMapping("/plan") // to mowi ze ten kontroler obsluguje zadania z koncowka url: /plan
public class TreningController {


    Logger log = Logger.getLogger(TreningController.class); // pobieramy referencje (do) logera, i podajemy klase (.class - znaczy że ta klasa) - NIEWAŻNE!
                                                            //w dużych aplikacjach korzystamy z logera zamist system.out

    @RequestMapping // przy kazdej metodzie wstaiamy @requestMapping  potem jak nie dodamy innej koncowki to obsluguje ona zadania dalej z koncowka /plan
    public Map<String,List<Excercise>> getPlan () {
        return TraningPlan.getTrainingByDays();
    }

    /*
         jezeli dodamy koncowke po @RequestMapping -(np:"add") to obslugujemy /plan/add
         @RequestParam  to parametry podawane w Url np :http://localhost:8080/plan/add?day=Poniedzialek&name=rozpietki&weight=10&repeats=10
     */
    @RequestMapping("add")
    public void addExcercise (@RequestParam String day,@RequestParam String name,@RequestParam Integer repeats, @RequestParam Integer weight) {
        TraningPlan.addExcercise(day, name, repeats, weight);
    }
    @RequestMapping("licz")
    public Double calculate (){
        return TraningPlan.caloriesTotal();
    }

    @RequestMapping("caloriesByDays01")
    public void caloriesInWeek01 () { // JAK WSTAWIE TU STATIC TO LOGI ( LOG.INFO ) MI NIE DZIALAJA _ WYRZUCA MI JE NA CZERWONO , DLACZEGO??
        log.info(TraningPlan.PONIEDZIALEK + ": " + TraningPlan.caloriesPoniedzialek());
        log.info(TraningPlan.WTOREK + ": " + TraningPlan.caloriesWtorek());
        log.info(TraningPlan.SRODA + ": " + TraningPlan.caloriesSroda());
        log.info(TraningPlan.CZWARTEK + ": " + TraningPlan.caloriesCzwartek());
        log.info(TraningPlan.PIATEK + ": " + TraningPlan.caloriesPiatek());
        log.info(TraningPlan.SOBOTA + ": " + TraningPlan.caloriesSobota());
        log.info(TraningPlan.NIEDZIELA + ": " + TraningPlan.caloriesNiedziela());
    }

    @RequestMapping("caloriesByDays")
    public static Map<String, Double> caloriesInWeek() {
        return TraningPlan.getmapCaloriesByDays(); // Tu jest blad !!!!!!!! mówi że to dowoluje się do Statc a to nie jest Static
    }
}