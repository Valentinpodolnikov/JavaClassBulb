package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Bulb bulb1 = new Bulb();
        Bulb bulb2 = new Bulb(1, Bulb.Color.red, 3);


        System.out.println(bulb1.getInString());
        System.out.println("==========");
        System.out.println(bulb2.getInString());
    }
}
