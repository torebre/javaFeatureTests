package com.kjipo;


public class FlexibleConstructorCity extends FlexibleConstructorCountry {
    private final int value;


    public FlexibleConstructorCity(int value, int countryId) {
       int i = 0;
       this.value = value;

       super(countryId);

        System.out.println(i);

    }

    public int getValue() {
       return value;
    }



    public static void main(String[] args) {
        FlexibleConstructorCity flexibleConstructorCity = new FlexibleConstructorCity(1, 5);

    }



}
