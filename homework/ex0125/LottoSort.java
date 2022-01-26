/**
 * 본인이름 : 문수빈
 * 날짜 : 22.01.25
 * 주제 : 로또번호 생성
 */
public class LottoSort {

    public static void main(String[] args) {
        LottoSort ls = new LottoSort();
        int[] lottoArray = ls.makeLotto();
        ls.bubbleSort(lottoArray);
        ls.printArray(lottoArray);
    }

    // 로또번호 6개 랜덤 생성하여 배열에 저장
    private int[] makeLotto() {
        int[] lottoArray = new int[6];
        for (int i = 0; i < lottoArray.length; i++) {
            lottoArray[i] = generateLottoNumber(lottoArray);
        }
        return lottoArray;
    }

    private int generateLottoNumber(int[] lottoArray) {
        boolean isDuplicated;
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 45) + 1;
            isDuplicated = isDuplicatedNumber(lottoArray, randomNumber);
        } while (isDuplicated);
        return randomNumber;
    }


    // 중복체크하는 메소드
    private boolean isDuplicatedNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

    // 내림차순으로 정렬하는 메소드
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 배열 값을 화면에 출력하는 메소드
    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
