public class UnitConverter {
    public static final double KILOGRAMS_PER_POUND = 0.45359237;
    public static final double POUNDS_PER_KILOGRAM = 1 / KILOGRAMS_PER_POUND;
    public static final double CENTIMETERS_PER_INCH = 2.54;
    public static final double INCHES_PER_CENTIMETERS = 1 / CENTIMETERS_PER_INCH;

    private UnitConverter() {
        // 인스턴스 생성 불가
    }

    public static double toPounds(double kilograms) {
        return POUNDS_PER_KILOGRAM * kilograms;
    }

    public static double toKilograms(double pounds) {
        return KILOGRAMS_PER_POUND * pounds;
    }

    public static double toCentimeters(double inches) {
        return CENTIMETERS_PER_INCH * inches;
    }

    public static double toInches(double centimeters) {
        return INCHES_PER_CENTIMETERS * centimeters;
    }

    // ()를 없애서 double 값이 리턴되도록 해주어야 함.
    public static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}