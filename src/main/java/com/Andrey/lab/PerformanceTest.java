package com.Andrey.lab;

import java.util.List;

/**
 * Класс для тестирования производительности операций ArrayList и LinkedList.
 *
 * @author Andrey
 * @version 1.0
 * @since 2025-11-11
 */
public class PerformanceTest {

    private final int iterations;

    /**
     * Конструктор с указанием количества итераций.
     *
     * @param iterations количество операций для тестирования
     */
    public PerformanceTest(int iterations) {
        this.iterations = iterations;
    }

    /**
     * Тестирует операцию добавления элементов.
     *
     * @param list коллекция для тестирования
     * @return время выполнения в наносекундах
     */
    public long testAdd(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Тестирует операцию получения элемента по индексу.
     *
     * @param list коллекция для тестирования
     * @return время выполнения в наносекундах
     */
    public long testGet(List<Integer> list) {
        // Предварительно заполняем список
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Тестирует операцию удаления элементов.
     *
     * @param list коллекция для тестирования
     * @return время выполнения в наносекундах
     */
    public long testDelete(List<Integer> list) {
        // Предварительно заполняем список
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();
        // Удаляем с начала для более честного сравнения
        for (int i = 0; i < iterations; i++) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Возвращает количество итераций.
     *
     * @return количество итераций
     */
    public int getIterations() {
        return iterations;
    }
}