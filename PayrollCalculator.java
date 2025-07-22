public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double regularPay = hoursWorked*hourlyRate;
        double weaklyPay;
        switch (employeeType){
            case "FULL_TIME":
                if (hoursWorked > regularPay){
                    weaklyPay = regularPay + (hoursWorked-regularPay)*1.5;
                }
                else{
                    weaklyPay =regularPay; }

            case "PART_TIME":
                if(hoursWorked>25){
                    System.out.println("max houres for part time is 25 ");
                }
                else{weaklyPay=regularPay;}
            case "CONTRACTOR":
                weaklyPay = regularPay;
            case "INTERN":
                if (hoursWorked<=25){
                weaklyPay = hoursWorked*(0.2*hourlyRate);}
            default:
                System.out.println("invalid employee types");
        }
        return 0;
    }
    public static double calculateTaxDeduction(double grossPay, boolean
            hasHealthInsurance) {
        double tax;
        if(hasHealthInsurance = true){
            if(grossPay<=500 ){
                tax = grossPay*0.1-50;

            } else if (grossPay<=1000) {
                tax = grossPay*0.15-50;
            }else if (grossPay<=2000) {
                tax = grossPay*0.20-50;
            }else {
                tax = grossPay*0.25-50;
            }
        }else{
            if(grossPay<=500 ){
                tax = grossPay*0.1;

            } else if (grossPay<=1000) {
                tax = grossPay*0.15;
            }else if (grossPay<=2000) {
                tax = grossPay*0.20;
            }else {
                tax = grossPay*0.25;
            }
        }
        return tax;
    }

}
