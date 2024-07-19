package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 5명의 사람의 이름을입력받아 ArrayList에 저장한 후에
 * 이들중에서 김씨성이름을 모두출력
 */

/**
 *  5명의 별명을 입력받아 ArrayList에 저장한 후
 *  이들중 별명의 길이가 가장 긴 별멸을 출력하시오
 *  단 별명의 길이는 모두 다르게 입력한다 ArrayListTest03
 */

/**
 *  *  5명의 별명을 입력받아 ArrayList에 저장한 후
 *  이들중에서 별명의 길이가 제일 긴 별명들을 출력하시오
 *  단별명의 길이가 같을수 있다. ArrayListTest04
 */
public class ArrayListTest02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

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

        List<String> matchingNames = matchingName(list, "김");
        for (String matchingName : matchingNames) {
            System.out.println(matchingName);
        }
    }

    public static List<String> matchingName(List<String> list, String prefix) {
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (s.indexOf(prefix) == 0) {
                result.add(s);
            }
        }
        return result;
    }
}
