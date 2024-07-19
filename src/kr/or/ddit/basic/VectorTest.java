package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {
        Vector v1 = new Vector();

        System.out.println("v1의 크기 = " + v1);

        //데이터 추가하기 : add(추가할 데이터)
        //반환값 : 추가성공true 실패 false반환
        v1.add("AAAA");
        v1.add(new Integer(111));
        v1.add(123);
        v1.add('a');
        boolean r = v1.add(3.14);

        System.out.println("v1의 크기: " + v1.size());
        System.out.println("r = " + r);

        //데이터 추가하기2 : addElement(추가할데이터)
        //이전버전의 프로그램과 호환성을 위해 남아있는 메소드
        v1.addElement("CCCCCCCC");
        System.out.println("v1 => "+ v1.toString());

        //데이터 추가하기3 add(index, 데이터)
//        ==> 'index'번째에 데이터를 끼워넣는다
        v1.add(1, "KKKK");
        System.out.println("v1 ->" + v1);

        //데이터 꺼내오기 : get(index)
        // index번째 데이터 꺼내서 반환하기
        System.out.println("0번째 데이터: " + v1.get(0));


        int iTemp = (int) v1.get(2);
        System.out.println("2번째 데이터 :" + iTemp);

        //데이터 수정하기 set (index, 새로운데이터)
        // 교체되어 나오는 원래의 데이터값이 반환값으로 나온다
        Object sTemp = v1.set(2, "zero");
        System.out.println("sTemp = " + sTemp);

        //데이터 삭제하기 remove(index)
        //삭제된 데이터가 반환값으로 나옴
        Object remove = v1.remove(0);
        System.out.println("remove = " + remove);

        //데이터 삭제하기2 : remove(삭제할 데이터)
        // 삭제할 데이터를 찾아서 삭제
        // 삭제할데이터가 중복되면 순서상 가장 첫번째가 삭제
        // 삭제되면 true 실패 false

//        v1.remove(new Integer(123));
        v1.remove(Integer.valueOf(123)); // 이걸쓰자

        v1.remove(Character.valueOf('a'));

        v1.remove(3.14);

        v1.remove(true);

        /*
        제네렉 타입 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할때 외부에서 지정
         */

        Vector<Integer> v2 = new Vector<>();
        Vector<String> v3 = new Vector<>();

        v3.add("안녕하세요");

        String s = v3.get(0);

        Vector<Vector> vv = new Vector<>(); //2차원배열

        v3.clear();

        v3.add("A");
        v3.add("B");
        v3.add("C");
        v3.add("D");

        Vector<String> v4 = new Vector<>();
        v4.add("B");
        v4.add("E");

        System.out.println("v3 = " + v3);
        System.out.println("v4 = " + v4);

        // 데이터삭제하기 removeAll
        // 클래스형태가 같다면 갖다붙혀서 없앨수도있다
        v3.removeAll(v4);

        System.out.println("v3 = " + v3);

        for (String string : v3) {
            System.out.println("string = " + string);
        }

    }
}
