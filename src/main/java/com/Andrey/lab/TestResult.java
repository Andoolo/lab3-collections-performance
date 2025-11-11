package com.Andrey.lab;

/**
 * Класс для хранения результатов тестирования.
 *
 * @author Andrey
 * @version 1.0
 * @since 2025-11-11
 */
public class TestResult {
    private final String operation;
    private final String collectionType;
    private final int iterations;
    private final long timeNanos;

    /**
     * Конструктор результата теста.
     *
     * @param operation       название операции
     * @param collectionType  тип коллекции
     * @param iterations      количество итераций
     * @param timeNanos       время выполнения в наносекундах
     */
    public TestResult(String operation, String collectionType, int iterations, long timeNanos) {
        this.operation = operation;
        this.collectionType = collectionType;
        this.iterations = iterations;
        this.timeNanos = timeNanos;
    }

    /**
     * @return название операции
     */
    public String getOperation() {
        return operation;
    }

    /**
     * @return тип коллекции
     */
    public String getCollectionType() {
        return collectionType;
    }

    /**
     * @return количество итераций
     */
    public int getIterations() {
        return iterations;
    }

    /**
     * @return время выполнения в наносекундах
     */
    public long getTimeNanos() {
        return timeNanos;
    }

    /**
     * @return время выполнения в миллисекундах
     */
    public double getTimeMillis() {
        return timeNanos / 1_000_000.0;
    }
}