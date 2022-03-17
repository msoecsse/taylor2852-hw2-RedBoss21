/*
 * Course: CS-2852
 * Spring 2021
 * Homework 2: SimpleLists
 * Name: FIXME
 * Created: 02/24/2021
 */
package test;

import username.HW2Driver;
import username.SimpleArrayList;
import username.SimpleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Simple test suite that runs basic validation tests
 * on the SimpleArrayList and SimpleLinkedList classes
 */
public class SimpleListTest {
    private static SimpleArrayList<Double> arrayList;
    private static SimpleLinkedList<Double> linkedList;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        arrayList = new SimpleArrayList<>();
        linkedList = new SimpleLinkedList<>();
        arrayList.resetAccessCount();
        linkedList.resetAccessCount();
        try (Scanner in = new Scanner(new File("times.txt"))) {
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                arrayList.add(Double.parseDouble(line));
                linkedList.add(Double.parseDouble(line));
            }
        }
    }

    @Test
    void arrayListSize() {
        Assertions.assertEquals(30, arrayList.size(),
                "SimpleArrayList size should be 30, but is " + arrayList.size());
    }

    @Test
    void linkedListSize() {
        Assertions.assertEquals(30, linkedList.size(),
                "SimpleLinkedList size should be 30, but is " + linkedList.size());
    }

    @Test
    void arrayListAdd() {
        arrayList.add(2.0);
        Assertions.assertEquals(31, arrayList.size());
        Assertions.assertEquals(arrayList.get(30), 2.0);
    }

    @Test
    void linkedListAdd() {
        linkedList.add(2.0);
        Assertions.assertEquals(31, linkedList.size());
        Assertions.assertEquals(linkedList.get(30), 2.0);
    }

    @Test
    void arrayGet() {
        Assertions.assertEquals(arrayList.get(0), 13.06);
        Assertions.assertEquals(arrayList.get(1), 14.68);
        Assertions.assertEquals(arrayList.get(2), 10.96);
        Assertions.assertEquals(arrayList.get(3), 10.64);
        Assertions.assertEquals(arrayList.get(4), 12.89);
        Assertions.assertEquals(arrayList.get(5), 13.85);
        Assertions.assertEquals(arrayList.get(6), 12.69);
        Assertions.assertEquals(arrayList.get(7), 12.5);
        Assertions.assertEquals(arrayList.get(8), 13.16);
        Assertions.assertEquals(arrayList.get(9), 14.61);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(40));
    }

    @Test
    void linkedGet() {
        Assertions.assertEquals(linkedList.get(0), 13.06);
        Assertions.assertEquals(linkedList.get(1), 14.68);
        Assertions.assertEquals(linkedList.get(2), 10.96);
        Assertions.assertEquals(linkedList.get(3), 10.64);
        Assertions.assertEquals(linkedList.get(4), 12.89);
        Assertions.assertEquals(linkedList.get(5), 13.85);
        Assertions.assertEquals(linkedList.get(6), 12.69);
        Assertions.assertEquals(linkedList.get(7), 12.5);
        Assertions.assertEquals(linkedList.get(8), 13.16);
        Assertions.assertEquals(linkedList.get(9), 14.61);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(40));
    }

    @Test
    void arraySet() {
        double result = arrayList.set(10, 4.0);
        Assertions.assertEquals(12.9, result);
        Assertions.assertEquals(arrayList.get(10), 4.0);
        Assertions.assertEquals(arrayList.size(), 30);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(40));
    }

    @Test
    void linkedSet() {
        double result = linkedList.set(11, 5.0);
        Assertions.assertEquals(11.95, result);
        Assertions.assertEquals(linkedList.get(11), 5.0);
        Assertions.assertEquals(linkedList.size(), 30);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(40));
    }

    @Test
    void arrayOutput() throws FileNotFoundException {
        PrintStream originalOut = System.out;
        File output = new File("output.txt");
        PrintStream newOut = new PrintStream(output);
        System.setOut(newOut);
        arrayList.resetAccessCount();
        linkedList.resetAccessCount();
        HW2Driver.main(null);
        System.setOut(originalOut);
        Scanner in = new Scanner(output);
        in.nextLine();
        String arrayAdd = in.nextLine();
        String linkedAdd = in.nextLine();
        in.nextLine();
        in.nextLine();
        String arraySort = in.nextLine();
        String linkedSort = in.nextLine();
        int arrayAddValue = parseValue(arrayAdd);
        int linkedAddValue = parseValue(linkedAdd);
        int arraySortValue = parseValue(arraySort);
        int linkedSortValue = parseValue(linkedSort);
        Assertions.assertTrue(arrayAddValue > 50 && arrayAddValue < 150);
        Assertions.assertTrue(linkedAddValue > 450 && linkedAddValue < 650);
        Assertions.assertTrue(arraySortValue > 1_800 && arraySortValue < 2_200);
        Assertions.assertTrue(linkedSortValue > 16_000 && linkedSortValue < 22_000);
    }

    private int parseValue(String s) {
        int index = s.indexOf(":") + 2;
        return Integer.parseInt(s.substring(index));
    }
}
