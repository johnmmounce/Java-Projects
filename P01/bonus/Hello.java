import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name;
        System.out.print("What is your name?\n");
        name = in.nextLine();
        System.out.println("Hello, " + name);
    }
}