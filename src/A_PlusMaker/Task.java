package A_PlusMaker;

public class Task {
    // 💡 [캡슐화/접근제한자 적용 부분]
    // 선배의 팁: 외부에서 함부로 값을 바꾸지 못하도록 필드를 'private'으로 막아뒀어.
    // 이렇게 데이터를 보호하는 게 객체지향의 기본인 캡슐화야!
    private String subjectName;
    private String deadline;

    // 💡 [생성자 적용 부분]
    // 선배의 팁: 객체가 처음 만들어질 때(new 될 때) 반드시 필요한 값들을 세팅해주는 역할이야.
    public Task(String subjectName, String deadline) {
        this.subjectName = subjectName;
        this.deadline = deadline;
    }

    // 캡슐화된 필드에 안전하게 접근하기 위한 Getter / Setter
    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    // 과제 정보를 출력하는 기본 메서드
    public void printTaskInfo() {
        System.out.println("과목명: " + subjectName + " | 마감일: " + deadline);
    }
}