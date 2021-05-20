public class GreatestDifferenceFinder {
    int greatestDifference(int[] intArray) {
        if (intArray.length < 2) {
            return 0;
        } else {
            int min = intArray[0];
            int max = intArray[0];

            for (int i = 1; i < intArray.length; i++) {
                if (min > intArray[i]) {
                    min = intArray[i];
                }
                if (max < intArray[i]) {
                    max = intArray[i];
                }
            }
            return max - min;
        }
    }
}

