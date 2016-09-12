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

/**
 * Created by Marcin on 2016-08-06.
 */

@RestController // to mowi ze ta klasa bedzie oblugiwaa zadania z przegladarki
@RequestMapping("/user") // to mowi ze ten kontroler obsluguje zadania z koncowka url: /plan
public class UsersController {

    Logger log = Logger.getLogger(UsersController.class);// pobieramy referencje (do) logera, i podajemy klase (.class - znaczy że ta klasa) - NIEWAŻNE!
//w du&#x17c;ych aplikacjach korzystamy z logera zamist system.out

    @RequestMapping("/add")
    public static void addUser(String userName) {
        DbMock.nameUser.put(userName, new User(userName));
        DbMock.usersList.add(  DbMock.nameUser.get(userName));
    }

    @RequestMapping("/list")
    public static List<User> userList() {
        return DbMock.getUsersList();
    }

}