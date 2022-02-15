/**
 * 본인이름 : 문수빈
 * 날짜 : 22.02.11
 * 주제 : 로또 숫자 출력 (ArrayList 이용)
 */
package ex0211_문수빈;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoArrayList {
    private List<Integer> MakeLotto() {
        List<Integer> lottoList = new ArrayList<>();
        Random random = new Random();
        while (lottoList.size() < 6) {
            int randomNumber = random.nextInt(45) + 1;
            if (!lottoList.contains(randomNumber)) {
                lottoList.add(randomNumber);
            }
        }
        return lottoList;
    }

    public static void main(String[] args) {
        LottoArrayList la = new LottoArrayList();
        List<Integer> lottoList = la.MakeLotto();
        Collections.sort(lottoList);
        System.out.println(lottoList);

        /*
        java8부터 List 인터페이스 안에 default 메소드 sort가 추가됨
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        };
        lottoList.sort(comparator); // lottoList.sort(null);
        lottoList.sort(Collections.reverseOrder());//내림차순
        System.out.println(lottoList);
         */
    }
}
