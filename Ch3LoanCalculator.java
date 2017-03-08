/*
 * Loan Calculator Program
 */


import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class Ch3LoanCalculator {
    
    public static void main(String [] args){
        
        final int MONTHS_IN_YEAR = 12;
        
        double loanAmount,
               annualInterestRate,
               monthlyPayment,
               totalPayment,
               monthlyInterestRate;
        
        int loanPeriod,
            numberOfPayments;
        
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("This program computes the monthly and total");
        System.out.println("payments for a given loan amount, annual ");
        System.out.println("interest rate, and load period.");
        System.out.println("Loan amount in dollars and cents.");
        System.out.println("Annual interest rate in percentage.");
        System.out.println("Loan period in number of years.");
        System.out.println("\n");
        
        System.out.print("Loan Amount (Dollars+Cents): ");
        loanAmount = input.nextDouble();
        
        System.out.print("Annual Interest Rate (e.g., 9.5): ");
        annualInterestRate = input.nextDouble();
        
        System.out.print("Loan Period - # of years: ");
        loanPeriod = input.nextInt();
        
        monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / 100;
        numberOfPayments = loanPeriod * MONTHS_IN_YEAR;
        
        monthlyPayment = (loanAmount * monthlyInterestRate) /
                            (1 - Math.pow(1/(1 + monthlyInterestRate),
                                    numberOfPayments ));
        
        totalPayment = monthlyPayment * numberOfPayments;
                
        System.out.println("");
        System.out.println("Loan Amount:        $" + loanAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Loan Period (years): " + loanPeriod);
        System.out.println("\n");
        System.out.println("Monthly payment is  $" + df.format(monthlyPayment));
        System.out.println("  TOTAL payment is  $" + df.format(totalPayment));
    }

}
