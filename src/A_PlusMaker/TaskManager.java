package A_PlusMaker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();

        System.out.println("=====================================");
        System.out.println("  🎯 TaskCatch: 마감일 꽉 잡는 알리미 🎯  ");
        System.out.println("=====================================");

        System.out.print("\n등록할 과목의 개수를 입력하세요: ");
        int taskCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < taskCount; i++) {
            System.out.println("\n--- [" + (i + 1) + "번째 과제 등록] ---");

            // 💡 [방어적 프로그래밍 1] 과목 유형 1, 2 외의 값 차단
            int type;
            while (true) {
                System.out.print("과목 유형을 선택하세요 (1: 전공, 2: 교양): ");
                String typeInput = scanner.nextLine().trim(); // trim()은 혹시 모를 띄어쓰기 공백을 없애줌
                if (typeInput.equals("1") || typeInput.equals("2")) {
                    type = Integer.parseInt(typeInput);
                    break; // 올바른 값이면 무한 루프 탈출
                }
                System.out.println("🚨 [입력 오류] 1(전공) 또는 2(교양)만 입력 가능합니다. 다시 선택해주세요.");
            }

            System.out.print("과목명: ");
            String subjectName = scanner.nextLine();

            // 💡 [자바 내장 날짜 API 활용]
            LocalDate parsedDate;
            while (true) {
                System.out.print("마감일 (예: 06-20, 11/15): ");
                String inputDeadline = scanner.nextLine();

                try {
                    // 💡 [선배의 꿀팁 1] 사용자가 실수로 슬래시(/)나 점(.)을 써도 하이픈(-)으로 싹 바꿔줌!
                    inputDeadline = inputDeadline.replaceAll("[/.]", "-");

                    int currentYear = LocalDate.now().getYear();
                    String fullDate = currentYear + "-" + inputDeadline;

                    // 💡 [선배의 꿀팁 2] 'MM-dd' 대신 'M-d'를 쓰면 06도 통과, 6도 통과!
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

                    parsedDate = LocalDate.parse(fullDate, formatter);
                    break;

                } catch (DateTimeParseException e) {
                    System.out.println("🚨 [입력 오류] 존재하지 않는 날짜입니다. 다시 입력해주세요.");
                }
            }

            String gradingType;
            while (true) {
                System.out.print("평가 방식 (1: 절대평가, 2: 상대평가): ");
                String gradingInput = scanner.nextLine().trim();
                if (gradingInput.equals("1")) {
                    gradingType = "절대평가";
                    break;
                } else if (gradingInput.equals("2")) {
                    gradingType = "상대평가";
                    break;
                }
                System.out.println("🚨 [입력 오류] 1(절대평가) 또는 2(상대평가)만 입력 가능합니다. 다시 선택해주세요.");
            }

            String testType;
            while (true) {
                System.out.print("평가 방식 (1: 과제제출, 2: 필기시험): ");
                String testInput = scanner.nextLine().trim();
                if (testInput.equals("1")) {
                    testType = "과제제출";
                    break;
                } else if (testInput.equals("2")) {
                    testType = "필기시험";
                    break;
                }
                System.out.println("🚨 [입력 오류] 1(과제제출) 또는 2(필기시험)만 입력 가능합니다. 다시 선택해주세요.");
            }

            // 입력받은 type(1:전공, 2:교양)에 맞춰서 알맞은 자식 객체를 생성해야 해!
            if (type == 1) {
                taskList.add(new MajorTask(subjectName, parsedDate, gradingType, testType));
            } else {
                taskList.add(new ElectiveTask(subjectName, parsedDate, gradingType, testType));
            }
        }

        Collections.sort(taskList);

        System.out.println("\n=======================================================");
        System.out.println(" ⏰ [마감일 임박 순] 과제 입박! ⏰ ");
        System.out.println("=======================================================");

        for (Task task : taskList) {
            task.printTaskInfo();
        }

        System.out.println("=======================================================");
        System.out.println("모든 과목 정리 완료! A+ 가자! 🚀");

        scanner.close();
    }
}