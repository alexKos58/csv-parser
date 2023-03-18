package ru.kostyushin;


import ru.kostyushin.entity.Airport;

import java.util.Scanner;

import static ru.kostyushin.parser.CsvParser.finderAndParser;

public class Main {


    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        int num = Integer.parseInt(args[0]);

        if (args.length != 1) {
            System.out.println("Колонка введена некорректно!");
            System.exit(1);
        }

        int columnNumber = Integer.parseInt(args[0]);

        if (columnNumber < 0 || columnNumber > Airport.class.getDeclaredFields().length) {
            System.exit(1);
        }

        while (true) {
            System.out.print("Введите строку поиска: ");
            String entryText = scanner.nextLine();
            if (entryText.equals("!quit")) break;
            var resultAirports = finderAndParser(num, entryText, "src/main/resources/airports.csv");
            for (Airport result : resultAirports) {
                System.out.println(result);
            }

        }
    }
}
