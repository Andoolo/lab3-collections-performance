package com.Andrey.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Главный класс приложения для сравнения производительности ArrayList и LinkedList.
 *
 * @author Andrey
 * @version 1.0
 * @since 2025-11-11
 */
public class App {

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  Тестирование производительности ArrayList vs LinkedList  ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.print("\nВведите количество итераций для тестирования (например, 10000): ");
        int iterations = scanner.nextInt();

        System.out.println("\nЗапуск тестирования...");

        PerformanceTest tester = new PerformanceTest(iterations);
        List<TestResult> results = new ArrayList<>();

        // Тестирование ArrayList
        System.out.println("Тестирование ArrayList...");
        results.add(new TestResult("add", "ArrayList", iterations,
                tester.testAdd(new ArrayList<>())));
        results.add(new TestResult("get", "ArrayList", iterations,
                tester.testGet(new ArrayList<>())));
        results.add(new TestResult("delete", "ArrayList", iterations,
                tester.testDelete(new ArrayList<>())));

        // Тестирование LinkedList
        System.out.println("Тестирование LinkedList...");
        results.add(new TestResult("add", "LinkedList", iterations,
                tester.testAdd(new LinkedList<>())));
        results.add(new TestResult("get", "LinkedList", iterations,
                tester.testGet(new LinkedList<>())));
        results.add(new TestResult("delete", "LinkedList", iterations,
                tester.testDelete(new LinkedList<>())));

        // Вывод результатов
        ResultFormatter.printResults(results);

        scanner.close();
    }
}