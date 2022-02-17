package ex0216_문수빈;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {


    public Set<Integer> makeLotto() {
        Set<Integer> lotto = new TreeSet<>();
        Random random = new Random();
        while (lotto.size() < 6) {
            int randomNumber = random.nextInt(45) + 1;
            lotto.add(randomNumber);
        }
        return lotto;
    }

    public static void main(String[] args) {
        TreeSetLotto treeSetLotto = new TreeSetLotto();
        for (int i : treeSetLotto.makeLotto()) {
            System.out.print(i + " ");
        }
    }
}
