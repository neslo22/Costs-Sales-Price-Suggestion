package sample;

public class Predictions {

    public Predictions(){

    }

    public double predictCost(double price, double income){
        return income * (price / 100);
    }
    public double predictPrice(double cost, double income){
        System.out.print((cost / income) * 100 + "\n");
        return (cost / income) * 100;
    }
    public double predictIncome(double cost, double price){
        return cost * (price / 100);
    }
}
