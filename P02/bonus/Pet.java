public class Pet {
    private String name;
    private double age;
    private Type type;
    public static final double humanLifespan = 80 ;

    Pet(String name, double age, Type type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public double humanAge(){
       return humanLifespan * age / type.lifespan();
    }

    @Override
    public String toString() {
        return name + " is a " + type + " age " + age + " or " + humanAge() + " in human-equivalent years.";
    }
}