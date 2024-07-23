package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class setTest {
    public static void main(String[] args) {
        /**
         List Set 차이점
         1. List
            - 데이터의 순서(index)가 있다.
            - 중복되는 데이터를 저장할수있음

         2. Set
            - 데이터의 순서(index)가 없다.
            - 중복되는 데이터를 저장할수없음
         */

        HashSet hs1 = new HashSet();

        //set에 데이터 추가 .add
        hs1.add("DD");
        hs1.add("AA");
        hs1.add(2);
        hs1.add("CC");
        hs1.add("BB");
        hs1.add(1);
        hs1.add(3);

        System.out.println("hs1.size() = " + hs1.size());
        System.out.println("hs1 = " + hs1);
        System.out.println();

        // set에 중복되는 데이터추가시 false반환, 데이터 추가안됨
        boolean isAdd = hs1.add("FF");
        System.out.println("isAdd = " + isAdd);
        System.out.println("hs1 = " + hs1);

        boolean isAdd1 = hs1.add("CC");
        System.out.println("isAdd1 = " + isAdd1);
        System.out.println("hs1 = " + hs1);


        //set의 데이터를 수정하려면 수정하는 방법이없기에
        // 해당자료 삭제후 추가해주는방법으로 해야함

        //삭제하는 메소드 remove 삭제시 true 못할시 false
        //clear 전체삭제

        // "FF"를 "EE"로 변경
        hs1.remove("FF");
        System.out.println("삭제후 : " + hs1);
        hs1.add("EE");
        System.out.println("추가후 : " + hs1);

        // clear후에 set

        //Set의 데이터는 순서가 없기때문에 List처럼 index로 데이터를 하나씩 불러올수없음
        //그래서 데이터를 하나씩 얻기위해서는 Iterator형 객체로 변환해야함
        //Set형의 데이터들을 Iterator형 객체로 변환하는 메소드는 iterator()

        Iterator it = hs1.iterator();

        //Iterator의 hasNext()메소드
        //          Iterator의 포인터가 가르키는 곳의 다음번째 위치에 데이터가 있는지 검사
                        // 있으면 true 없으면 false
        while (it.hasNext()) {
            //Iterator next()메소드
            // iterator의 포인터를 다음번째 위치로 이동 시킨 후 이동한 위치에 있는 데이터 반환
            System.out.println(it.next());

        }

        //우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자
        // 번호는 1번부터 29번까지있고 추첨할인원은 3면
        // 당첨번호를 출력해보시오

        // 최소값 ~ 최대값 사이의 정수형 난수 만들기
        // (int)(Math.random() * (최대값 - 최소값+1) + 최소값)

        HashSet<Integer> testSet = new HashSet<>();
        while (testSet.size() < 3) {
            testSet.add((int) (Math.random() * (29 - 1 + 1) + 1));
        }
        System.out.println("당첨자 번호 : " + testSet);

        // Set유형의 자료를 List형으로 변환
        ArrayList<Integer> testList = new ArrayList<>(testSet);
        // 이렇게하면 testSet에있는 자료가 List에 그대로담김
        for (Integer i : testList) {
            System.out.print(i +  " ");
        }
    }
}
