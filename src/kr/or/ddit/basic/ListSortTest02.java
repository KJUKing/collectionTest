package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

    public static void main(String[] args) {
        ArrayList<Member> memList = new ArrayList<>();

        memList.add(new Member(1, "홍길동", "010-1111-2222"));
        memList.add(new Member(2, "김깡붕", "010-6666-2222"));
        memList.add(new Member(5, "이석기", "010-2222-2222"));
        memList.add(new Member(7, "박홍규", "010-3333-2222"));
        memList.add(new Member(3, "둘리", "010-4444-2222"));
        memList.add(new Member(9, "또치", "010-5555-2222"));

        System.out.println("정렬전");
        for (Member member : memList) {
            System.out.println(member);
        }
        System.out.println("--------------------------");

        Collections.sort(memList);

        System.out.println("정렬후");
        for (Member member : memList) {
            System.out.println(member);
        }
        System.out.println("--------------------------");

        ArrayList<SortNumDesc> numList = new ArrayList<>();

        numList.add(new SortNumDesc(3, "지렁이", "1234"));
        numList.add(new SortNumDesc(5, "지렁이", "1234"));
        numList.add(new SortNumDesc(9, "지렁이", "1234"));
        numList.add(new SortNumDesc(4, "지렁이", "1234"));
        numList.add(new SortNumDesc(7, "지렁이", "1234"));

        for (SortNumDesc sortNumDesc : numList) {
            System.out.println("sortNumDesc = " + sortNumDesc);
        }

        System.out.println("---------------------------");
        Collections.sort(numList);

        for (SortNumDesc sortNumDesc : numList) {
            System.out.println("sortNumDesc = " + sortNumDesc);
        }
    }
}
// Member클래스의 회원이름을 기준으로 오름차순이 되도록 내부 정렬 기준 추가하기
// Comparable 인터페이스 구현
class Member implements Comparable<Member> {
    private int num;
    private String name;
    private String tel;

    public Member(int num, String name, String tel) {
        this.num = num;
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Member{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }



//    회원이름을 기준으로 오름차순
    @Override
    public int compareTo(Member mem) {
        /*
        if (this.getName.compareTo(mem.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(mem.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
        */
        return this.getName().compareTo(mem.getName());
    }

    public int compare(String str1, String str2) {

        /*
        if (this.getName.compareTo(mem.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(mem.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
        */
        return str1.compareTo(str2) * -1;
    }
}

// Member의 회원번호(변수 num)의 내림차순으로 정렬하는 외부 정렬 기준 클래스를 작성하시오
// 클래스명 : SortNumDesc

class SortNumDesc implements Comparable<SortNumDesc> {

    private int num;
    private String name;
    private String tel;

    public SortNumDesc(int num, String name, String tel) {
        this.num = num;
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "SortNumDesc{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(SortNumDesc num) {
        return Integer.compare(num.getNum(), this.getNum());
    }

}

