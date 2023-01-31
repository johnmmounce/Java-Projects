public class MyPets {

    public static void main(String[] args) {

        Pet[] allPets = {
                new Pet("Rafael", 2, Type.Rat),
                new Pet("Hammy", 4, Type.Hamster),
                new Pet("Fabio", 1, Type.Ferret),
                new Pet("Franky", 7, Type.Rabbit),
        };
        for (Pet i : allPets) {
            System.out.println(i.toString());
        }
    }
}