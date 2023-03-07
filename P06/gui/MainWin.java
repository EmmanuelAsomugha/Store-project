package gui;
import store.*;

import javax.swing.*;
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)

import javax.imageio.ImageIO;        // loads an image from a file

import java.awt.*;
import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file

import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout
        
        
        JMenuBar menubar = new JMenuBar();
        JMenu     file       = new JMenu("File");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenu     insert       = new JMenu("Insert");
        JMenuItem customer       = new JMenuItem("Customer");
        JMenuItem option       = new JMenuItem("Option");
        JMenuItem computer       = new JMenuItem("Computer");
        JMenu     view       = new JMenu("View");
        JMenuItem customers       = new JMenuItem("Customers");
        JMenuItem options      = new JMenuItem("Options");
        JMenuItem computers       = new JMenuItem("Computers");
        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");
        
        
        quit.addActionListener(event -> onQuitClick());
        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        options.addActionListener(event -> onViewClick(Record.OPTION));
        computers.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());
        
        
        file.add(quit);
        insert.add(customer);
        insert.add(option);
        insert.add(computer);
        view.add(customers);
        view.add(options);
        view.add(computers);
        help.add(about);
        
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        setJMenuBar(menubar);
        
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu

        JToolBar toolbar = new JToolBar("ELSA");

        // Add a New Game stock icon
        JButton Cust  = new JButton(new ImageIcon("gui/resources/add_customer.png"));
        Cust.setActionCommand("Insert Customer");
        Cust.setToolTipText("Insert Customers");
        Cust.setBorder(null);
        toolbar.add(Cust);
        Cust.addActionListener(event -> onInsertCustomerClick());

        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));


        Opt  = new JButton(new ImageIcon("gui/resources/add_option.png"));
        Opt.setActionCommand("Insert Option");
        Opt.setToolTipText("Insert Option");
        toolbar.add(Opt);
        Opt.addActionListener(event -> onInsertOptionClick());

        Comp    = new JButton(new ImageIcon("gui/resources/add_computer.png"));
        Comp.setActionCommand("Insert Computer");
        Comp.setToolTipText("Insert Computer");
        toolbar.add(Comp);
        Comp.addActionListener(event -> onInsertComputerClick());

        v_Cust = new JButton(new ImageIcon("gui/resources/view_customers.png"));
        v_Cust.setActionCommand("View Customer");
        v_Cust.setToolTipText("View Customer");
        toolbar.add(v_Cust);
        v_Cust.addActionListener(event -> onViewClick(Record.CUSTOMER));

        toolbar.add(Box.createHorizontalStrut(25));


        v_Opt = new JButton(new ImageIcon("gui/resources/view_options.png"));
        v_Opt.setActionCommand("View Option");
        v_Opt.setToolTipText("View Option");
        v_Opt.setBorder(null);
        toolbar.add(v_Opt);
        v_Opt.addActionListener(event -> onViewClick(Record.OPTION));

        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());


        JButton v_Comp  = new JButton(new ImageIcon("gui/resources/view_computers.png"));
        v_Comp.setActionCommand("View Computer");
        v_Comp.setToolTipText("View Computer");
        v_Comp.setBorder(null);
        toolbar.add(v_Comp);
        v_Comp.addActionListener(event -> onViewClick(Record.COMPUTER));
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);


        // /////////////////////////// ////////////////////////////////////////////
        // C O M P U T E R S   D I S P L A Y
        // Provide a text entry box to show the remaining sticks
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        

        setVisible(true);
        
        // Start a new game
        //onNewStoreClick();
    }
    
    // Listeners
    

    
    protected void onInsertCustomerClick()
    {
        JFrame f_name = new JFrame();
        String name = JOptionPane.showInputDialog(f_name, "Enter name:");
        JFrame f_email = new JFrame();
        String s_email = JOptionPane.showInputDialog(f_email, "Enter email:");

        try
        {
            int verf1=0;
            int verf2=0;
            String []parts;
            for(int i=0;i<s_email.length();i++)
            {
                if(s_email.charAt(i) == '@')
                {
                    parts = s_email.split("@");
                    verf1++;
                    String part2=parts[1];
                    for(int j=0;j<part2.length();j++)
                    {
                        if(part2.charAt(j) == '.')
                        {
                            verf2++;
                        }
                    }
                }



            }
            if(verf1 != 1 || verf2 != 1)
            {
                JOptionPane.showMessageDialog(null, "Invalid email.", "Error", JOptionPane.ERROR_MESSAGE);
                onInsertCustomerClick();
            }

            if(name == null || s_email == null)
            {
                System.exit(0);
            }

            else
            {
                Customer customer = new Customer(name, s_email);
                store.add(customer);
                System.out.println("created");
            }
        }catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, "Invalid email.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    protected void onInsertOptionClick()
    {
        JFrame f_name = new JFrame();
        String name = JOptionPane.showInputDialog(f_name, "Enter name:");
        JFrame f_cost = new JFrame();
        String s_cost = JOptionPane.showInputDialog(f_cost, "Enter cost:");

        long l_cost = 0;
        double d_cost = Double.parseDouble(s_cost);
        l_cost = (long) (d_cost * 100);
        Option option = new Option(name, l_cost);

        JFrame f_cost_confirmation = new JFrame();
        int cost_confirmation = JOptionPane.showConfirmDialog(f_cost_confirmation, "Verify\nName: " + name + "\nCost: " + ((double)l_cost)/100);
        if (cost_confirmation == JOptionPane.OK_OPTION)
        {
            store.add(option);
        }
        else
        {
            onInsertOptionClick();
        }

    }
    
    protected void onInsertComputerClick() {
        JFrame f_name = new JFrame();
        String name = JOptionPane.showInputDialog(f_name, "Enter name:");
        JFrame f_model = new JFrame();
        String s_model = JOptionPane.showInputDialog(f_model, "Enter model:");

        Object[] options = store.options();
        JComboBox<Object> optionComboBox = new JComboBox<>(options);

        for (Object o : options) {
            Option oo = (Option) o;
            optionComboBox.addItem(oo);
        }


        Object[] message = {
                "Select options for the computer:",
                optionComboBox
        };
        JFrame option_confirmation = new JFrame();
        int optionResult = JOptionPane.showConfirmDialog(option_confirmation, message, "Options", JOptionPane.OK_CANCEL_OPTION);
        if (optionResult == JOptionPane.OK_OPTION) {
            Computer computer = new Computer(name, s_model);
            Option option = (Option) optionComboBox.getSelectedItem();
            computer.addOption(option);
            store.add(computer);
        }
    }
    
    protected void onViewClick(Record record)
    {
        Object[] objects = null;
        String header = "";

        switch (record) {
            case CUSTOMER:
                header = "<html><p><font size=+2>Customers</font></p></html>";
                objects = store.customers();
                break;
            case OPTION:
                header = "<html><p><font size=+2>Options</font></p></html>";
                objects = store.options();
                break;
            case COMPUTER:
                header = "<html><p><font size=+2>Computers</font></p></html>";
                objects = store.computers();
                break;
            default:
                return;
        }

        StringBuilder sb = new StringBuilder(header);
        sb.append("<ol>");
        for (Object object : objects) {
            sb.append("<li>").append(object.toString()).append("</li>");
        }
        sb.append("</ol>");
        display.setText(sb.toString());

    }
    
    protected void onAboutClick() {                 // Display About dialog

        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>ELSA</font></p>"
          + "<p><font size=+4>Exceptional Laptops and Supercomputers Always</font></p>"
          + "<p>Version 0.2</p>"
          + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2017-2023 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"
          + "<p><font size=-2>Add Customer icon based on work by Dreamstate per the Flaticon License</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/user_3114957</font></p>"
          + "<p><font size=-2>View Customers icon based on work by Ilham Fitrotul Hayat per the Flaticon License</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/group_694642</font></p>"
          + "<p><font size=-2>Add Option icon based on work by Freepik per the Flaticon License</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/quantum-computing_4103999</font></p>"
          + "<p><font size=-2>View Options icon based on work by Freepik per the Flaticon License</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/network_9094450</font></p>"
          + "<p><font size=-2>Add Computer icon based on work by Freepik per the Flaticon License</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/laptop_689396</font></p>"
          + "<p><font size=-2>View Computers icon based on work by Futuer per the Flaticon License</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/computer-networks_9672993</font></p>"
          + "</html>");
          
         JOptionPane.showMessageDialog(this, 
             new Object[]{ title, artists},
             "ELSA",
             JOptionPane.PLAIN_MESSAGE
         );
     }




    protected void onQuitClick() {System.exit(0);}   // Exit the game


    
    private Store store = new Store("ELSA");
    
    private JLabel display;                  // Display of sticks on game board
    private JLabel msg;                     // Status message display
    private JButton Opt;                // Button to select 1 stick
    private JButton Comp;                // Button to select 2 sticks
    private JButton v_Cust;                // Button to select 3 sticks
    private JButton v_Opt;   // Button to enable robot

}