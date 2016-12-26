package org.szpax.plan.treningowy;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.szpax.plan.persistance.DbMock;
import org.szpax.plan.treningowy.model.Excercise;
import org.szpax.plan.treningowy.model.TrainingPlan;
import org.szpax.plan.treningowy.model.User;

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
        return DbMock.getTraningPlan().getTrainingByDays();
    }

    /*
         jezeli dodamy koncowke po @RequestMapping -(np:"add") to obslugujemy /plan/add
         @RequestParam  to parametry podawane w Url np :http://localhost:8080/plan/add?day=Poniedzialek&name=rozpietki&weight=10&repeats=10
     */
    @RequestMapping("add")
    public void addExcercise (@RequestParam String day,@RequestParam String name,@RequestParam Integer repeats, @RequestParam Integer weight) {
        DbMock.getTraningPlan().addExcercise(day, name, repeats, weight); //!!! jak przyjedziesz do domu to odpowiedz sobie na jedno zajebioście proste pytanie , do czego w tym miejscu potrzebne Ci jest getTreningPlan. a masz :P --- odp. wcześniej nie było getTrening plan, za to wszendzie powcinskane były staticy ... sam add Exercise był metodą statyczną teraz teoretycznie może istnieć wiele trening Planów(nie może bo już masz konstruktor private i static get.treningPlan) ( w związku z czym metoda add exercise nie jest przypisana do klasy a do konkretnego TreningPlanu), natomiast musisz odwołać się do niej poprzez statyczny treningPlan za pomoca get.Trening plan, BO ADD.EXERCISE MOŻESZ TERAZ UżYć (TEORETYCZNIE) NA RÓŻNYCH TRENING PLANACH WIEC JAK CHCIAłBYś to zrobić bez get.TreningPlan ( które odwołuje się do statica ) czyli bez statica to do którego z tych wielu ( teoretycznie wielu) trening planu miało by się to odnosić ... jak to pisałem to straciłem się po nawiasie ale mam nadzieje że jak to bedizesz czytał to się połapiesz :P

// gdzie tu jest referencja do tworzonego cwiczenia ?!?!
    }
    @RequestMapping("add2")//nieskoczone , djuż dochodzisz!!!
    public void putUserTraningPlan (@RequestParam String userName,@RequestParam String day,@RequestParam String name,@RequestParam Integer repeats, @RequestParam Integer weight) {

        User userx = DbMock.nameUser.get(userName);
        TrainingPlan trainingPlan = DbMock.userTrainigPlan.get(userx);

        if (trainingPlan == null) {
            trainingPlan = new TrainingPlan();
            DbMock.userTrainigPlan.put(userx,trainingPlan);
        }
        trainingPlan.addExcercise(day,name,repeats,weight);
        if(DbMock.nameUser.containsKey(userName)){

        }
        else{
            System.out.println("Nie ma takiego urzytkownieka, prosze najpierw dodać urzytkownika o imieniu " + userName);
        }

        //DbMock.userTrainigPlan.get(userx).addExcercise(day, name, repeats, weight);

    }

    @RequestMapping("licz")
    public Double calculate () {
        return DbMock.getTraningPlan().caloriesTotal();

    }

    @RequestMapping("caloriesByDays")
    public Map<String, Double> caloriesInWeek() {
        return DbMock.getTraningPlan().getCaloriesByDays(); // Tu jest blad !!!!!!!! mówi że to dowoluje się do Statc a to nie jest Static
    }
}