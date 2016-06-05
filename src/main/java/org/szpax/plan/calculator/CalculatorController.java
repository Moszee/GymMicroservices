package org.szpax.plan.calculator;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/calculator")
public class CalculatorController {

    Logger log = Logger.getLogger(CalculatorController.class);

    private static Double CALORIES_CONSTANT = 4.1868;
    private static Double SHIFT = 0.7;
    private static Double ACCELERATION_MOD = 1D;


    @RequestMapping
    public Double caloriesTotal(@RequestParam Integer repeats, @RequestParam Integer weight) {
        log.info("Weight param: " + weight);
        log.info("Repeats param: " + repeats);
        return (repeats * weight * SHIFT * ACCELERATION_MOD) / CALORIES_CONSTANT;
    }

}
