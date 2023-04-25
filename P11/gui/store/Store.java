package gui.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Objects;

import java.util.Collection;


public class Store {
    // ///////////////////////////////////////////////////////////
    // Fields

    private String name;
    private TreeSet<Customer> customers = new TreeSet<>();
    private HashSet<Option> options = new HashSet<>();
    private HashSet<Computer> computers = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        
        saveAll(customers, bw);
        saveAll(options, bw);
        saveAll(computers, bw);
        saveAll(orders, bw);

    }

    private <T extends Saveable> void saveAll(Collection<T> collection, BufferedWriter bw) throws IOException{
        bw.write("" + collection.size() + "\n");
        for(var object : collection){
            object.save(bw);
        }
    }

    public Store(BufferedReader br)throws IOException{
        this.name = br.readLine();
        int customersSize = Integer.parseInt(br.readLine());
        while(customersSize-- > 0){
            customers.add(new Customer(br));
         }
        int optionsSize = Integer.parseInt(br.readLine());
        while(optionsSize-- > 0){
            options.add(new Option(br));
         }
        int computersSize = Integer.parseInt(br.readLine());
        while(computersSize-- > 0){
            computers.add(new Computer(br));
         }
    }

    public Store(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    // ///////////////////////////////////////////////////////////
    // Customers

    public void add(Customer customer) {
            customers.add(customer);
    }

    public Object[] customers() {
        return customers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Options

    public void add(Option option) {
        options.add(option);
    }

    public Object[] options() {
        return this.options.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Computers

    public void add(Computer computer) {
        if (!computers.contains(computer))
            computers.add(computer);
    }

    public Object[] computers() {
        return this.computers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Orders

    public void add(Order order) {
        if (!orders.contains(order))
            orders.add(order);
    }

    public Object[] orders() {
        return this.orders.toArray();
    }


    public interface Saveable{
        void save(BufferedWriter bw) throws IOException;
    }
}