package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class LottoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==========================");
            System.out.println("Lotto 프로그램");
            System.out.println("--------------------------");
            System.out.println("1. Lotto 구입");
            System.out.println("2. 프로그램 종료");
            System.out.println("==========================");
            System.out.print("메뉴선택 : ");
            int i = sc.nextInt();
            switch (i) {
                case 1: buyLotto();
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다");
                    break;
                default:
                    System.out.println("잘못 입력했습니다 다시 입");
            }
        }

    }

    private static void buyLotto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lotto 구입 시작");
        System.out.println("1000원에 로또번호 하나입니다.");
        while(true){
            System.out.print("금액 입력 : ");
            int money = sc.nextInt();
            if (money >= 1000 && money < 100900) {
                startLotto(money);
                break;
            } else if (money < 1000) {
                System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
            } else if (money > 100900) {
                System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
            } else {
                System.out.println("잘못 입력하셨습니다 다시 입력해주세요");
            }


        }
    }

    private static void startLotto(int money) {

        HashSet<Integer> lottoNum = new HashSet<>();
        int count = money / 1000;
        for (int i = 1; i < count+1; i++) {
            while (lottoNum.size() < 6) {
                lottoNum.add((int) (Math.random() * (50 - 1 + 1) + 1));
            }
            ArrayList<Integer> lotto = new ArrayList<>(lottoNum);
            Collections.sort(lotto);
            System.out.println("로또번호" + i + " " + lotto);
            lottoNum.clear();
            lotto.clear();
        }
        System.out.println();
        System.out.println("받은 금액은 "+money+"원이고 "+"거스름돈은 "+money%1000+"원 입니다.");
    }
}
