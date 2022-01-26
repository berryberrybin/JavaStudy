/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.25
 * 주제 : 오름차순 정렬
 */
public class SortExam {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 4, 3, 8, 9, 6, 10};
        SortExam se = new SortExam();
        //se. bubbleSort(arr);
        //se. selectSort(arr);
        se. insertSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    // 버블 정렬
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i >0 ; i--) {  // int i= 0;  i< n-1;  i++
            for (int j = 0; j < i; j++) { // int j= 0;  j< n-1-i;  j++
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 선택 정렬
    private void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j; // 아직 정렬하지 않은 부분에서 최솟값 찾음
                }
            }
            int temp = arr[i]; // 정렬하지 않은 부분의 첫번째 요소와 교환
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 삽입 정렬
    private void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int target = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > target) {
                arr[j] = arr[j - 1]; // 알맞은 위치 찾기 전까지 이웃한 왼쪽의 요소를 대입하는 작업 반복
                j--;
            }
            arr[j] = target; // 멈춘 위치에 target값 대입
        }
    }

    /*
    private void insertSortClass(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int target = arr[i];
            int j=0;
            for( j=i-1; j>=0 && target <arr[j]; j-- ){
                arr[j+1] = arr[j];
            }
            arr[j+1] = target; // 멈춘 위치에 target값 대입
        }
    }
     */
}