package com.company;

import java.util.Scanner;


public class Main {
    public static void currentState(int state) {
        if (state == 1) {
            System.out.println("Лампочка включена");
        } else if (state == 2) {
            System.out.println("Лампочка выключена");
        } else {
            System.out.println("Лампочка выключена");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Bulb bulb1 = new Bulb(100, Bulb.Color.white, 3);

        System.out.println(bulb1.getInString());

        int action = -1;
        boolean isRun = true;
        int brightness = 100;
        int state = 2;

        while (isRun) {
            System.out.println("==========");
            System.out.println("Что сделать с лампочкой?");
            System.out.println("1. Выключить/включить");
            System.out.println("2. Выбрать процент яркости");
            System.out.println("0. Ничего");

            System.out.print("Введите номер пункта меню: ");

            action = input.nextInt();

            switch (action) {
                case 1: {
                    System.out.println("Чтобы включить лампочку нажмите 1, чтобы выключить нажмите 2");
                    state = input.nextInt();
                    currentState(state);
                    System.out.println("Яркость лампочки: "+brightness+"%");
                }
                break;

                case 2: {
                    System.out.println("Введите необходимую яркость в %: ");
                    brightness = input.nextInt();
                    currentState(state);
                    System.out.println("Яркость лампочки: "+brightness+"%");
                }
                break;
                case 0: {
                    isRun = false;
                }
                break;

                default: {
                    System.out.println("Ошибка. Такой команды не существует");
                }
                break;
            }
        }
    }
}
