package Assignment_10;

import java.util.Scanner;

abstract class Employee implements InterfaceOfEmployee{
    public abstract void calculateCommissionRate();
    public abstract void calculateCommission();
}

interface InterfaceOfEmployee{
    public void calculateGrossPay();
    public abstract void totalPay();

}

class payOfEmployee extends Employee implements InterfaceOfEmployee{
    public double sales;
    private double commission;
    protected double grossPay;
    protected double commissionRate;
    double advance;

    public payOfEmployee(double sales, double advance) {
        this.sales = sales;
        this.advance = advance;
    }

    public double getSales() {
        return sales;
    }

    public double getCommission() {
        return commission;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getAdvance() {
        return advance;
    }

    @Override
    public void calculateGrossPay() {
        grossPay = commission - advance;
    }

    @Override
    public void calculateCommission() {
        commission = commissionRate * sales / 100;
    }

    @Override
    public void totalPay() {
        System.out.println("Commission : $"+getCommission());
        if(getGrossPay() > 0)
        {
            System.out.println("Gross Pay : $"+grossPay);
        }
        else if(getGrossPay()<0)
        {
            System.out.println("You are owning $"+(grossPay*-1)+" to the company.");
        }
        else{
            System.out.println("You have $0 pay check.");
        }
    }

    @Override
    public void calculateCommissionRate() {
        if(sales>=0 &&sales < 10000)
        {
            commissionRate = 5.0;
        }
        else if(sales>=10000 && sales<15000)
        {
            commissionRate = 10.0;
        }
        else if(sales>=15000 && sales < 18000)
        {
            commissionRate = 12.0;
        }
        else if(sales>=18000 && sales < 22000)
        {
            commissionRate = 15.0;
        }
        else if(sales >=22000 )
        {
            commissionRate = 16.0;
        }
        else
        {
            System.out.println("Sales cannot be negative!\nExiting...........");
            System.exit(1);
        }
    }
}

public class ImplementingConcepts {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the monthly sales : ");
        double sales = read.nextDouble();
        System.out.print("Enter the amount of advanced pay : ");
        double advance = read.nextDouble();
        payOfEmployee payOfEmployee = new payOfEmployee(sales,advance);
        payOfEmployee.calculateCommissionRate();
        payOfEmployee.calculateCommission();
        payOfEmployee.calculateGrossPay();
        payOfEmployee.totalPay();
    }
}
