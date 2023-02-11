abstract class Product{
    protected double cost;
    protected String name;

    public Product( String name, double cost){
        this.name = name;
        this.cost = cost;
        if(cost < 0){
            throw new IllegalArgumentException("price cannot be negative");
        }
    }

    public abstract double Price();

    @Override
    public String toString(){
        String formattedcost = String.format("%.2f", cost);
        String formattedPrice = String.format("%.2f", Price());
        String s1 = name + " " + "($" + formattedcost + ")\t\t$ " + formattedPrice;
       // String s2 = ")$ " + formattedPrice;
        String s3 = String.format("%15s", s1);
        return s3;
        }
}