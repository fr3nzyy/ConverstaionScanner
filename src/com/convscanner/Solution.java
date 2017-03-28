package com.convscanner;

/**
 * Created by fr3nzy on 28.03.2017.
 */
/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

        import java.io.*;
        import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try { s = reader.readLine(); }
        catch (IOException e) {System.out.println(e); }
        String SubStr = s.substring(s.indexOf("?")+1, s.length());
        String parseUrl [] = SubStr.split("[?&]");
        ArrayList<String> Obj = new ArrayList();
        ArrayList<String> alert = new ArrayList();

        for(String x : parseUrl) {
            if(x.startsWith("obj")) {
                Obj.add(x.substring(x.indexOf("=")+1, x.length()));
                //Obj.add(x.split("=")[0]);
            }
        }

        for(int i = 0; i < parseUrl.length; i++){
            try
            {
                alert.add(parseUrl[i].substring(0, parseUrl[i].indexOf("=")));
            }
            catch (Exception e) {alert.add(parseUrl[i]);}
        }
        System.out.print(alert.get(0));
        for (int i = 1; i < alert.size(); i++)
        {
            if(alert.get(i).equals("") || alert.get(i).equals(" "));
            else System.out.print(" " + alert.get(i));
        }

        System.out.println();
        for(String x: Obj){
            try{
                alert(Double.parseDouble(x));
            } catch (Exception e){
                alert(x);
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}


