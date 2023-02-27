package com.spring.redesNeuronales.dto;

import com.spring.redesNeuronales.models.Tiempo;

public class a {
    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();
        tiempo.setClave("10");
        char[] digits1 = tiempo.getClave().toCharArray();

        for (int i = 0; i < digits1.length; i++) {
            System.out.println(digits1[i]);
        }
    }
}
