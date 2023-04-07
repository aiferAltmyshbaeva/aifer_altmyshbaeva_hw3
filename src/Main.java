public class Main {
    public static void main(String[] args) {
        double[] digits = new double[15];
        digits = initArray(digits);
//        digits = initTestArray();
        double average = calculateAverage(digits);

        System.out.println("Для массива ");
        print(digits);
        System.out.println("Среднее арифметическое " + average);

        sort(digits);
    }

    private static double calculateAverage(double[] digits) {
        double sum = 0.0;
        double count = 0.0;
        boolean isPreviousNegative = false;

        for (double digit : digits) {
            if (digit > 0) {
                if (isPreviousNegative == true) {
                    sum += digit;
                    count++;
                }
            } else {
                isPreviousNegative = true;
            }
        }

        return sum / count;
    }

    private static double[] sort(double[] digits){
        for (int j = 0; j < digits.length - 1; j++) {
            double min = digits[j];
            int index = j;
            for (int i = j + 1; i < digits.length; i++) {
                if (digits[i] < min){
                    min = digits[i];
                    index = i;
                }
            }
            if (digits[j] != digits[index]) {
                double temp = digits[j];
                digits[j] = digits[index];
                digits[index] = temp;
            }
            print(digits);
        }
        return digits;
    }

    private static double generateRandomDouble() {
        double min = -100.0;
        double max = 100.0;
        return ((Math.random() * (max - min)) + min);
    }

    private static double[] initArray(double[] digits) {
        for (int i = 0; i < digits.length; i++) {
            digits[i] = generateRandomDouble();
        }
        return digits;
    }

    private static double[] initTestArray() {
        double[] digits = {8, -2, -4, 2, 3, 6, -7};
        return digits;
    }

    private static void print(double[] digits) {
        for (double digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}