package A_PlusMaker;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 💡 [다형성 적용을 위한 준비]
        // 선배의 팁: 부모 타입(Task)의 리스트를 만들었어.
        // 부모 품이 넓어서 자식들인 MajorTask, ElectiveTask를 모두 이 하나의 리스트에 담을 수 있지!
        ArrayList<Task> taskList = new ArrayList<>();

        System.out.println("=====================================");
        System.out.println("  📝 대학생 맞춤형 과제 마감 알리미 📝  ");
        System.out.println("=====================================");

        // 1. 전공 과제 입력받기
        System.out.println("\n[1] 전공 과제 정보를 입력하세요.");
        System.out.print("과목명: ");
        String majorSubject = scanner.nextLine();
        System.out.print("마감일(예: 11월 15일): ");
        String majorDeadline = scanner.nextLine();
        System.out.print("팀 프로젝트인가요? (true/false): ");
        boolean isTeam = scanner.nextBoolean();
        scanner.nextLine(); // 엔터(개행문자) 버퍼 비우기 (스캐너의 고질적인 문제 방지용!)

        taskList.add(new MajorTask(majorSubject, majorDeadline, isTeam));

        // 2. 교양 과제 입력받기
        System.out.println("\n[2] 교양 과제 정보를 입력하세요.");
        System.out.print("과목명: ");
        String elecSubject = scanner.nextLine();
        System.out.print("마감일(예: 11월 20일): ");
        String elecDeadline = scanner.nextLine();
        System.out.print("Pass/Fail 평가인가요? (true/false): ");
        boolean isPF = scanner.nextBoolean();
        scanner.nextLine();

        taskList.add(new ElectiveTask(elecSubject, elecDeadline, isPF));

        // 3. 과제 정보 일괄 출력 (다형성의 꽃)
        System.out.println("\n=====================================");
        System.out.println("         ⏰ 등록된 과제 목록 ⏰         ");
        System.out.println("=====================================");

        // 💡 [다형성(Polymorphism) 완벽 적용 부분]
        // 선배의 팁: 리스트의 타입이 부모(Task)라서 부모의 printTaskInfo()를 부르는 것처럼 보이지만,
        // 실제로 메모리에 올라가 있는 객체는 자식들이잖아?
        // 그래서 JVM이 똑똑하게 알아서 각 자식 클래스에서 '오버라이딩 된' 메서드를 실행해 줘!
        // 조건문(if-else)으로 "전공이니? 교양이니?" 물어볼 필요가 없어지는 거지.
        for (Task task : taskList) {
            task.printTaskInfo();
            System.out.println("-------------------------------------");
        }

        System.out.println("모든 과제가 성공적으로 등록되었습니다. 화이팅! 🚀");
        scanner.close();
    }
}
