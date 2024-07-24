package kr.or.ddit.basic;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("이름", "홍길동");
        map.put("주소", "대전시");
        map.put("전화번호", "010-1234-5678");

        System.out.println("map -> " + map);

        //자료 수정 -> 데이터를 추가할때 key값이 같으면 나중에 추가한 값이 저장된다

        map.put("주소", "서울시");
        System.out.println("map = " + map);

        //자료 삭제 remove(key값) 반환값은 삭제된 자료의 value값 반환
//        String removeTel = map.remove("전화번호");
//        System.out.println("removeTel = " + removeTel);
        //자료 읽기 get(키값)
        System.out.println("map.get(\"이름\") = " + map.get("이름"));

        //자료 존재여부 containsKey(키값)
        System.out.println("map.containsKey(\"이름\") = " + map.containsKey("이름"));

        // Map 저장된 모든 자료를 차례로 사용하는 방법

        // 1. 모든key값 읽어서 처리 keySet()메소드
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }

        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            System.out.println(key + " : " + value);

        }
        System.out.println("-----------------------------");

        for (String value : map.values()) {
            System.out.println("value = " + value);
        }

        Set<Map.Entry<String, String>> mapEntrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> entryIt = mapEntrySet.iterator();
        while (entryIt.hasNext()) {
            Map.Entry<String, String> entry = entryIt.next();
            System.out.println("key값 : " + entry.getKey());
            System.out.println("Val값 : " + entry.getValue());
        }
    }
}
