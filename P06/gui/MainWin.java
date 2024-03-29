import store.Store;
import store.TestStore;
import store.Computer;
import store.Option;
import store.Customer;
import store.Order;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame; // for main window
import javax.swing.JOptionPane; // for standard dialogs
import javax.swing.JPanel;
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar; // row of menu selections
import javax.swing.JMenu; // menu selection that offers another menu
import javax.swing.JMenuItem; // menu selection that does something
import javax.swing.JToolBar; // row of buttons under the menu
import javax.swing.JButton; // regular button
import javax.swing.JComboBox;
import javax.swing.JToggleButton; // 2-state button
import javax.swing.BorderFactory; // manufacturers Border objects around buttons
import javax.swing.Box; // to create toolbar spacer
import javax.swing.BoxLayout;
import javax.swing.UIManager; // to access default icons
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JLabel; // text or image holder
import javax.swing.ImageIcon; // holds a custom icon
import javax.swing.SwingConstants; // useful values for Swing method calls
import javax.swing.JList; // useful values for Swing method calls

import javax.imageio.ImageIO; // loads an image from a file

import java.io.File; // opens a file
import java.io.IOException; // reports an error reading from a file

import java.awt.BorderLayout; // layout manager for main window
import java.awt.FlowLayout; // layout manager for About dialog

import java.awt.Color; // the color of widgets, text, or borders
import java.awt.Font; // rich text in a JLabel or similar widget
import java.awt.Image;
import java.awt.image.BufferedImage; // holds an image loaded from a file
import java.awt.Dimension;

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 400));

        this.store = new Store("Elsa's Store");

        addMenu();

        addToolbar();

        // S T A T U S B A R D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        JLabel msg = new JLabel();
        this.add(msg, BorderLayout.PAGE_END);

        // Make everything in the JFrame visible
        this.pack();
        // this.setSize(200,200);
        this.setVisible(true);
    }

    private void addMenu() {
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu insert = new JMenu("Insert");
        JMenuItem customer = new JMenuItem("Customer");
        JMenuItem option = new JMenuItem("Option");
        JMenuItem computer = new JMenuItem("Computer");

        JMenu view = new JMenu("View");
        JMenuItem customers = new JMenuItem("Customers");
        JMenuItem options = new JMenuItem("Options");
        JMenuItem computers = new JMenuItem("Computers");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        // anew .addActionListener(event -> onNewGameClick());
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
    }

    private void addToolbar() {
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("ELSA Controls");
        // A "horizontal strut" is just a space of the specified pixel width
        // toolbar.add(Box.createHorizontalStrut(25));

        final int tbButtonWidth = 60;
        final int tbButtonWHeight = 60;

        // button inserts/view
        button1 = new JButton(resizeImage("addCustomer.png", tbButtonWidth, tbButtonWHeight));
        button1.setActionCommand("Add customer");
        button1.setToolTipText("Add customer");
        toolbar.add(button1);
        button1.addActionListener(event -> onInsertCustomerClick());

        // button2 = new JButton(new ImageIcon("addOption.png"));
        button2 = new JButton(resizeImage("addOption.png", tbButtonWidth, tbButtonWHeight));
        button2.setActionCommand("Add option");
        button2.setToolTipText("Add option");
        toolbar.add(button2);
        button2.addActionListener(event -> onInsertOptionClick());

        button3 = new JButton(resizeImage("addComputer.png", tbButtonWidth, tbButtonWHeight));
        button3.setActionCommand("Add computer");
        button3.setToolTipText("Add computer");
        toolbar.add(button3);
        button3.addActionListener(event -> onInsertComputerClick());

        //seperator between button sets
        toolbar.add(Box.createHorizontalStrut(25));

        button4 = new JButton(resizeImage("viewCustomers.png", tbButtonWidth, tbButtonWHeight));
        button4.setActionCommand("View customers");
        button4.setToolTipText("View customers");
        toolbar.add(button4);
        button4.addActionListener(event -> onViewClick(Record.CUSTOMER));

        button5 = new JButton(resizeImage("viewOptions.png", tbButtonWidth, tbButtonWHeight));
        button5.setActionCommand("View options");
        button5.setToolTipText("View options");
        toolbar.add(button5);
        button5.addActionListener(event -> onViewClick(Record.OPTION));

        button6 = new JButton(resizeImage("viewComputers.png", tbButtonWidth, tbButtonWHeight));
        button6.setActionCommand("View computers");
        button6.setToolTipText("View computers");
        toolbar.add(button6);
        button6.addActionListener(event -> onViewClick(Record.COMPUTER));


        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
    }

    private ImageIcon resizeImage(String path, int newWidth, int newHeight) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    // // Listeners
    protected void onAboutClick() { // Display About dialog
       
        JLabel title = new JLabel("<htm>"
        +"<p><font size=+4>ELSA</p>"
        +"</html>",
        SwingConstants.CENTER);

        JLabel subTitle = new JLabel("<htm>"
         +"<p>Exceptional Laptops and Supercomputers Always</p>"
         +"</html>",
         SwingConstants.CENTER);

        JLabel version = new JLabel("<html>"
          + "<p>Version 0.1</p>"
          + "</html>",
          SwingConstants.CENTER);

        JLabel credits = new JLabel("<html>"
        +"<br/><p> Add customer icon based on work by ifans28 per the Flaticon License</p>"
        +"<p><font size =-2>https://www.flaticon.com/free-icon/add-friend_6469169?term=add+customer&page=1&position=4&origin=search&related_id=6469169</font><p>"
        
        +"<br/><p> Add option icon based on work by Dave Gandy per the Flaticon License</p>"
        +"<p><font size =-2>https://www.flaticon.com/free-icon/add-square-button_25300?term=add+option&page=1&position=31&origin=search&related_id=25300</font><p>"
        
        +"<br/><p> Add computer icon based on work by Gregor Cresnar per the Flaticon License</p>"
        +"<p><font size =-2>https://www.flaticon.com/free-icon/computer_159356?term=add+computer&page=1&position=13&origin=search&related_id=159356</font><p>"

        +"<br/><p> View customers icon based on work by Freepik per the Flaticon License</p>"
        +"<p><font size =-2>https://www.flaticon.com/free-icon/customer_3126649?term=customers&page=1&position=5&origin=search&related_id=3126649</font><p>"

        
        +"<br/><p> View options icon based on work by bqlqn per the Flaticon License</p>"
        +"<p><font size =-2>https://www.flaticon.com/free-icon/menu_2948037?term=options&page=1&position=31&origin=search&related_id=2948037</font><p>"

         
        +"<br/><p> View computers icon based on work by Freepik per the Flaticon License</p>"
        +"<p><font size =-2>https://www.flaticon.com/free-icon/multiple-computers-connected_70930?term=multiple+computers&page=1&position=5&origin=search&related_id=70930</font><p>"
        
        +"<html>");

        JOptionPane.showMessageDialog(this, new Object[]{title, subTitle, version, credits}, "ELSA", JOptionPane.PLAIN_MESSAGE);
    }

    protected void onQuitClick() {
        System.exit(0);
    }

    protected void onInsertCustomerClick() {
        String name = JOptionPane.showInputDialog(null, "Customer name", "New Customer", JOptionPane.PLAIN_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Customer email", "New Customer", JOptionPane.PLAIN_MESSAGE);
        try {
            Customer customer = new Customer(name, email);
            store.add(customer);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "invalid email", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onInsertOptionClick() {
        String name = JOptionPane.showInputDialog(null, "Option Name", "New Option", JOptionPane.PLAIN_MESSAGE);
        String cost = JOptionPane.showInputDialog(null, "Option Cost", "New Option", JOptionPane.PLAIN_MESSAGE);
        double Dcost = Double.parseDouble(cost);
        Dcost = Dcost * 100.0;
        long Lcost = (long) Dcost;
        Option option = new Option(name, Lcost);
        store.add(option);
    }

    protected void onInsertComputerClick() {
        try { 
            Computer c = new Computer(
                JOptionPane.showInputDialog(this, "Computer name", 
                    "New Computer", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Computer model", 
                    "New Computer", JOptionPane.QUESTION_MESSAGE)
            );
            JComboBox<Object> cb = new JComboBox<>(store.options());
            int optionsAdded = 0; // Don't add computers with no options
            while(true) {
                int button = JOptionPane.showConfirmDialog(this, cb, 
                    "Another Option?", JOptionPane.YES_NO_OPTION);
                if(button != JOptionPane.YES_OPTION) break;
                c.addOption((Option) cb.getSelectedItem());
                ++optionsAdded;
            }
            if(optionsAdded > 0) {
                store.add(c);
                onViewClick(Record.COMPUTER);
            }
        } catch(NullPointerException e) {
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e, 
                "Computer Not Created", JOptionPane.ERROR_MESSAGE);
        }    
   
        // String name = JOptionPane.showInputDialog(null, "Computer name", "New Computer", JOptionPane.PLAIN_MESSAGE);
        // String model = JOptionPane.showInputDialog(null, "Model", "New Computer", JOptionPane.PLAIN_MESSAGE);
        // Object[] computerOptions = store.computers();
        // JComboBox<Object> computerOptionsBox = new JComboBox<>(computerOptions);

        // JFrame optionsFrame = new JFrame();
        // optionsFrame.add(computerOptionsBox);
        // optionsFrame.setTitle("select computer option");
        // optionsFrame.setSize(400, 400);
        // optionsFrame.setLocationRelativeTo(null);
        // optionsFrame.setVisible(true);
        // int selection = JOptionPane.showConfirmDialog(null, computerOptionsBox, "Select an option",
        //         JOptionPane.OK_CANCEL_OPTION);

        // if (selection == JOptionPane.OK_OPTION && computerOptionsBox.getSelectedItem() != null) {
        //     Object selectedOption = computerOptionsBox.getSelectedItem();
        //     Computer computer = new Computer(name, model);
        //     store.add(computer);
        // }

    }

    protected void onViewClick(Record record) {
        Object[] viewArray = null;

        if (this.optionsContent != null)
            this.remove(this.optionsContent);
        if (this.computerContent != null)
            this.remove(this.computerContent);
        if (this.customerContent != null)
            this.remove(this.customerContent);

        if (record.equals(Record.CUSTOMER)) {
            this.customerContent = new JPanel();
            customerContent.setLayout(new BoxLayout(customerContent, BoxLayout.Y_AXIS));

            JLabel customers = new JLabel("Customers");
            customers.setFont(new Font("SansSerif", Font.BOLD, 18));

            this.customerContent.add(customers, BorderLayout.PAGE_START);
            viewArray = store.customers();
            for (int i = 0; i < viewArray.length; i++) {

                customerContent.add(new JLabel(i + 1 + ". " + viewArray[i].toString()));
            }

            this.add(this.customerContent, BorderLayout.CENTER);
            this.setVisible(true);
        } else if (record.equals(Record.OPTION)) {
            this.optionsContent = new JPanel();
            optionsContent.setLayout(new BoxLayout(optionsContent, BoxLayout.Y_AXIS));

            JLabel options = new JLabel("Options");
            options.setFont(new Font("SansSerif", Font.BOLD, 18));

            this.optionsContent.add(options, BorderLayout.PAGE_START);
            viewArray = store.options();
            for (int i = 0; i < viewArray.length; i++) {

                optionsContent.add(new JLabel(i + 1 + ". " + viewArray[i].toString()));
            }

            this.add(this.optionsContent, BorderLayout.CENTER);
            this.setVisible(true);
        } else if (record.equals(Record.COMPUTER)) {
            this.computerContent = new JPanel();
            computerContent.setLayout(new BoxLayout(computerContent, BoxLayout.Y_AXIS));

            JLabel computers = new JLabel("Computers for sale - cheap!");
            computers.setFont(new Font("SansSerif", Font.BOLD, 18));

            this.computerContent.add(computers, BorderLayout.PAGE_START);
            viewArray = store.computers();
            for (int i = 0; i < viewArray.length; i++) {

                computerContent.add(new JLabel(i + 1 + ". " + viewArray[i].toString()));

            }

            this.add(this.computerContent, BorderLayout.CENTER);
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "invalid record type");
        }
    }

    private Store store;

    private JLabel msg; // Status message display

    private JButton button1; // Button to select 1 stick
    private JButton button2; // Button to select 2 sticks
    private JButton button3; // Button to select 3 sticks
    private JButton button4; // Button to select 3 sticks
    private JButton button5; // Button to select 3 sticks
    private JButton button6; // Button to select 3 sticks

    private JPanel computerContent;
    private JPanel optionsContent;
    private JPanel customerContent;

}
