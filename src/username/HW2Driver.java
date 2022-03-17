/*
 * Course: CS2852-001
 * Homework 2: Comparing Lists
 * Name: FIXME
 * Last Updated: 02/24/2021
 */
package username;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test driver class
 */
public class HW2Driver {
    public static void main(String[] args) {
        SimpleArrayList<Double> times1 = new SimpleArrayList<>();
        SimpleLinkedList<Double> times2 = new SimpleLinkedList<>();

        try(Scanner in = new Scanner(new File("times.txt"))) {
            String line;
            while(in.hasNextLine()) {
                line = in.nextLine();
                times1.add(Double.parseDouble(line));
                times2.add(Double.parseDouble(line));
            }
            System.out.println("After add:\nArray List: " + SimpleArrayList.accessCount +
                    "\nLinked List: " + SimpleLinkedList.accessCount);

            times1.resetAccessCount();
            times2.resetAccessCount();
            System.out.println();

            sort(times1);
            sort(times2);
            System.out.println("After sort:\nArray List: " + SimpleArrayList.accessCount +
                    "\nLinked List: " + SimpleLinkedList.accessCount);
        } catch(IOException e) {
            System.err.println("Could not load file.");
        } catch (NumberFormatException e) {
            System.err.println("Bad data in file");
        }
    }

    /**
     * Simple selection sort
     * @param list SimpleList to sort
     */
    private static void sort(SimpleList<Double> list) {
        int length = list.size();
        for(int i = 0; i < length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < length; j++) {
                if(list.get(j) < list.get(min)) {
                    min = j;
                }
            }
            Double temp = list.set(min, list.get(i));
            list.set(i, temp);
        }
    }
}
