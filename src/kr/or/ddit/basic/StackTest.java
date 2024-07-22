package kr.or.ddit.basic;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {

        Browser b = new Browser();
        b.history();

        b.goURL("1.네이버");
        b.history();

        b.goURL("2.야후");
        b.history();

        b.goURL("3.구글");
        b.history();

        b.goURL("4.다음");
        b.history();

        System.out.println("뒤로가기 후..");
        b.goBack();
        b.history();

        System.out.println("앞으로 가기 후..");
        b.goForward();
        b.history();

    }
}

//웹브라우저의 앞으로가기, 뒤로가기 기능 구현(스택 이용)

class Browser {
    private Stack<String> back;
    private Stack<String> forWard;
    private String currentURL;

    //생성자
    public Browser() {
        back = new Stack<>();
        forWard = new Stack<>();
        currentURL = "";
    }

    //사이트를 방문하는 메소드 -> 매개변수에는 방문할 url이 저장되어 호출됨
    public void goURL(String url) {
        System.out.println(url + "사이트에 접속");
        if (currentURL != null && !"".equals(currentURL)) { //현재 페이지가 있다는뜻
            back.push(currentURL); //현재페이지를 back에 추가함
        }

        currentURL = url;
        forWard.clear();
    }

    //뒤로가기
    public void goBack() {
        if (!back.isEmpty()) {
            forWard.push(currentURL); //현재 페이지를 forward스택에 추가
            currentURL = back.pop(); //back에서 1개의 요소를 꺼내와 현재 페이지로 한다

        }
    }

    public void goForward() {
        if (!forWard.isEmpty()) {
            back.push(currentURL);
            currentURL = forWard.pop();
        }
    }

    public void history() {
        System.out.println("----------------------------");
        System.out.println("방문 기록");
        System.out.println("----------------------------");
        System.out.println("back = " + back);
        System.out.println("currentURL = " + currentURL);
        System.out.println("forWard = " + forWard);
    }
}

