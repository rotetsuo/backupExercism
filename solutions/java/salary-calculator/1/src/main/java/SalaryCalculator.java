public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        double value = daysSkipped > 4 ? 0.85 : 1.00;
        return value;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold > 19 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
       return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalValue = (1000 * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold));
        return finalValue > 2000.00 ? 2000.00 : finalValue;
    } 
}
