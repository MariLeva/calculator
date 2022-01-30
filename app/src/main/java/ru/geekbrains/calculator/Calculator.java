package ru.geekbrains.calculator;

import java.io.Serializable;

public class Calculator implements Serializable{
    private String operation = "";
    private String var_a = "";
    private String var_b = "";

    public String getVar_a() {
        return var_a;
    }

    public void setVar_a(String var_a) {
        this.var_a = var_a;
    }

    public String getVar_b() {
        return var_b;
    }

    public void setVar_b(String var_b) {
        this.var_b = var_b;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public float add(float var_a, float var_b) {
        return var_a + var_b;
    }

    public float sub(float var_a, float var_b) {
        return var_a - var_b;
    }

    public float mul(float var_a, float var_b) {
        return var_a * var_b;
    }

    public float div(float var_a, float var_b) {
        return var_a / var_b;
    }

    public String equals(float var_a, float var_b) {
        switch (this.operation) {
            case "+":
                return String.valueOf(add(var_a, var_b));
            case "-":
                return String.valueOf(sub(var_a, var_b));
            case "*":
                return String.valueOf(mul(var_a, var_b));
            case "/":
                return String.valueOf(div(var_a, var_b));
            default:
                throw new IllegalStateException("Не найдена операция!");
        }
    }

    public String percent(float var_a, float var_b) {
        var_b = var_a * var_b / 100;
        return equals(var_a, var_b);
    }

}
