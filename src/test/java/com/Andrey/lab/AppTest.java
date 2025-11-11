package com.Andrey.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit тесты для класса PerformanceTest.
 */
@DisplayName("Тесты производительности коллекций")
class PerformanceTestTest {

    private PerformanceTest tester;
    private static final int TEST_ITERATIONS = 1000;

    @BeforeEach
    void setUp() {
        tester = new PerformanceTest(TEST_ITERATIONS);
    }

    @Test
    @DisplayName("Тест метода add для ArrayList")
    void testAddArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long time = tester.testAdd(list);

        assertTrue(time > 0, "Время выполнения должно быть положительным");
        assertEquals(TEST_ITERATIONS, list.size(), "Размер списка должен совпадать с количеством итераций");
    }

    @Test
    @DisplayName("Тест метода add для LinkedList")
    void testAddLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long time = tester.testAdd(list);

        assertTrue(time > 0, "Время выполнения должно быть положительным");
        assertEquals(TEST_ITERATIONS, list.size(), "Размер списка должен совпадать с количеством итераций");
    }

    @Test
    @DisplayName("Тест метода get для ArrayList")
    void testGetArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long time = tester.testGet(list);

        assertTrue(time > 0, "Время выполнения должно быть положительным");
        assertEquals(TEST_ITERATIONS, list.size(), "Список должен быть заполнен");
    }

    @Test
    @DisplayName("Тест метода get для LinkedList")
    void testGetLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long time = tester.testGet(list);

        assertTrue(time > 0, "Время выполнения должно быть положительным");
        assertEquals(TEST_ITERATIONS, list.size(), "Список должен быть заполнен");
    }

    @Test
    @DisplayName("Тест метода delete для ArrayList")
    void testDeleteArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long time = tester.testDelete(list);

        assertTrue(time > 0, "Время выполнения должно быть положительным");
        assertTrue(list.isEmpty(), "Список должен быть пустым после удаления всех элементов");
    }

    @Test
    @DisplayName("Тест метода delete для LinkedList")
    void testDeleteLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long time = tester.testDelete(list);

        assertTrue(time > 0, "Время выполнения должно быть положительным");
        assertTrue(list.isEmpty(), "Список должен быть пустым после удаления всех элементов");
    }

    @Test
    @DisplayName("Тест конструктора и геттера")
    void testConstructorAndGetter() {
        assertEquals(TEST_ITERATIONS, tester.getIterations(),
                "Количество итераций должно совпадать с заданным");
    }
}