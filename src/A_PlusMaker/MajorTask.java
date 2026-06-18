package A_PlusMaker;

// 💡 [상속 적용 부분]
// 선배의 팁: 'extends' 키워드를 써서 부모인 Task 클래스의 속성과 기능을 그대로 물려받았어.
// 중복된 코드를 다시 짤 필요가 없으니 엄청 편하지!
public class MajorTask extends Task {

    private boolean isTeamProject; // 전공만의 고유 특성

    public MajorTask(String subjectName, String deadline, boolean isTeamProject) {
        // 부모의 생성자를 호출해서 공통 속성을 먼저 초기화해 줘야 해.
        super(subjectName, deadline);
        this.isTeamProject = isTeamProject;
    }

    // 💡 [오버라이딩(Overriding) 적용 부분] 
    // 선배의 팁: 부모가 물려준 printTaskInfo() 메서드를 전공 과제 입맛에 맞게 재정의(덮어쓰기) 했어!
    @Override
    public void printTaskInfo() {
        System.out.print("[전공] ");
        super.printTaskInfo(); // 부모의 출력 기능을 먼저 부르고
        // 삼항 연산자를 써서 boolean 값을 O/X로 예쁘게 출력
        System.out.println("  -> 👥 팀 프로젝트 여부: " + (isTeamProject ? "O" : "X"));
    }
}