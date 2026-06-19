package A_PlusMaker;

import java.time.LocalDate;

public class MajorTask extends Task {

    public MajorTask(String subjectName, LocalDate deadline, String gradingType, String testType) {
        super(subjectName, deadline, gradingType, testType);
    }

    @Override
    public void printTaskInfo() {
        System.out.print("📘 [전공] ");
        super.printTaskInfo();
    }
}