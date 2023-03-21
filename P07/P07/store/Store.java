package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    public Store(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }

    public Store(BufferedReader br) throws IOException {

        int num_Cust = Integer.parseInt(br.readLine());
        customers = new ArrayList<>();
        for (int i = 0; i < num_Cust; i++) {
            customers.add(new Customer(br));
        }


        int num_Op = Integer.parseInt(br.readLine());
        options = new ArrayList<>();
        for (int i = 0; i < num_Op; i++) {
            options.add(new Option(br));
        }


        // Load inventory
        int num_Comp = Integer.parseInt(br.readLine());
        computers = new ArrayList<>();
        for (int i = 0; i < num_Comp; i++) {
            computers.add(new Computer(br));
        }

        // Load orders
        int num_Ord = Integer.parseInt(br.readLine());
        orders = new ArrayList<>();
        for (int i = 0; i < num_Ord; i++) {
            orders.add(new Order(br));
        }
    }


    public void save(BufferedWriter bw) throws IOException {

        bw.write(customers.size() + "\n");
        for (Customer customer : customers) {
            customer.save(bw);
        }


        bw.write(options.size() + "\n");
        for (Option option : options) {
            option.save(bw);
        }


        bw.write(computers.size() + "\n");
        for (Computer computer : computers) {
            computer.save(bw);
        }

        bw.write(orders.size() + "\n");
        for (Order order : orders) {
            order.save(bw);
        }
    }
    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Orders
    
    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Fields
    
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    
    
    
}
