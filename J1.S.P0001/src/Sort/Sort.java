/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Khuong Hung
 */
public class Sort {

    private static final Scanner in = new Scanner(System.in);

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    private static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }
    
     private static int[] Random(int n) {
         Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
          a[i] = random.nextInt(a.length);
        }
        return a;
    }

    private static void BubbleSort(int[] a) {
        System.out.println("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
    }
    
    private static void print(int[] a) {
        System.out.println("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = Random(n);
        BubbleSort(a);
        print(a);
    }

}