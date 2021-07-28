package com.company;

public class BulbManager {
    private int id;
    private Bulb[] bulbs;

    public BulbManager() {
        id = 0;
        bulbs = new Bulb[0];
    }
    //region Util Methods

    private int getIndexByIdBulb(int id) {

        int index = -1;
        int middle = bulbs.length / 2;
        int first = 0;
        int last = bulbs.length - 1;

        if (id < bulbs[first].getId() || id > bulbs[last].getId()) {
            return -1;
        }

        do {
            if (id < bulbs[middle].getId()) {
                last = middle - 1;
                middle = (first + last) / 2;
            } else if (id > bulbs[middle].getId()) {
                first = middle + 1;
                middle = (first + last) / 2;

            } else {
                index = middle;
                break;
            }
        }
        while (first <= last);

        return index;
    }

    //endregion

    public void addBulb(int power, int brightness, String brandName, int lifeTime, Bulb.Color color, Bulb.State state) {
        id++;
        Bulb bulb = new Bulb(id, power, brightness, brandName, lifeTime, color, state);

        Bulb[] tempBulbs = new Bulb[bulbs.length +1];

        for (int i = 0; i < bulbs.length; i++) {
            tempBulbs[i] = bulbs[i];
        }

        tempBulbs[tempBulbs.length - 1] = bulb;

        bulbs = tempBulbs;
    }

    public void deleteBulb(int id) throws Exception {
        int index = getIndexByIdBulb(id);

        if (index == -1) {
            throw new Exception("car with id = " + id + " not found");
        }

        Bulb[] tempBulbs = new Bulb[bulbs.length - 1];

        for (int i = 0; i < index; i++) {
            tempBulbs[i] = bulbs[i];
        }

        for (int i = index + 1; i < bulbs.length; i++) {
            tempBulbs[i - 1] = bulbs[i];
        }

        bulbs = tempBulbs;
    }


    public Bulb getByIdBulb(int id) throws Exception {
        int index = getIndexByIdBulb(id);

        if (index == -1) {
            throw new Exception("Bulb with id = " + id + " not found");
        }


        return bulbs[index];
    }

    public void printBulbs() {
        if (bulbs.length == 0) {
            System.out.println("Список пуст");
            System.out.println("==========");
        } else {
            for (int i = 0; i < bulbs.length; i++) {
                System.out.println(bulbs[i].getInString());
                System.out.println("==========");
            }
        }
    }

    //endregion

    }

