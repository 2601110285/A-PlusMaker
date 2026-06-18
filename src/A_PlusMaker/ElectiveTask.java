package A_PlusMaker;

public class ElectiveTask extends Task {

    private boolean isPassFail; // 교양만의 고유 특성

    public ElectiveTask(String subjectName, String deadline, boolean isPassFail) {
        super(subjectName, deadline);
        this.isPassFail = isPassFail;
    }

    // 💡 [오버라이딩(Overriding) 적용 부분]
    @Override
    public void printTaskInfo() {
        System.out.print("[교양] ");
        super.printTaskInfo();
        System.out.println("  -> 📝 Pass/Fail 평가 여부: " + (isPassFail ? "O" : "X"));
    }
}
