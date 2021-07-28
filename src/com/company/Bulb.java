package com.company;

public class Bulb {
    //region Enum Color
    //перебор вариантов цветов
    public enum Color {
        red("красный"),
        green("зелёный"),
        blue("голубой"),
        black("чёрный"),
        yellow("жёлтый");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    //endregion

    public enum State {
        on("включена"),
        off("выключена");

        private final String value;

        State(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }





    //region Variables
    //переменные

    private int id;
    private int power;
    private int brightness;
    private String brandName;
    private int lifeTime;
    private Color color;
    private State state;

    //endregion

    //region Constructors
    //Конструкторы. задаем значения переменных


    public Bulb(int id, int power, int brightness, String brandName, int lifeTime, Color color, State state) {
        this.id = id;
        this.power = power;
        this.brightness = brightness;
        this.brandName = brandName;
        this.color = color;
        this.lifeTime = lifeTime;
        this.state = state;

    }

    //конструктор копирования
    public Bulb(int id, Bulb bulb) {
        this.id = id;
        power = bulb.power;
        color = bulb.color;
        lifeTime = bulb.lifeTime;
        brightness = bulb.brightness;
        brandName = bulb.brandName;
        state = bulb.state;
    }

    //endregion

    //region Setters

    public void setPower(int power) throws Exception {
        if (power <= 0 || power > 1500) {
            throw new Exception("Мощность должна быть не меньше 0 и не более 1500");
        }
        this.power = power;
    }

    public void setBrightness(int brightness) throws Exception {
        if (brightness <= 0 || brightness > 100) {
            throw new Exception("Яркость не должна быть меньше 0 и не более 100%");
        }
        this.brightness = brightness;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setState(State state) {
        this.state = state;
    }
    //endregion

    //region Getters

    public int getPower() {
        return power;
    }

    public int getBrightness() {
        return brightness;
    }

    public Color getColor() {
        return color;
    }

    public State getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    //endregion


    public String getInString() {
        String output = "";

        output += "ИД: " + id + "\n";
        output += "мощность: " + power + "(Вт)\n";
        output += "яркость: " + brightness + "(Вт)\n";
        output += "марка: " + brandName + "\n";
        output += "долговечность: " + lifeTime + "(г)\n";
        output += "цвет: " + color.getValue() + "\n";
        output += "состояние лампочки: " + state.getValue() + "\n";


        return output;
    }
}
