package A_PlusMaker;

// 💡 [선배의 팁] Comparable<Task> 인터페이스를 구현(implements)해서,
// 이 객체들이 '마감일'을 기준으로 스스로 정렬될 수 있는 능력을 갖추게 했어!
public class Task implements Comparable<Task> {

    // 💡 [캡슐화] private으로 데이터 보호
    private String subjectName;
    private String deadline;    // 정렬을 위해 "MM-dd" 형식으로 입력받을 거야
    private String gradingType; // "절대평가" or "상대평가"

    // 💡 [생성자] 과제 객체가 생성될 때 필수 정보 세팅
    public Task(String subjectName, String deadline, String gradingType) {
        this.subjectName = subjectName;
        this.deadline = deadline;
        this.gradingType = gradingType;
    }

    // Getter & Setter (캡슐화된 데이터에 접근)
    public String getSubjectName() { return subjectName; }
    public String getDeadline() { return deadline; }
    public String getGradingType() { return gradingType; }

    // 공통 출력 메서드
    public void printTaskInfo() {
        System.out.print("마감일: " + deadline + " | 과목명: " + subjectName + " (" + gradingType + ")");
    }

    // 💡 [객체 정렬을 위한 오버라이딩]
    // 선배의 팁: 마감일(문자열)을 기준으로 오름차순(빠른 날짜부터) 정렬하도록 규칙을 재정의한 거야.
    @Override
    public int compareTo(Task otherTask) {
        return this.deadline.compareTo(otherTask.deadline);
    }
}