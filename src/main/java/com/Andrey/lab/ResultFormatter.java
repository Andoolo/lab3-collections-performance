package com.Andrey.lab;

import java.util.List;

/**
 * Класс для форматирования и вывода результатов тестирования.
 *
 * @author Andrey
 * @version 1.0
 * @since 2025-11-11
 */
public class ResultFormatter {

    /**
     * Выводит результаты тестирования в виде таблицы.
     *
     * @param results список результатов тестирования
     */
    public static void printResults(List<TestResult> results) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("                         РЕЗУЛЬТАТЫ ТЕСТИРОВАНИЯ ПРОИЗВОДИТЕЛЬНОСТИ");
        System.out.println("=".repeat(100));

        System.out.printf("%-20s | %-15s | %-15s | %-20s | %-20s%n",
                "Операция", "Тип коллекции", "Итераций", "Время (нс)", "Время (мс)");
        System.out.println("-".repeat(100));

        for (TestResult result : results) {
            System.out.printf("%-20s | %-15s | %-15d | %-20d | %-20.3f%n",
                    result.getOperation(),
                    result.getCollectionType(),
                    result.getIterations(),
                    result.getTimeNanos(),
                    result.getTimeMillis());
        }

        System.out.println("=".repeat(100));

        // Анализ результатов
        printAnalysis(results);
    }

    /**
     * Выводит анализ результатов.
     *
     * @param results список результатов тестирования
     */
    private static void printAnalysis(List<TestResult> results) {
        System.out.println("\nАНАЛИЗ РЕЗУЛЬТАТОВ:");
        System.out.println("-".repeat(100));

        // Группируем по операциям
        String[] operations = {"add", "get", "delete"};

        for (String operation : operations) {
            TestResult arrayListResult = results.stream()
                    .filter(r -> r.getOperation().equals(operation) && r.getCollectionType().equals("ArrayList"))
                    .findFirst()
                    .orElse(null);

            TestResult linkedListResult = results.stream()
                    .filter(r -> r.getOperation().equals(operation) && r.getCollectionType().equals("LinkedList"))
                    .findFirst()
                    .orElse(null);

            if (arrayListResult != null && linkedListResult != null) {
                double ratio = (double) linkedListResult.getTimeNanos() / arrayListResult.getTimeNanos();
                String faster = ratio > 1 ? "ArrayList" : "LinkedList";
                double times = Math.abs(ratio > 1 ? ratio : 1 / ratio);

                System.out.printf("%s: %s быстрее в %.2f раз(а)%n",
                        operation.toUpperCase(), faster, times);
            }
        }

        System.out.println("=".repeat(100));
    }
}