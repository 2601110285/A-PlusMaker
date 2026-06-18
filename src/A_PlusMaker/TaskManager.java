package A_PlusMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 💡 [다형성 준비] 부모(Task) 타입 리스트 하나로 자식(전공, 교양) 객체들을 모두 관리!
        ArrayList<Task> taskList = new ArrayList<>();

        System.out.println("=====================================");
        System.out.println("  🎯 TaskCatch: 마감일 꽉 잡는 알리미 🎯  ");
        System.out.println("=====================================");

        // 원하는 과목 개수 입력받기
        System.out.print("\n등록할 과목의 개수를 입력하세요: ");
        int taskCount = scanner.nextInt();
        scanner.nextLine(); // 엔터 버퍼 비우기

        for (int i = 0; i < taskCount; i++) {
            System.out.println("\n--- [" + (i + 1) + "번째 과제 등록] ---");
            System.out.print("과목 유형을 선택하세요 (1: 전공, 2: 교양): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.print("과목명: ");
            String subjectName = scanner.nextLine();

            // 정렬을 위해 "MM-dd" 형식으로 받음
            System.out.print("마감일 (예: 06-20, 11-15): ");
            String deadline = scanner.nextLine();

            System.out.print("평가 방식 (1: 절대평가, 2: 상대평가): ");
            int gradingChoice = scanner.nextInt();
            String gradingType = (gradingChoice == 1) ? "절대평가" : "상대평가";
            scanner.nextLine();

            if (type == 1) { // 전공 선택 시
                System.out.print("팀 프로젝트인가요? (true/false): ");
                boolean isTeam = scanner.nextBoolean();
                // 💡 [다형성] 부모 타입 리스트에 자식 객체 넣기
                taskList.add(new MajorTask(subjectName, deadline, gradingType, isTeam));
            } else if (type == 2) { // 교양 선택 시
                System.out.print("Pass/Fail 과목인가요? (true/false): ");
                boolean isPF = scanner.nextBoolean();
                taskList.add(new ElectiveTask(subjectName, deadline, gradingType, isPF));
            }
        }

        // 💡 [마감일 순 정렬!]
        // Task 클래스에서 Comparable을 구현했기 때문에 Collections.sort() 한 방에 정렬돼!
        Collections.sort(taskList);

        System.out.println("\n=======================================================");
        System.out.println(" ⏰ [마감일 임박 순] 과제 목록을 한눈에 확인하세요! ⏰ ");
        System.out.println("=======================================================");

        // 💡 [다형성의 하이라이트]
        // 부모 타입인 Task로 반복문을 돌리지만, 실제로는 자식들의 오버라이딩된 printTaskInfo()가 실행됨!
        for (Task task : taskList) {
            task.printTaskInfo();
        }

        System.out.println("=======================================================");
        System.out.println("모든 과제를 꽉 잡았습니다! A+ 가즈아! 🚀");

        scanner.close();
    }
}
