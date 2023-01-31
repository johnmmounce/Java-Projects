public enum Type{Rat(2), Hamster(3), Ferret(10), Rabbit(9);
    private final double lifespan;

    private Type(double lifespan){
       this.lifespan = lifespan;
    }

    public double lifespan(){
        //humanAge = humanLifespan * age / type.lifespan()
        return this.lifespan;
    }
}
 