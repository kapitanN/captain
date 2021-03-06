package com.javarush.test.level17.lesson10.home09;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
        String current;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        try{
            BufferedReader inputStream = new BufferedReader(new FileReader(firstFileName));
            while ((current = inputStream.readLine()) != null){
                allLines.add(current);
            }

            BufferedReader secondInputStream = new BufferedReader(new FileReader(secondFileName));
            while ((current = secondInputStream.readLine()) != null ){
                forRemoveLines.add(current);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        new Solution().joinData();
    }


    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            System.out.println("a");
            return;
        }
        else{
            for (String line : forRemoveLines)
            {
                if (!allLines.contains(line))
                allLines.clear();
                throw new CorruptedDataException();

            }
        }

    }
}
