public class Taxed extends Product {
    private static double salesTaxRate = 0.0;

    public Taxed(String name, double cost){
        super(name, cost);
    }

    public static double setTaxRate(double Tax){
       return salesTaxRate = Tax;
    }

    @Override 
    public double Price(){
        return cost * (1 + Taxed.salesTaxRate);
    }
}
