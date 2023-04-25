package gui.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;

import java.util.Objects;
import java.util.HashSet;
import gui.store.Store.Saveable;

public class Computer implements Saveable {
    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(model + "\n");
        bw.write("" + options.size() + "\n");
        for (Option option : options) {
            option.save(bw);
        }
    }

    public Computer(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.model = br.readLine();
        int size = Integer.parseInt(br.readLine());
        while (size-- > 0) {
            options.add(new Option(br));
        }
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n\t" + name + " (" + model + ")");
        for (Option o : options)
            sb.append("\n  " + o);
        return sb.toString();
    }

    @Override
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

    @Override
    public int hashCode() {
        return Objects.hash(name, model);
    }
}