package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        System.out.println("5개 입력");
        String s = scanner.nextLine();
        list.add(s);
        String s1 = scanner.nextLine();
        list.add(s1);
        String s2 = scanner.nextLine();
        list.add(s2);
        String s3 = scanner.nextLine();
        list.add(s3);
        String s4 = scanner.nextLine();
        list.add(s4);

        System.out.println("list = " + list);

        List<String> result = new ArrayList<>();
        int maxLength = 0;

        for (String str : list) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        for (String string : list) {
            if (maxLength == string.length()) {
                result.add(string);
            }
        }

        System.out.println("result = " + result);
    }
}


