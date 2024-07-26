package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
    /**
     * Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
     * <p>
     * Map은 key값과 value값에 모든 종류의 자료들을 사용할 수 있지만
     * Properties는 key값과 value값에 String만 사용할수있다.
     * <p>
     * Map은 put(), get()메소드를 이용하여 데이터를 입출력하지만
     * Properties는 setProperty(), getProperty() 메소드를 이용하여 데이터를 입출력한다
     * <p>
     * Properties는 데이터를 파일로 입출력할수있다.
     */

    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("name", "홍길동");
        prop.setProperty("tel", "010-8796-3036");
        prop.setProperty("addr", "대전");
        prop.setProperty("age", "20");

        String name = prop.getProperty("name");
        System.out.println("name = " + name);

        int age = Integer.parseInt(prop.getProperty("age"));
        System.out.println("age = " + age);
    }

}
