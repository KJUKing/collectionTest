package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 * 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
 * 초기화 처리를 한다. (이 때 총점은 세 과목 점수를 이용해서 초기화 한다.)
 * <p>
 * 이 Student객체는 List에 저장하여 관리한다.
 * <p>
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 * 총점의 역순(내림차순)으로 정렬 하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는
 * 외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 * (외부 정렬 클래스명 : SortByTotal)
 * <p>
 * (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */
public class ListSortHomeWork {

    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(new Student(11, "나나", 50, 60, 82));
        stuList.add(new Student(22, "마마", 25, 48, 74));
        stuList.add(new Student(55, "라라", 31, 82, 52));
        stuList.add(new Student(44, "가가", 76, 11, 60));
        stuList.add(new Student(33, "다다", 44, 34, 100));

        System.out.println("초기 리스트값");
        for (Student student : stuList) {
            System.out.println(student);
        }



        System.out.println("---------------------------");

        Collections.sort(stuList);

        System.out.println("학번 오름차순 정렬");
        for (Student student : stuList) {
            System.out.println(student);
        }
        System.out.println("---------------------------");

        ArrayList<SortByTotal> sortByTotal = new ArrayList<>();

        sortByTotal.add(new SortByTotal(11, "나나", 50, 60, 82));
        sortByTotal.add(new SortByTotal(22, "마마", 25, 48, 74));
        sortByTotal.add(new SortByTotal(55, "라라", 31, 82, 52));
        sortByTotal.add(new SortByTotal(44, "가가", 76, 11, 60));
        sortByTotal.add(new SortByTotal(33, "다다", 44, 34, 100));

        System.out.println("총점 내림차순 정렬");
        for (SortByTotal byTotal : sortByTotal) {
            System.out.println(byTotal);
        }


        System.out.println("---------------------------");
        Collections.sort(sortByTotal, new Comparator<SortByTotal>() {
            @Override
            public int compare(SortByTotal s1, SortByTotal s2) {
                if (s1.getSum() != s2.getSum()) { // 총점이 안같을때
                    return Integer.compare(s2.getSum(), s1.getSum());
                } else {
                    return s1.getName().compareTo(s2.getName());
                }
            }
        });

        int curRank =0;
        int skipRank =1;
        //정렬 후 등수구하기
        for (int i = 0; i < sortByTotal.size(); i++) {
            if (i>0 && sortByTotal.get(i).getSum() == sortByTotal.get(i - 1).getSum()) {
                sortByTotal.get(i).setGrade(curRank);
                skipRank++; //다음순위는 건너뛰기위함임 공동4등 2명일시 5등삭제 6등부터
            } else {
                curRank += skipRank;
                sortByTotal.get(i).setGrade(curRank);
                skipRank =1;
            }
        }
        System.out.println("총점 내림차순 / 점수가 같을시 이름 오름차순 정렬");
        for (SortByTotal byTotal : sortByTotal) {
            System.out.println(byTotal);
        }


    }


}

class Student implements Comparable<Student> {

    private int stuNum; // 학번
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private int grade; // 등수

    public Student(int stuNum, String name, int kor, int eng, int math) {
        this.stuNum = stuNum;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sum = kor + eng + math;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "학번=" + stuNum +
                ", 이름='" + name + '\'' +
                ", 국어점수=" + kor +
                ", 영어점수=" + eng +
                ", 수학점수=" + math +
                ", 총점=" + sum +
                ", 등수=" + grade +
                '}';
    }

    @Override
    public int compareTo(Student stuNum) {
        return Integer.compare(this.getStuNum(), stuNum.getStuNum());
    }

}

class SortByTotal {

    private int stuNum; // 학번
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private int grade; // 등수

    public SortByTotal(int stuNum, String name, int kor, int eng, int math) {
        this.stuNum = stuNum;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sum = kor + eng + math;
    }

    @Override
    public String toString() {
        return "Student{" +
                "학번=" + stuNum +
                ", 이름='" + name + '\'' +
                ", 국어점수=" + kor +
                ", 영어점수=" + eng +
                ", 수학점수=" + math +
                ", 총점=" + sum +
                ", 등수=" + grade +
                '}';
    }

    public int getSum() {
        return sum;
    }



    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

//    @Override
//    public int compareTo(SortByTotal total) {
//        return Integer.compare(total.getSum(), this.getSum());
//    }

//    @Override
//    public int compareTo(SortByTotal name) {
//        return this.getName().compareTo(name.getName());
//    }

    // 이 2개를 사용할수 없기때문에 위에서 compareTo가 아닌 compare 으로 재정의해서 두개동시에 복합적으로시켜야한다
}
