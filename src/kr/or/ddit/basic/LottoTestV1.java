package kr.or.ddit.basic;

import java.util.*;

public class LottoTestV1 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new LottoTestV1().lottoStart();


    }

    public void lottoStart() {
        while (true) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    butLotto();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("감사합니다");
                    return;
                default:
                    System.out.println("잘못 입력함");

            }
        }
    }

    private int displayMenu() {
        System.out.println();
        System.out.println("==========================");
        System.out.println("Lotto 프로그램");
        System.out.println("--------------------------");
        System.out.println("1. Lotto 구입");
        System.out.println("2. 프로그램 종료");
        System.out.println("==========================");
        System.out.print("메뉴선택 : ");
        return sc.nextInt();
    }

    private void butLotto() {
        System.out.println("Lotto 구입 시작");
        System.out.println("1000원에 로또번호 하나입니다.");
        System.out.print("금액 입력 : ");
        int money = sc.nextInt();
        if (money < 1000) {
            System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
            return;
        }

        if (money >= 101000) {
            System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
            return;
        }

        Set<Integer> lottoSet = new HashSet<>();
        int count = money / 1000;
        System.out.println("행운의 로또번호는 아래와 같습니다.");
        for (int i = 1; i < count+1; i++) {
            while (lottoSet.size() < 6) {
                lottoSet.add((int) (Math.random() * (50 - 1 + 1) + 1));
            }
            ArrayList<Integer> lotto = new ArrayList<>(lottoSet);
            Collections.sort(lotto);
            System.out.println("로또번호" + i + " " + lotto);
            lottoSet.clear();
            lotto.clear();
        }
        System.out.println();
        System.out.println("받은 금액은 "+money+"원이고 "+"거스름돈은 "+money%1000+"원 입니다.");
    }
}
