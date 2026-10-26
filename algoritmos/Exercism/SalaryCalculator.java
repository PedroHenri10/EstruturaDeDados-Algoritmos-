
class SalaryCalculator {

    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= 5 ? 0.85 : 1.0;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13 : 10;
    }

    public int bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double salary = 1000.00 * salaryMultiplier(daysSkipped)
                + bonusForProductsSold(productsSold);

        return salary > 2000.00 ? 2000.00 : salary;
    }
}

/*
class SalaryCalculator {

    private static final double BASE_SALARY = 1000.0;
    private static final double REDUCED_SALARY_MULTIPLIER = 0.85;
    private static final double NORMAL_SALARY_MULTIPLIER = 1.0;
    private static final int ABSENCE_LIMIT = 5;

    private static final int BONUS_THRESHOLD = 20;
    private static final int NORMAL_BONUS = 10;
    private static final int INCREASED_BONUS = 13;

    private static final double MAX_SALARY = 2000.0;

    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= ABSENCE_LIMIT
                ? REDUCED_SALARY_MULTIPLIER
                : NORMAL_SALARY_MULTIPLIER;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= BONUS_THRESHOLD
                ? INCREASED_BONUS
                : NORMAL_BONUS;
    }

    public int bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double salary = BASE_SALARY * salaryMultiplier(daysSkipped)
                + bonusForProductsSold(productsSold);

        return Math.min(salary, MAX_SALARY);
    }
}
*/
