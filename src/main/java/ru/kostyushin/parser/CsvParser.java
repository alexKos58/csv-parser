package ru.kostyushin.parser;

import lombok.experimental.UtilityClass;
import ru.kostyushin.entity.Airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

@UtilityClass
public class CsvParser {

    /**
     * Кол-во элементов в порции файла
     */
    private static final int SIZE = 2000;

    /**
     * @param num       - номер столбца
     * @param entryText - введенная строка
     * @return результирующий список
     */
    public static LinkedList<Airport> finderAndParser(int num, String entryText, String filePath) {
        String searchText = "\"" + entryText;
        var airports = new ArrayList<Airport>(SIZE);
        var resultAirports = new LinkedList<Airport>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            char first = searchText.charAt(1);
            int count = 0;
            String line;
            var fieldComparator = getComparatorByField(num);

            long start = System.currentTimeMillis();
            while (true) {
                while ((line = reader.readLine()) != null
                        && airports.size() < SIZE) {
                    String[] columns = line.split(",");
                    airports.add(
                            Airport.builder()
                                    .column1(columns[0])
                                    .column2(columns[1])
                                    .column3(columns[2])
                                    .column4(columns[3])
                                    .column5(columns[4])
                                    .column6(columns[5])
                                    .column7(columns[6])
                                    .column8(columns[7])
                                    .column9(columns[8])
                                    .column10(columns[9])
                                    .column11(columns[10])
                                    .column12(columns[11])
                                    .column13(columns[12])
                                    .column14(columns[13])
                                    .build()
                    );
                }
                if (airports.isEmpty()) break;

                airports.sort(fieldComparator);
                for (Airport airport : airports) {
                    String columnValue = getColumnValue(airport, num);
                    if (columnValue != null && columnValue.indexOf(searchText) == 0) {
                        resultAirports.add(airport);
                        count++;
                    }

                    if ((int) Objects.requireNonNull(columnValue).charAt(1) - (int) first > 0) break;

                }

                airports.clear();
            }
            long finish = System.currentTimeMillis();


            System.out.println("Количество найденных строк: " + count);
            System.out.println("Время, затраченное на поиск: " + (finish - start) + " мс");

        } catch (IOException e) {
            System.out.println("Невозможно прочесть файл!");
            System.exit(1);
        }
        return resultAirports;
    }

    /**
     * @param airport      - объект класса Airport
     * @param columnNumber - номер колонки
     * @return - строка нужного столбца
     */
    private static String getColumnValue(Airport airport, int columnNumber) {
        switch (columnNumber) {
            case 2:
                return airport.getColumn2();
            case 3:
                return airport.getColumn3();
            case 4:
                return airport.getColumn4();
            case 5:
                return airport.getColumn5();
            case 6:
                return airport.getColumn6();
            case 7:
                return airport.getColumn7();
            case 8:
                return airport.getColumn8();
            case 9:
                return airport.getColumn9();
            case 10:
                return airport.getColumn10();
            case 11:
                return airport.getColumn11();
            case 12:
                return airport.getColumn12();
            case 13:
                return airport.getColumn13();
            case 14:
                return airport.getColumn14();
            case 1:
            default:
                return airport.getColumn1();
        }
    }

    /**
     * @param columnNumber - номер колонки
     * @return - поле по которому необходимо отсортировать
     */
    private static Comparator<Airport> getComparatorByField(int columnNumber) {
        switch (columnNumber) {
            case 2:
                return Comparator.comparing(Airport::getColumn2);
            case 3:
                return Comparator.comparing(Airport::getColumn3);
            case 4:
                return Comparator.comparing(Airport::getColumn4);
            case 5:
                return Comparator.comparing(Airport::getColumn5);
            case 6:
                return Comparator.comparing(Airport::getColumn6);
            case 7:
                return Comparator.comparing(Airport::getColumn7);
            case 8:
                return Comparator.comparing(Airport::getColumn8);
            case 9:
                return Comparator.comparing(Airport::getColumn9);
            case 10:
                return Comparator.comparing(Airport::getColumn10);
            case 11:
                return Comparator.comparing(Airport::getColumn11);
            case 12:
                return Comparator.comparing(Airport::getColumn12);
            case 13:
                return Comparator.comparing(Airport::getColumn13);
            case 14:
                return Comparator.comparing(Airport::getColumn14);
            case 1:
            default:
                return Comparator.comparing(Airport::getColumn1);
        }
    }
}
