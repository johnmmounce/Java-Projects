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
        String prod = String.format("%s ($%.2f)", name, cost);
        String price = String.format("$%.2f", Price());
        return String.format("%-24s %10s", prod, price);
        }
}