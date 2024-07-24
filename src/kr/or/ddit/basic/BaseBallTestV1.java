package kr.or.ddit.basic;

import java.util.*;

public class BaseBallTestV1 {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> numList;
    private ArrayList<Integer> userList;

    private int strike, ball;

    public static void main(String[] args) {

        BaseBallTestV1 test = new BaseBallTestV1();
        test.gameStart();

        // new BaseBallTestV1.gameStart();
    }

    public void gameStart() {
        getNum();

        System.out.println("난수값 : " + numList);

        int cnt = 0;
        do {
            cnt++;

            inputData();

            ballCount();
        } while (strike != 3);
    }

    private void getNum() {
        Set<Integer> numSet = new HashSet<>();

        while (numSet.size() < 3) {
            numSet.add((int) (Math.random() * 9 + 1));
        }

        numList = new ArrayList<>(numSet);

        Collections.shuffle(numList);

    }

    private void inputData() {
        int num1, num2, num3;

        do {
            System.out.println("숫자 입력 >>");
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            num3 = sc.nextInt();

            if (num1 == num2 || num1 == num3 || num2 == num3) {

            }
        } while (num1 == num2 || num1 == num3 || num2 == num3);

        userList = new ArrayList<>();
        userList.add(num1);
        userList.add(num2);
        userList.add(num3);
    }

   private void ballCount() {
        strike = 0;
        ball = 0;

       for (int i = 0; i < numList.size(); i++) {
           for (int j = 0; j < userList.size(); j++) {
               if (numList.get(i) == userList.get(j)) {
                   if (i == j) {
                       strike++;
                   } else {
                       ball++;
                   }
                   break;
               }
           }
       }

       System.out.println(userList.get(0) + " " + userList.get(1) + " " + userList.get(2) + " -> "
               + strike + "S" + ball + "B");
   }

}
