package com.calculator.calculator.Controller;

import com.calculator.calculator.Model.Calculator;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://calculatorpatriot1994.herokuapp.com/calculator") // http://localhost:4200
public class CalculatorController {
    @RequestMapping(value="/calculator", method = RequestMethod.GET)
    public String calculate(@RequestParam(value = "equations",defaultValue = "0") String equations) throws UnsupportedEncodingException {

        Calculator calculator = new Calculator();
        calculator.calculate(URLEncoder.encode(equations));
        return String.valueOf(calculator.getResult());
    }

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
}
