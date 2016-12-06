package ru.privet;

import ru.privet.utility.Calculate;
import ru.privet.utility.Reader;

import java.io.IOException;

import static java.lang.System.err;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        String expression;
        String[] numbers;
        char operation;
        out.println("Calculate 2.0");
        out.println("пример ввода: \"1+1\"");

        while (true) {
            try {
                try {
                    expression = Reader.ReadLine();
                    numbers = Reader.readNumbers(expression);
                    operation = Reader.readOperation(expression);
                    out.println("result:  " + Calculate.resultCalculate(numbers, operation));

                } catch (NumberFormatException e) {
                    err.println("неправильный ввод");
                } catch (NullPointerException e) {
                    err.println("переменная не инициализирована");
                } catch (ArrayIndexOutOfBoundsException e) {
                    err.println("неправильный ввод, результат сброшен");
                    Calculate.setResult(0);
                } catch (IOException e) {
                    err.println("ошибка ввода/вывода");
                }
            }catch(Throwable T){
                System.err.println("произошло нечто страшное");
                T.printStackTrace();
            }
        }

    }
}

