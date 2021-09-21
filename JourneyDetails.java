package AirlineManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JourneyDetails extends JFrame implements ActionListener {

    JComboBox cb1, cb2;
    JTable table;

    public JourneyDetails(){

        super("Journey Details");

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);

        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
        JButton btn;

        l1 = new JLabel("Source");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setBounds(50, 150, 100, 30);
        add(l1);

        String[] items1 = {"Bangalore", "Mumbai", "Chennai", "Lucknow", "Hyderabad", "Delhi"};
        cb1 = new JComboBox(items1);
        cb1.setBounds(200, 150, 100, 30);
        add(cb1);

        l2 = new JLabel("Destination");
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        l2.setBounds(350, 150, 100, 30);
        add(l2);

        String[] items2 = {"Bangalore", "Mumbai", "Chennai", "Lucknow", "Hyderabad", "Delhi"};
        cb2 = new JComboBox(items2);
        cb2.setBounds(500, 150, 100, 30);
        add(cb2);

        l3 = new JLabel("PNR No");
        l3.setFont(new Font("serif", Font.PLAIN, 18));
        l3.setBounds(50, 350, 100, 25);
        add(l3);

        l4 = new JLabel("Ticket ID");
        l4.setFont(new Font("serif", Font.PLAIN, 18));
        l4.setBounds(150, 350, 100, 25);
        add(l4);

        l5 = new JLabel("F_Code");
        l5.setFont(new Font("serif", Font.PLAIN, 18));
        l5.setBounds(250, 350, 100, 25);
        add(l5);

        l6 = new JLabel("JNY_Date");
        l6.setFont(new Font("serif", Font.PLAIN, 18));
        l6.setBounds(350, 350, 100, 25);
        add(l6);

        l7 = new JLabel("JNY_Time");
        l7.setFont(new Font("serif", Font.PLAIN, 18));
        l7.setBounds(450, 350, 100, 25);
        add(l7);

        l8 = new JLabel("Source");
        l8.setFont(new Font("serif", Font.PLAIN, 18));
        l8.setBounds(550, 350, 100, 25);
        add(l8);

        l9 = new JLabel("Destination");
        l9.setFont(new Font("serif", Font.PLAIN, 18));
        l9.setBounds(650, 350, 100, 25);
        add(l9);

        l10 = new JLabel("JOURNEY DETAILS");
        l10.setFont(new Font("serif", Font.BOLD, 30));
        l10.setBounds(250, 50, 500, 50);
        add(l10);

        table = new JTable();
        table.setBounds(50, 370, 700, 180);
        add(table);

        btn = new JButton("Show");
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        btn.setFont(new Font("serif", Font.PLAIN, 20));
        btn.setBounds(650, 150, 100, 30);
        add(btn);

        btn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        String src, dst;

        src = (String) cb1.getSelectedItem();
        dst = (String) cb2.getSelectedItem();

        try{
            Conn c = new Conn();

            String str = "SELECT pnr_no, ticket_id, f_code, jny_date, jny_time, src, dst FROM reservation WHERE src = '"+src+"' and dst = '"+dst+"'";
            ResultSet rs = c.s.executeQuery(str);

            if(rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else{
                JOptionPane.showMessageDialog(null, "No Flights between Source and Destination");
            }

        }catch (Exception e){}
    }

    public static void main(String[] args) {
        new JourneyDetails().setVisible(true);
    }
}
