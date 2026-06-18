package A_PlusMaker;

// 💡 [상속 적용 부분]
// 선배의 팁: 'extends' 키워드를 써서 부모인 Task 클래스의 속성과 기능을 그대로 물려받았어.
// 중복된 코드를 다시 짤 필요가 없으니 엄청 편하지!
// 💡 [상속] Task의 모든 필드와 메서드를 물려받음
public class MajorTask extends Task {

    private boolean isTeamProject;

    public MajorTask(String subjectName, String deadline, String gradingType, boolean isTeamProject) {
        super(subjectName, deadline, gradingType); // 부모 생성자 호출
        this.isTeamProject = isTeamProject;
    }

    // 💡 [오버라이딩] 부모의 출력을 전공 버전에 맞게 덮어쓰기!
    @Override
    public void printTaskInfo() {
        System.out.print("📘 [전공] ");
        super.printTaskInfo();
        System.out.println(" | 👥 팀플: " + (isTeamProject ? "O" : "X"));
    }
}