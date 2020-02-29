package com.calculator.calculator.Model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private String incomingEquation;

    private Long result;

    public Calculator() {

    }
    private Pair<String,List<Long>> decrypt(){
        String signs ="";
        incomingEquation.replaceAll("\"","");
        boolean regexCheck = Pattern.compile("\\d{0,10}[\\+,\\*,\\-,\\/]\\d{0,10}").matcher(getIncomingEquation()).matches();
        if(regexCheck){
            List<Long> numbers = new ArrayList<>();
            String operations = "";
            for(int i=0;i<incomingEquation.length();i++){
                switch (incomingEquation.charAt(i)){
                    case '+':
                        numbers.add(Long.parseLong(operations));
                        operations ="";
                        signs+=incomingEquation.charAt(i);
                        break;
                    case '-':
                        numbers.add(Long.parseLong(operations));
                        operations ="";
                        signs+=incomingEquation.charAt(i);
                        break;
                    default:
                        operations += incomingEquation.charAt(i);
                        break;
                }

            }
            if(operations!=null){
                numbers.add(Long.parseLong(operations));
                operations="";
            }

            return new Pair<>(signs,numbers);
        }else{
            return null;
        }

    }

    public void calculate(String incomingEquation){
        setIncomingEquation(incomingEquation);
        Pair<String,List<Long>> pair = decrypt();
        if(pair!=null){
            Long eqResult = pair.getValue().get(0);

            for(int i=0;i<pair.getKey().length();i++){
                switch (pair.getKey().charAt(i)){
                    case '+':
                        eqResult = add(eqResult,pair.getValue().get(i+1));
                        break;
                    case'-':
                        eqResult = sub(eqResult,pair.getValue().get(i+1));
                        break;
                    case'*':
                        eqResult = mul(eqResult,pair.getValue().get(i+1));
                        break;
                    case'/':
                        eqResult = div(eqResult,pair.getValue().get(i+1));
                        break;
                }
            }
            setResult(eqResult);
        }else{
            setResult(null);
        }

    }

    public String getIncomingEquation() {
        return incomingEquation;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }


    public void setIncomingEquation(String incomingEquation) {
        this.incomingEquation = incomingEquation;
    }

    private Long add(Long a, Long b){
        return a+b;
    }
    private Long sub(Long a, Long b){
        return a-b;
    }
    private  Long mul(Long a,Long b){
        return a*b;
    }
    private Long div(Long a,Long b){
        return a/b;
    }
}
