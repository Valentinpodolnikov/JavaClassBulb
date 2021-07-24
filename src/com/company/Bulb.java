package com.company;

public class Bulb {
    //region Enum Color
    //перебор вариантов цветов
    public enum Color {
        red("красный"),
        green("зелёный"),
        blue("голубой"),
        white("белый");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //endregion

    //region Variables
    //переменные

    private int power;
    private Color color;
    private int lifeTime;

    //endregion

    //region Constructors
    //Конструкторы. задаем значения переменных

    public Bulb(){
        power = 100;
        color = Color.white;
        lifeTime = 2;
    }



    public Bulb(int power, Color color, int lifeTime) {
        this.power = power;
        this.color = color;
        this.lifeTime = lifeTime;
    }

    //конструктор копирования
    public Bulb(Bulb bulb) {
        power = bulb.power;
        color = bulb.color;
        lifeTime = bulb.lifeTime;
    }

    //endregion

    public String getInString(){
        String output = "";

        output += "мощность: " +power+ "(Вт)\n";
        output += "долговечность: " +lifeTime+ "(г)\n";
        output += "цвет: " +color.getValue();

        return output;
    }
}
