package kr.or.ddit.basic;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RoomTest {
    private HashMap<Integer, Room> roomMap = new HashMap<>();
    public static void main(String[] args) {
        RoomTest room = new RoomTest();
        room.createRoom();

        room.start();
    }

    private void createRoom() {
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; j <= 9; j++) {
                int roomNum = i * 100 + j;
                String roomClass = null;
                if (i == 2) {
                    roomClass = "싱글룸";
                } else if (i == 3) {
                    roomClass = "더블룸";
                } else {
                    roomClass = "스위트룸";
                }
                roomMap.put(roomNum, new Room(roomNum, roomClass, "-"));
            }
        }
    }

    private void start() {
        while (true) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    checkIn();
                    break;
                case 2:
                  checkOut();
                    break;
                case 3:
                    roomStatus();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }
    }

    private void checkOut() {
        Scanner sc = new Scanner(System.in);
        boolean isRoomFound = false;

        System.out.println("---------------------------------------------");
        System.out.println("      체크인 작업");
        System.out.println("---------------------------------------------");
        System.out.println("체크아웃 할 방 번호를 입력하세요.");
        System.out.print("방 번호 입력 : ");
        int roomNum = sc.nextInt();
        for (Integer i : roomMap.keySet()) {
            Room room = roomMap.get(i);
            if (room.getRoomNum()==roomNum) {
                isRoomFound = true;
                String name = room.getName();
                if (room.getName().equals("-")) {
                    System.out.println(roomNum+"호 객실에는 체크인 한 사람이 없습니다.");
                } else {
                    sc.nextLine(); //버퍼 클리어
                    room.setName("-");
                    System.out.println(roomNum+"호 객실의 "+name+"님 체크아웃이 완료되었습니다.");
                    break;
                }
            }
        }
        System.out.println("---------------------------------------------");

        if (!isRoomFound) {
            System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
        }
    }

    private void roomStatus() {
        System.out.println("현재 객실 상태");
        System.out.println("방 번호    방 종류    투숙객 이름");
        Map<Integer, Room> sortedRoom = new TreeMap<>(roomMap);
        for (Map.Entry<Integer, Room> roomEntry : sortedRoom.entrySet()) {
            System.out.println(roomEntry.getValue().getRoomNum() +"    "+
                    roomEntry.getValue().getRoomClass() +"    "+ roomEntry.getValue().getName());
        }
    }

    private void checkIn() {
        Scanner sc = new Scanner(System.in);
        boolean isRoomFound = false;

        System.out.println("---------------------------------------------");
        System.out.println("      체크인 작업");
        System.out.println("---------------------------------------------");
        System.out.println("* 201~209 : 싱글룸");
        System.out.println("* 301~309 : 더블룸");
        System.out.println("* 401~409 : 스위트룸");
        System.out.println("---------------------------------------------");
        System.out.print("방 번호 입력 : ");
        int roomNum = sc.nextInt();

        for (Integer i : roomMap.keySet()) {
            Room room = roomMap.get(i);
            if (room.getRoomNum()==roomNum) {
                isRoomFound = true;
                if (!(room.getName().equals("-"))) {
                    System.out.println(roomNum+"호 객실은 이미 손님이 있습니다.");
                } else {
                    sc.nextLine(); //버퍼 클리어
                    System.out.print("이름 입력 :");
                    String name = sc.nextLine();
                    room.setName(name);
                    System.out.println("체크인이 완료되었습니다.");
                    break;
                }
            }
        }
        if (!isRoomFound) {
            System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
        }
    }

    private int displayMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("호텔문을 열었습니다. 어서오십시요.");
        System.out.println("*********************************************");
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("어떤 업무를 하시겠습니까?");
        System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.print("선택 : ");
        return sc.nextInt();
    }
}

class Room {
    private int roomNum;
    private String roomClass;
    private String name;

    public Room(int roomNum, String roomClass, String name) {
        this.roomNum = roomNum;
        this.roomClass = roomClass;
        this.name = name;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNum=" + roomNum +
                ", roomClass='" + roomClass + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
