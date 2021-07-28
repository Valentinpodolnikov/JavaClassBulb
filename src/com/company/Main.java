package com.company;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        BulbManager bulbManager = new BulbManager();

        int action = -1;
        boolean isRun = true;


        while (isRun) {

            bulbManager.printBulbs();
            ConsoleHelper.PrintMessage("Меню");
            ConsoleHelper.PrintMessage("1. Добавить лампочку");
            ConsoleHelper.PrintMessage("2. Удалить лампочку");
            ConsoleHelper.PrintMessage("3. Изменить мощность лампочки по ИД");
            ConsoleHelper.PrintMessage("4. Изменить яркость лампочки по ИД");
            ConsoleHelper.PrintMessage("5. Изменить цвет лампочки по ИД");
            ConsoleHelper.PrintMessage("6. Включить/выключить лампочку");
            ConsoleHelper.PrintMessage("0. Выход");


            action = ConsoleHelper.InputInt("Введите номер пункта меню: ", 0, 6);

            switch (action) {
                case 1: {
                    int power = ConsoleHelper.InputInt("Введите мощность лампочки (Вт): ");
                    int brightness = ConsoleHelper.InputInt("Введите яркость лампочки: ");
                    String brandName = ConsoleHelper.InputString("Введите марку лампочки: ");
                    int lifeTime = ConsoleHelper.InputInt("Введите долговечность лампочки (г): ");
                    int colorIndex = ConsoleHelper.InputInt("Введите индекс цвета(0-красный, 1-зелёный, 2-голубой, 3-чёрный, 4-жёлтый): ", 0, 4);
                    Bulb.Color color = Bulb.Color.values()[colorIndex];
                    int stateIndex = ConsoleHelper.InputInt("Выберите статус лампочки. 1-включена, 2-выключена: ");
                    Bulb.State state = Bulb.State.values()[stateIndex];

                    bulbManager.addBulb(power, brightness, brandName, lifeTime, color, state);
                }
                break;

                case 2: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампочки для удаления: ");
                        bulbManager.deleteBulb(id);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }

                }

                break;

                case 3: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампочки для изменения мощности: ");
                        int power = ConsoleHelper.InputInt("Введите мощность: ");
                        bulbManager.getByIdBulb(id).setPower(power);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 4: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампочки для изменения яркости: ");
                        int brightness = ConsoleHelper.InputInt("Введите яркость лампочки(%): ");
                        bulbManager.getByIdBulb(id).setBrightness(brightness);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 5: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампочки для изменения цвета: ");
                        int colorIndex = ConsoleHelper.InputInt("Выберите новый цвет: ");
                        bulbManager.getByIdBulb(id).setColor(Bulb.Color.values()[colorIndex]);
                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 6: {
                    try {
                        int id = ConsoleHelper.InputInt("Введите ИД лампочки, которую хотите включить/выключить: ");
                        int stateIndex = ConsoleHelper.InputInt("1-включить, 2-выключить: ");
                        bulbManager.getByIdBulb(id).setState(Bulb.State.values()[stateIndex]);

                    } catch (Exception e) {
                        ConsoleHelper.PrintMessage(e.getMessage());
                    }
                }
                break;

                case 0: {
                    isRun = false;
                }
                break;
            }

        }
    }
}

