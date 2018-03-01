package sample;

public class Predictions {

    public double predictCost(double price, double income){
        return (income * 100) / price;
    }
    public double predictPrice(double cost, double income){
        //System.out.print((cost / income) * 100 + "\n");
        return (income * 100) / cost;
    }
    public double predictIncome(double cost, double price){
        return cost * (price / 100);
    }
}
