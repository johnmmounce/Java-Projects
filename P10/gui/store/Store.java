package gui.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Store {
    // ///////////////////////////////////////////////////////////
    // Fields

    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public void save(BufferedWriter bw)throws IOException{
        bw.write( name + "\n");
        bw.write( "" + customers.size() + "\n");
        for(Customer customer : customers){
            customer.save(bw);
        }
        bw.write( "" + options.size() + "\n");
        for(Option option : options){
            option.save(bw);
        }
        bw.write( "" + computers.size() + "\n");
        for(Computer computer : computers){
            computer.save(bw);
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
        if (!customers.contains(customer))
            customers.add(customer);
    }

    public Object[] customers() {
        return this.customers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Options

    public void add(Option option) {
        if (!options.contains(option))
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
}