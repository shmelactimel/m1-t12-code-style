import java.util.Scanner;

public class DepositCalculator {

    public double calculateComplexPercent(double principal, double annualInterestRate, int years) {
        double pay = principal * Math.pow((1 + annualInterestRate / 12), 12 * years);
        return round(pay, 2);
    }

    public double calculateSimplePercent(double principal, double annualInterestRate, int years) {
        return round(principal + principal * annualInterestRate * years, 2);
    }

    public double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public void doImportantJob() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада: 1 - вклад с обычным процентом, 2 - вклад с капитализацией");
        int action = scanner.nextInt();

        double result = 0;

        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}
