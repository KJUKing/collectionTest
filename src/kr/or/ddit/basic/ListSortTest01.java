package kr.or.ddit.basic;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 정렬과 관련된 interface는 comparable comparator 두가지가있음

 comparable은 collection에 추가되는 데이터 자체에 정렬기준을 넣고 싶을때
 구현하는 인터페이스
 (내부정렬기준)
 comparator은 외부에 별도로 정렬기준을 구현하고싶을때 구현하는 인터페이스
 (외부정렬기준)

 comparable에서는 compareTo()메소드 재정의
 comparator에서는 compare()메서드를 재정의한다

 String, Wrapper, Date, File클래스에는 이미 내부정렬 기준이 구현되어있다.
 (구현된 내부정렬기준은 오름차순으로 처리되도록 구현되어있음)


 */
public class ListSortTest01 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("안녕");
        list.add("나는");
        list.add("지렁이야");
        list.add("반가워");
        list.add("너는누구니");

        System.out.println("list = " + list);

        //정렬은 Collections.sort()메소드를 이용하여 정렬
        //Collections.sort()메소드는 기본적으로 내부정렬기준으로 정렬
        Collections.sort(list);
        System.out.println("list = " + list);
        Collections.shuffle(list);
        System.out.println("list = " + list);

        Collections.sort(list, new Desc());
        System.out.println("list = " + list);

    }
}

//정렬 방식을 정해주는 class를 만든다(외부 정렬 기준 클래스라고함
// -> comparator인터페이스를 구현해서 작성함

class Desc implements Comparator<String> {
    // compare()메소드를 이용해서 정렬하고자하는 기준을 정해준다.

    // compare()메소드의 반환값의 의미
    // 반환값이 0이면 두 값이 같음
    // 반환값이 양수면 두값의 순서를 바꿈
    // 반환값이 음수면 두값의 순서를 바꾸지 않는다.
    // 예) 오름차순일 경우 -> 앞의 값이 크면 양수
    //                              같으면 0
    //                              작으면 음수 반환
    @Override
    public int compare(String o1, String o2) {
        // 내림차순으로 구현하려고 함
        if (o1.compareTo(o2) > 0) {
            return -1;
        } else if (o1.compareTo(o2) < 0) {
            return 1;
        }else {
            return 0;
        }
    }
}
