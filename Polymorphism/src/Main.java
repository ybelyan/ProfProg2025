public class Main {
    public static void main(String[] args) {
        System.out.println("Среднее арифметическое чисел 1, 2, 3, 4, 5, 6: " + avr(1, 2, 3, 4, 5, 6));
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    }
/*
    private static double avr(double num) {
        return num;
    }

    private static double avr(double num1, double num2) {
        return (num1 + num2)/2;
    }

    private static double avr(double num1, double num2, double num3) {
        return (num1 + num2 + num3)/3;
    }

    private static double avr(double num1, double num2, double num3, double num4) {
        return (num1 + num2 + num3+ num4)/4;
    }
    private static double avr(double num1, double num2, double num3, double num4, double num5) {
        return (num1 + num2 + num3 + num4 + num5)/5;
    }
    private static double avr(double num1, double num2, double num3, double num4, double num5, double num6) {
        return (num1 + num2 + num3 + num4 + num5 + num6)/6;
    }*/

    private static double avr(double... nums){
        double sum = 0;
        for(double num : nums) {
            sum += num;
        }
        return sum/nums.length;
    }
}