package store;

import java.util.ArrayList;

public class Computer {
    private String name;
    private String model;
    private ArrayList<Option> options;

    public Computer(String name, String model) {
        this.name = name;
        this.model = model;
        options = new ArrayList<Option>();
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public long Cost() {
        long sum = 0;
        for (Option i : options) {
            sum += i.cost();
        }
        return sum;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(name);
        string.append(" (");
        string.append(")\n");
        for (Option i : options) {
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

        if (o instanceof Computer) {
            Computer otherComputer = (Computer) o;
            return otherComputer.name.equals(this.name) &&
                    otherComputer.model.equals(this.model);
        }
        return false;
    }

}