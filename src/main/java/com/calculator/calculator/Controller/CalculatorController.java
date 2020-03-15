package com.calculator.calculator.Controller;

import com.calculator.calculator.Model.Calculator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://patriot1994.github.io/") // http://localhost:4200
public class CalculatorController {
    @RequestMapping(value="/calculator", method = RequestMethod.GET)
    public String calculate(@RequestParam(value = "equations",defaultValue = "0") String equations) throws UnsupportedEncodingException {

        Calculator calculator = new Calculator();
        calculator.calculate(URLEncoder.encode(equations));
        return String.valueOf(calculator.getResult());
    }


    @RequestMapping(value= "/", method=RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
}
