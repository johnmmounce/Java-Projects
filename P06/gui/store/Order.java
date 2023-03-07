package store;

import java.util.ArrayList;

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

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("order ");
        string.append(orderNumber);
        string.append(" for ");
        string.append(customer.name);
        string.append(" (");
        string.append(customer.email);
        string.append(")\n\n");
        for (Computer i : computers) {
            string.append("   ");
            string.append("(");
            string.append(i.toString());
            string.append("\n");
        }
        return string.toString();
    }

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