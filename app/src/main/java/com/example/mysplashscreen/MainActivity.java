package com.example.mysplashscreen;
import android.app.ListActivity;
import android.os.Bundle;
public class MainActivity extends ListActivity {

    private static int billion;
    private static int million;
    private static int thousand;
    private static int toThousand;
    private static long numberA;
    private static String numText; // число в виде текста

    private static int indexA;
    private static int units;          // единичные значение
    private static int decimal;        // десятичное значение
    private static int hundreds;

    private static final String[][] sampleText = {{"", "од", "дв", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "},
            {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "}};

    private static final String[] sample11to19 = {"десять ", "одинадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шеснадцать ", "семьнадцать ", "восемьнадцать ", "девятнадцать ", "девятнадцать "};

    private static final String[][] textMillion = {{"", "", "", ""},
            {"", "", "тысячь ", ""},
            {"", "миллион ", "тысяча ", ""},
            {"", "", "тысячи ", ""},
            {"миллиардов ", "", "тысячь ", ""}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = new String[1000000];
        for (int index = 0; index < 1000000; index++) {

            values[index] = WordsRus(index + 1);
        }
        MyAdapter adapter = new MyAdapter(this, values);
        setListAdapter(adapter);

    }

    public static String WordsRus(long number) {
        numberA = number;
        numText = "";

        // разбиваем число на миллионы,тысячи и единицы
        billion = (int) (numberA / 1000000000);
        million = (int) (numberA - (billion * 1000000000)) / 1000000;
        thousand = (int) (numberA - (billion * 1000000000) - (million * 1000000)) / 1000;
        toThousand = (int) (numberA % 1000);

        // формируем текст числа прописью
        numText = numText + WordsToThousand(million, 1) + WordsToThousand(thousand, 2) + WordsToThousand(toThousand, 3);
        return numText;

    }

    private static String WordsToThousand(int numericalValue, int index) {
        // разбиваем образец числа на составляющие
        hundreds = numericalValue / 100;
        decimal = (numericalValue - (hundreds * 100)) / 10;
        units = numericalValue % 10;

        // формируем число без степени числа
        numText = "";
        if (decimal == 1) numText = sampleText[2][hundreds] + sample11to19[units];
        else numText = sampleText[2][hundreds] + sampleText[1][decimal] + sampleText[0][units];

        // формируем окончания в единицах
        if (index == 2) {
            if (units == 1 && decimal != 1) numText = numText + "на ";
            else if (units == 2 & decimal != 1) numText = numText + "е ";
            if (units > 1 && decimal != 1) numText = numText + " ";
        } else {
            if (units == 1 && decimal != 1) numText = numText + "ин ";
            if (units == 2 & decimal != 1) {
                numText = numText + "а ";
            } else if (units != 0 & decimal != 1) numText = numText + " ";
        }

        // дописываем степень числа
        indexA = 0;
        if (numericalValue != 0) {
            if (units == 0 || decimal == 1) indexA = 1;
            else if (units == 1) indexA = 2;
            else if (units > 1 & units < 5) indexA = 3;
            else indexA = 4;
        }
        numText = numText + textMillion[indexA][index];
        return numText;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}