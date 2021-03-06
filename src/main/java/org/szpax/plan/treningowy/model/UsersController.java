package org.szpax.plan.treningowy.model;

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

        import static org.szpax.plan.persistance.DbMock.*;

/**
 * Created by Marcin on 2016-08-06.
 */

@RestController // to mowi ze ta klasa bedzie oblugiwaa zadania z przegladarki
@RequestMapping("/user") // to mowi ze ten kontroler obsluguje zadania z koncowka url: /plan
public class UsersController {

    Logger log = Logger.getLogger(UsersController.class);// pobieramy referencje (do) logera, i podajemy klase (.class - znaczy że ta klasa) - NIEWAŻNE!
//w du&#x17c;ych aplikacjach korzystamy z logera zamist system.out

    public int n = usersList.size();

    @RequestMapping("/add")
    public static void addUser(String userName) {
        nameUser.put(userName, new User(userName));
        usersList.add(  nameUser.get(userName));
    }

    @RequestMapping("/list")
    public static List<User> userList() {
        return DbMock.getUsersList();
    }

    @RequestMapping("users")
    public static Map<String,TrainingPlan> getUserPlan() {
        int m = usersList.size();//teraz m jes public czy private?
        for (int x = 0; x < m; x = x + 1) {
            DbMock.userNameTrainingPlan.put(DbMock.usersList.get(x).getUserName(), DbMock.userTrainigPlan.get(DbMock.nameUser.get(DbMock.usersList.get(x).getUserName())));//dlaczego DbMock.userNameTrainingPlan.put(DbMock.usersList.get(int x).getUserName...) nie zadziałą - Error ( nie wiedzdi tego getUserName) sprawdz czy userList faktycznie jest wypełniona w momencie jak odpalasz ta metode (??może z nia jest coś nie tak)

        }
        return userNameTrainingPlan;
    }

        }

