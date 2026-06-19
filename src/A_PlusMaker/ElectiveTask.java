package A_PlusMaker;

import java.time.LocalDate;

public class ElectiveTask extends Task {

    public ElectiveTask(String subjectName, LocalDate deadline, String gradingType, String testType) {
        super(subjectName, deadline, gradingType, testType);
    }

    @Override
    public void printTaskInfo() {
        System.out.print("📗 [교양] ");
        super.printTaskInfo();
    }
}