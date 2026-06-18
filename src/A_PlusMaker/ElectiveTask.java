package A_PlusMaker;

// 💡 [상속] Task 클래스 확장
public class ElectiveTask extends Task {

    private boolean isPassFail; // 교양 특유의 Pass/Fail 여부

    public ElectiveTask(String subjectName, String deadline, String gradingType, boolean isPassFail) {
        super(subjectName, deadline, gradingType);
        this.isPassFail = isPassFail;
    }

    // 💡 [오버라이딩] 부모의 출력을 교양 버전에 맞게 덮어쓰기!
    @Override
    public void printTaskInfo() {
        System.out.print("📗 [교양] ");
        super.printTaskInfo();
        System.out.println(" | 📝 P/F: " + (isPassFail ? "O" : "X"));
    }
}