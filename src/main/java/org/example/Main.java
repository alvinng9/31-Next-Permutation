package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numsOne = new int[]{1, 2, 3};
        int[] numsTwo = new int[]{3, 2, 1};
        int[] numsThree = new int[]{1, 1, 5};
        printIntArray(numsOne);
        nextPermutation(numsOne);
        printIntArray(numsOne);

        printIntArray(numsTwo);
        nextPermutation(numsTwo);
        printIntArray(numsTwo);

        printIntArray(numsThree);
        nextPermutation(numsThree);
        printIntArray(numsThree);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int left) {
        int i = left;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int pivotOne = -1;
        int pivotTwo = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivotOne = i;
                break;
            }
        }

        if (pivotOne == -1) {
            reverse(nums, 0);
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[pivotOne]) {
                    pivotTwo = i;
                    break;
                }
            }
            swap(nums, pivotOne, pivotTwo);
            reverse(nums, pivotOne + 1);
        }
    }

    public static void printIntArray(int[] array) {
        System.out.print("[ ");
        for (int here : array) {
            System.out.print(here + " ");
        }
        System.out.println("]");
    }

}