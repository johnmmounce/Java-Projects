package gui.store;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order {
    private static long nextOrderNumber = 0;
    private long orderNumber;

    private Customer customer;
    private ArrayList<Computer> computers;

    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
        computers = new ArrayList<Computer>();

    }

    public Order(BufferedReader br) throws IOException {
        this.orderNumber = Long.parseLong(br.readLine());
        if(nextOrderNumber <= orderNumber) nextOrderNumber = orderNumber + 1;
        this.customer = new Customer(br);
        int numOptions = Integer.parseInt(br.readLine());
        while(numOptions-- > 0)
            computers.add(new Computer(br));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(Long.toString(orderNumber) + '\n');
        this.customer.save(bw);
        bw.write("" + computers.size() + '\n');
        for(Computer computer : computers)
            computer.save(bw);
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }
    
    public long cost(){
        long sum = 0;
        for(Computer c : computers){
            sum += c.Cost();
        }
        return sum;
    }
@Override
public String toString() {
    StringBuilder sb = new StringBuilder("Order " + orderNumber + " for " + customer + " price of $" + cost() + ";");
    for(Computer c : computers){
        sb.append("\n\n" + c);
    }
    return sb.toString();
}

@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof Order) {
            Order otherOrder = (Order) o;
            if (!this.customer.equals(otherOrder.customer)) {
                return false;
            }
            if (this.computers.size() != (otherOrder.computers.size())) {
                return false;
            }
            for (int i = 0; i < this.computers.size(); i++) {
                if (!this.computers.get(i).equals(otherOrder.computers.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}