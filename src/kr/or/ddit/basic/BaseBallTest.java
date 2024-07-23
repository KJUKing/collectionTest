package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오
 컴퓨터의 숫자는 난수를 이용하여 구한다.
 (스트라이크는 S 볼은 B로 출력)

 예시)

 컴퓨터의 난수 --> 9 5 7

 실행 예시)
 숫자 입력 -> 3 5 6
 3 5 6 1s 0b

 숫자 입력 -> 7 8 9
 7 8 9 -> 0s 2b
 숫자 입력 -> 9 7 5
 9 7 5 -> 1s 2b
 숫자 입력 -> 9 5 7
 9 57 -> 3s 0b
 */
public class BaseBallTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s =0; //스트라이크
        int b =0; //볼
        HashSet<Integer> baseBallSet = new HashSet<>();

        while (baseBallSet.size() < 3) {
            baseBallSet.add((int) (Math.random() * (9 - 1 + 1) + 1));
        }

        while (true) {
            ArrayList<Integer> testList = new ArrayList<>(baseBallSet); // 컴퓨터 난수 리스트 저장
            ArrayList<Integer> myList = new ArrayList<>();
            // 이렇게하면 testSet에있는 자료가 List에 그대로담김
            for (Integer i : testList) {
                System.out.print(i +  " ");
                System.out.println();
            }

            System.out.println("1이상 9이하의 숫자 3개를 입력해주세요");
            myList.add(sc.nextInt());
            myList.add(sc.nextInt());
            myList.add(sc.nextInt());
            for (Integer i : myList) {
                System.out.print(i + " ");
                System.out.println();
            }

            for (int i = 0; i < 3; i++) {
                if (myList.get(i) == testList.get(i)) {
                    s++;
                }
                if (myList.get(i) != testList.get(i) && myList.contains(testList.get(i))) {
                    b++;
                }
            }
            System.out.println("카운트 s: " + s + " b : " + b);

            if (s == 3) {
                System.out.println("맞췄습니다");
                break;
            }
            s=0;
            b=0;
        }
    }
}
