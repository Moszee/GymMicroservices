package org.szpax.plan.calculator;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.szpax.plan.treningowy.model.Excercise;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    Logger log = Logger.getLogger(CalculatorController.class);

    /**
     * oblicza ilosc spalonych kalorii podczas cwiczen, wg wzoru
     * @param repeats
     * @param weight
     * @return spalone kalorie
     */
    @RequestMapping //http://localhost:8080/calculator?weight=30&repeats=10 - nadawanie parametrów w przegladarce
    public Double caloriesTotal(@RequestParam Integer repeats, @RequestParam Integer weight) { //@RequestParam Integer repeats mówi że ten repeats który jest w URL ma być przekazany jako argument ( repeats) do wywołania metody; w tym momencie nei ważna jest kolejność podawania argumentów URL
        log.info("Weight param: " + weight); //log.info - wypisz w konsoli - zamiast printline
        log.info("Repeats param: " + repeats);
        Excercise excercise = new Excercise("what ever", repeats, weight);
        return excercise.calorieslocal(); // przegladarki webowe wyświetlaja zwracane wartosci bez koniecznosci podawania komendy do ich wyswietelnia
    }

}