package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest03 {
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

        List<String> matchingNames = maxLengthString(list);
        for (String matchingName : matchingNames) {
            System.out.println("제일 긴 문자열 = " + matchingName);
        }
    }

    public static List<String> maxLengthString(List<String> list) {
        List<String> result = new ArrayList<>();

        String name = "a";
        result.add(name);
        for (String s : list) {
            if (s.length() > name.length()) {
                result.set(0, s);
            }
        }
        return result;
    }
}
