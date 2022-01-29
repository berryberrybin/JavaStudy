package ex0129;

import java.util.Comparator;

public class ComparatorExam {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 4, 3, 8, 9, 6, 10};
        ComparatorExam ce = new ComparatorExam();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2); // 오름차순
            }
        };

        ce.ComparatorSort(arr, comparator);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println();

        Comparator<Integer> comparator2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2) * -1; // 내림차순
                // return Integer.compare(o2, o1);
            }
        };
        ce.ComparatorSort(arr, comparator2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println();

        Comparator<Integer> comparator3 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(5 - o1), Math.abs(5 - o2)); //5를 기준으로 거리가 가까운 순으로 
            }
        };
        ce.ComparatorSort(arr, comparator3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }

    private void ComparatorSort(int[] arr, Comparator<Integer> comparator) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
