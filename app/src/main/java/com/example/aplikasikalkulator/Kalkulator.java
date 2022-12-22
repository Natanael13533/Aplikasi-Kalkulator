package com.example.aplikasikalkulator;

public class Kalkulator {

    private int num1,num2,result;
    private String operator;

    public Kalkulator(int num1,int num2,String operator, int result){
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
    }

    public Kalkulator() {

    }

    public String getNum1(){
        return String.valueOf(this.num1);
    }
    public String getNum2(){
        return String.valueOf(this.num2);
    }
    public String getOperator(){
        return this.operator;
    }
    public String getResult(){
        return String.valueOf(this.result);
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
