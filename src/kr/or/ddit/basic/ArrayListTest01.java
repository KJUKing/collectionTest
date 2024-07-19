package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
    public static void main(String[] args) {


        ArrayList list1 = new ArrayList();

        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add(111);
        list1.add('b');
        list1.add(123.45);

        System.out.println("list1 = " + list1);

        System.out.println("list1.size() = " + list1.size());

        System.out.println("list1.get(3) = " + list1.get(3));

        list1.add(3, "zzz");


        System.out.println("list1 = " + list1);


        String sTemp = (String) list1.set(3, "YYY");
        System.out.println("sTemp = " + sTemp);
        System.out.println("list1 = " + list1);

        list1.remove("bbb");

        //제네렉


        ArrayList<String> list2 = new ArrayList<>();

        list2.add("asd");
//        list2.add(123);
        list2.add("aaa");
        list2.add("asd");

        //contains 비교
        System.out.println("list2.contains(\"asd\") = " + list2.contains("asd"));

        //indexOf(비교객체)
        //lasetIndexOf(비교객체)
        //-> 리스트에 비교객체를 찾아서 해당 비교객체가 있으면 비교객체가 저장된 index값 반환
        //없으면 -1반환
        //indexOf()메소드는 검색 방향이 앞쪽에서 뒤쪽으로 검색
        //lastIndexOf는 뒤쪾에서 앞쪽으로 검색

        System.out.println("list2.indexOf(\"asd\") = " + list2.indexOf("asd"));
        System.out.println("list2.lastIndexOf(\"asd\") = " + list2.lastIndexOf("asd"));
        System.out.println("list2.indexOf(\"aaaaa\") = " + list2.indexOf("aaaaa"));

        // toArray -> 리스트 안의 데이터들을 배열로 변환해서 반환한다
        //          -> 기본적으로 Object형 배열로 변환

        Object[] strArr = list2.toArray();
//        String[] strArr2 = (String[]) list2.toArray(); <- 배열은 형변환이안돼서 캐스팅예외발생
        //스트링 배열로 만들고싶을떄는
        // toArray(new 제네렉타입[0])

        String[] strArr3 = list2.toArray(new String[0]);
        for (String s : strArr3) {
            System.out.println(s);
        }
    }
}
