package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {

    // static붙은 메소드들은 그냥 부를수있다
    //즉 객체를 생성하지않고도 부를수있음
    // 근데 static없는 이런 인스턴스 메소드들은 꼭 객체를 생성한다음에야 부를수있다.
    public void createRank(ArrayList<Student> stuList){
        for (Student student : stuList) {
            int rank = 1;   // 처음1등설정
            for (Student student1 : stuList) { // 비교대상
                if (student.getTotal() < student1.getTotal()) {
                    rank++;
                }
            }
            student.setRank(rank); //최종 랭크 삽입
        }

    }

    public static void main(String[] args) {
        StudentTest stdTest = new StudentTest();


        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(new Student(11, "나나", 50, 60, 82));
        stuList.add(new Student(22, "마마", 25, 48, 74));
        stuList.add(new Student(55, "라라", 31, 82, 52));
        stuList.add(new Student(44, "가가", 76, 11, 60));
        stuList.add(new Student(33, "다다", 44, 34, 100));
        stuList.add(new Student(88, "차차", 55, 34, 11));
        stuList.add(new Student(99, "카카", 71, 45, 40));
        stuList.add(new Student(66, "사사", 23, 67, 55));

        stdTest.createRank(stuList); // 등수 구하는 메소드

        System.out.println("정렬전");
        for (Student student : stuList) {
            System.out.println(student);
        }
        System.out.println("----------------------------------");
        System.out.println("학번 오름차순 정렬");
        Collections.sort(stuList);

        for (Student student : stuList) {
            System.out.println(student);
        }

        Collections.sort(stuList, new SortByTotal());
        System.out.println("총점의 역순 정렬후");

        for (Student student : stuList) {
            System.out.println(student);
        }
    }
}


class Student implements Comparable<Student>{
    private int stuNum; // 학번
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int total;
    private int rank;// 등수

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Student(int stuNum, String name, int kor, int eng, int math) {
        this.stuNum = stuNum;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        total = kor + eng + math;


    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum=" + stuNum +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", total=" + total +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int compareTo(Student stu) {
        return Integer.compare(this.getStuNum(), stu.getStuNum());
    }
}

class SortByTotal implements Comparator<Student> {

    @Override
    public int compare(Student std1, Student std2) {
        if (std1.getTotal() == std2.getTotal()) {
            return std1.getName().compareTo(std2.getName());
        } else {
            return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;
        }
    }
}