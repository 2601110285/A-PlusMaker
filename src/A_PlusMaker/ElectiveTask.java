package A_PlusMaker;

import java.time.LocalDate;

public class ElectiveTask extends Task {

    public String test;

    public ElectiveTask(String subjectName, LocalDate deadline, String gradingType, String testType) {
        super(subjectName, deadline, gradingType, testType);
        this.test = test;
    }

    @Override
    public void printTaskInfo() {
        System.out.print("📗 [교양] ");
        super.printTaskInfo();
        System.out.println(" | " + (test ? "과제제출" : "필기시험"));
    }
}