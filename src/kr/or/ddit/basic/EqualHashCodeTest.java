package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualHashCodeTest {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setNum(1);
        p1.setName("홍길동");

        Person p2 = new Person();
//        p2.setNum(2);
//        p2.setName("이순신");

        p2.setNum(1);
        p2.setName("홍길동");

        Person p3 = p1;

        System.out.println(p1 == p2);
        System.out.println(p1 == p3);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        HashSet<Person> testSet = new HashSet<>();
        testSet.add(p1);
        testSet.add(p2);
        System.out.println("set의 개수 - " + testSet.size());

        /*
        equals  equality 동등성
        hashCode identity 동일성
        HashSet hashMap hashTable 전부 이퀄스 해쉬코드 재정의해줘야함
         */


    }
}

class Person {
    private int num;
    private String name;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return num == person.num && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }
}