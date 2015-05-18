package com.javarush.test.level15.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь 1 конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String. Параметр может быть "plane" или "helicopter".
3.2. Закрыть поток ввода методом close().
3.3. Если параметр равен "helicopter", то статическому объекту Flyable result присвоить объект класса Helicopter.
3.4. Если параметр равен "plane", то считать второй параметр типа int, статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
*/

public class Solution {
    static {
        try
        {
            reset();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = reader.readLine();
        if (type.equals("plane") | type.equals("helicopter")){

            if (type.equals("helicopter")){
                result = new Helicopter();
            }
            else if (type.equals("plane")){
                int pass = Integer.parseInt(reader.readLine());
                result = new Plane(pass);
            }

        }   else{
            System.out.println("Введите еще раз");
            type = reader.readLine();
        }
        reader.close();

        //add your code here - добавьте код тут
    }
}
