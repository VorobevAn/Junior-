package Seminar1;


import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] intList = {2, 4, -6, 2, 6, 7, 10, 9};
        System.out.println(Arrays.stream(intList).filter(i -> i % 2 == 0).average().orElseThrow());
    }

}
