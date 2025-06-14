public class Main {
    public static void main(String[] args) {
        isArmstrong();
    }

    private static void isArmstrong() {
        boolean firstNum = true;
        for (int i = 0; i < 10000; i++) {
            int sum = 0;
            int number = i;
            int amountOfDigits = (int) (Math.log10(number) + 1);
            while (number > 0) {
                int digit = number % 10;
                sum += (int) Math.pow(digit, amountOfDigits);
                number /= 10;
            }
            if (sum != i) {
                continue;
            } else if (!firstNum) {
                System.out.print(", ");
            } else {
                firstNum = false;
            }
            System.out.print(sum);
        }
    }
}