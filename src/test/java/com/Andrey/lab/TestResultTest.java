package com.Andrey.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit тесты для класса TestResult.
 */
@DisplayName("Тесты класса TestResult")
class TestResultTest {

    @Test
    @DisplayName("Тест создания и получения данных результата")
    void testResultCreationAndGetters() {
        TestResult result = new TestResult("add", "ArrayList", 1000, 5000000);

        assertEquals("add", result.getOperation());
        assertEquals("ArrayList", result.getCollectionType());
        assertEquals(1000, result.getIterations());
        assertEquals(5000000, result.getTimeNanos());
    }

    @Test
    @DisplayName("Тест конвертации наносекунд в миллисекунды")
    void testTimeConversion() {
        TestResult result = new TestResult("get", "LinkedList", 2000, 10000000);

        assertEquals(10.0, result.getTimeMillis(), 0.01,
                "Конвертация в миллисекунды должна быть корректной");
    }
}