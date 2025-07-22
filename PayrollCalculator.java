public class PayrollCalculator {

    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double weeklyPay =0; ;
        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked > 40) {
                    weeklyPay = weeklyPay = (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                } else {
                    weeklyPay = hoursWorked * hourlyRate;
                }
                break;
            case "PART_TIME":
                if (hoursWorked > 25) {
                    System.out.println("Max hours for part time is 25");
                    weeklyPay = 25 * hourlyRate;
                } else {
                    weeklyPay = hoursWorked * hourlyRate;
                }
                break;

            case "CONTRACTOR":
                weeklyPay = hoursWorked * hourlyRate;
                break;

            case "INTERN":
                if (hoursWorked > 20) {
                    System.out.println("Max hours for intern is 20");
                    weeklyPay = 20 * (0.2*hourlyRate);
                }
                weeklyPay = hoursWorked*(0.2*hourlyRate); // 20% discount
                break;
            default:
                System.out.println("Invalid employee type");
                break;
        }
        return weeklyPay;
    }
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax;

        if (hasHealthInsurance) {
            if (grossPay <= 500) {
                tax = grossPay * 0.10 -50;
            } else if (grossPay <= 1000) {
                tax = grossPay * 0.15-50;
            } else if (grossPay <= 2000) {
                tax = grossPay * 0.20-50;
            } else {
                tax = grossPay * 0.25 -50;
            }
        }else{
            if (grossPay <= 500) {
                tax = grossPay * 0.10;
            } else if (grossPay <= 1000) {
                tax = grossPay * 0.15;
            } else if (grossPay <= 2000) {
                tax = grossPay * 0.20;
            } else {
                tax = grossPay * 0.25;
            }
            tax -= 50;
        }
        return tax;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        double totalPay = 0;
        double maxPay = 0;
        double minPay = Double.MAX_VALUE;
        String highestPaid = "";
        String lowestPaid = "";
        int overtimeCount = 0;

        System.out.format("%1s%10s%10s%10s%10s%n", "Name", "Type", "Hours", "Rate", "Pay");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < names.length; i++) {
            double pay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            System.out.printf("%-10s %-12s %-6.1f %-6.2f %-10.2f%n", names[i], employeeTypes[i], hours[i], rates[i], pay);
            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                highestPaid = names[i];
            }
            if (pay < minPay) {
                minPay = pay;
                lowestPaid = names[i];
            }
            if (employeeTypes[i].equals("FULL_TIME") && hours[i] > 40) {
                overtimeCount++;
            }
        }
        double averagePay = totalPay / names.length;
        System.out.println("Highest Paid : " + highestPaid + " - " + maxPay );
        System.out.println("Lowest Paid  : " + lowestPaid + " - " + minPay );
        System.out.println("Average Pay  : " + averagePay);
        System.out.println("Overtime Count: " + overtimeCount);
    }

    public static void main(String[] args) {
        // Test data
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN",
                "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        boolean[] hasInsurance = {true, true, false, false, true};


        System.out.println("Test individual calculations");
        for (int i = 0; i < names.length; i++) {
            double grossPay = calculateWeeklyPay(types[i], hours[i], rates[i]);
            boolean hasHealthInsurance = hasInsurance[i];
            double tax = calculateTaxDeduction(grossPay, hasHealthInsurance);
            double netPay = grossPay - tax;
            System.out.printf("%-10s %-12s %-6.1f %-6.2f %-10.2f%n", names[i], types[i], hours[i], rates[i], grossPay);

        }

        System.out.println("\n--- Processing Entire Payroll ---");
        processPayroll(types, hours, rates, names);
    }
}
