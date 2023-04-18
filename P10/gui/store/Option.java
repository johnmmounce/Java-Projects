package gui.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Option {
    protected String name;
    protected long cost;

    public void save(BufferedWriter bw) throws IOException{
        bw.write( name + "\n");
        bw.write( "" + Long.toString(cost) + "\n");
 
     }
 
     public Option(BufferedReader br) throws IOException{
         this.name = br.readLine();
         this.cost = Long.parseLong(br.readLine());
     }

    public Option(String name, long cost) {
        this.name = name;
        this.cost = cost;

        if (cost < 0) {
            throw new IllegalArgumentException("cost cannot be less than $0.00");
        }
    }

    public long cost() {
        return this.cost;
    }

    public String toString() {
        long cents = cost % 100;
        return name + " (" + cost/100 + "." + ((cents < 10) ? "0" : "") + cents + ")";
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