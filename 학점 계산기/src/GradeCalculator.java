import java.util.ArrayList;

public class GradeCalculator {
    public final String name;
    public final double currentScore;
    public final int currentCredit;

    private final ArrayList<Course> courses = new ArrayList<>();


    public GradeCalculator(String name, double currentScore, int currentCredit) {
        this.name = name;
        this.currentScore = currentScore;
        this.currentCredit = currentCredit;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void print() {
        double scoreSum = 0;
        int creditSum = 0;

        for (Course c : courses) {
            scoreSum += c.getScore() * c.credit;
            creditSum += c.credit;
        }

        double totalscore = currentScore * currentCredit + scoreSum;
        int totalcredit = currentCredit + creditSum;

        System.out.println("직전 학기 성적: " + currentScore + " (총 " + currentCredit + "학점)\n"
                + "이번 학기 성적: " + (scoreSum / creditSum) + " (총 " + creditSum + "학점)\n"
                + "전체 예상 학점: " + (totalscore / totalcredit) + " (총 " + totalcredit + "학점)");
    }
}
