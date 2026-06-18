package A_PlusMaker;

import java.time.LocalDate; // 💡 자바의 내장 날짜 클래스 호출!

public class Task implements Comparable<Task> {
    private String subjectName;
    // 💡 [선배의 팁] String 대신 LocalDate를 사용해서 진정한 날짜 데이터를 다뤄!
    private LocalDate deadline;
    private String gradingType;
    private String testType;

    public Task(String subjectName, LocalDate deadline, String gradingType, String testType) {
        this.subjectName = subjectName;
        this.deadline = deadline;
        this.gradingType = gradingType;
        this.testType = testType;
    }

    public String getSubjectName() { return subjectName; }
    public LocalDate getDeadline() { return deadline; }
    public String getGradingType() { return gradingType; }
    public String testType() { return testType; }

    @Override
    public int compareTo(Task otherTask) {
        // 💡 [객체 정렬] LocalDate 내부에 이미 날짜를 비교하는 기능이 있어서 코드가 엄청 깔끔해짐!
        return this.deadline.compareTo(otherTask.deadline);
    }

    public void printTaskInfo() {
        // LocalDate는 출력할 때 자동으로 "YYYY/MM/DD" 형태로 예쁘게 나와.
        System.out.print("마감일: " + deadline + " | 과목명: " + subjectName + " | " + gradingType + " | " + testType + "\n");
    }

}