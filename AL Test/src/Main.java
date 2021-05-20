import java.util.ArrayList;

public class Main {
    public static int getSurvivingIndex(int n, int k) {
        ArrayList<Integer> getSurvivingList = new ArrayList<>();

        for (int indexNum = 1; indexNum <= n; indexNum++) {
            getSurvivingList.add(indexNum);
        }

        int killIndex = 0;
        while (getSurvivingList.size() > 1) {
            killIndex = (killIndex + k - 1) % getSurvivingList.size();
            System.out.println(getSurvivingList.remove(killIndex) + "번 군사가 죽습니다.");
        }
        return getSurvivingList.get(0);

    }


    public static void main(String[] args) {
        System.out.println("김신은 " + getSurvivingIndex(20, 5) + "번 자리에 서있으면 됩니다.");
    }
}