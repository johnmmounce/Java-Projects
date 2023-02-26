public class Option {
    protected String name;
    protected long cost;

    public Option(String name, long cost) {
        this.name = name;
        this.cost = cost;

        if (cost < 0) {
            throw new IllegalArgumentException("cost cannot be less than $0.00");
        }
    }

    public long cost() {
        return cost / 100;
    }

    public String toString() {
        return name + " (" + cost + ") ";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof Option) {
            Option otherOption = (Option) o;
            return otherOption.name.equals(this.name) &&
                    otherOption.cost == this.cost;
        }
        return false;
    }
}