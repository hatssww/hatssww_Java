public class AverageFinder {
    double computeAverage(int[] intArray) {
        double sumValue = 0;
        for (int num : intArray) {
            sumValue += num;
        }
        return sumValue / intArray.length;
    }
}
