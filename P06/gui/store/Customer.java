package store;

public class Customer {
    String name;
    String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;

        int atIndex = email.indexOf("@");
        if (atIndex != -1 && email.indexOf(".", atIndex) != -1) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("invalid email (email must have '.' after '@')");
        }
    }
    @Override
    public String toString() {
        return name + " (" + email + ") ";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Customer) {
            Customer otherCustomer = (Customer) o;
            return otherCustomer.name.equals(this.name) &&
                    otherCustomer.email.equals(this.email);
        }
        return false;
    }
}