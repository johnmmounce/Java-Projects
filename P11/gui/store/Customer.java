package gui.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.Objects;
import gui.store.Store.Saveable;

public class Customer implements Saveable, Comparable<Customer> {
    String name;
    String email;

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(email + "\n");
    }

    public Customer(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.email = br.readLine();
    }

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

    @Override
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

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public int compareTo(Customer c) {
        int compareName = this.name.compareTo(c.name);
        if (compareName != 0) {
            return compareName;
        }
        return this.email.compareTo(c.email);
    }
}