package AirlineManagementSystem;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FlightInfo extends JFrame implements ActionListener {
    private JTextField txt;
    private JTable table;

    public FlightInfo(){
        super("Flight Information");

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("serif", Font.PLAIN, 13));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(860, 610);
        setLocation(350, 150);
        setLayout(null);
        setVisible(true);

        JButton btn;
        JLabel l1, l2,l3, l4, l5, l6, l7, l8, l9;

        l1 = new JLabel("FLIGHT INFORMATION");
        l1.setFont(new Font("serif", Font.PLAIN, 30));
        l1.setForeground(new Color(100, 149, 237));
        l1.setBounds(280, 20, 570, 35);
        add(l1);

        l2 = new JLabel("Flight Code");
        l2.setFont(new Font("serif", Font.PLAIN, 18));
        l2.setBounds(50, 100, 200, 30);
        add(l2);

        btn = new JButton("Show");
        btn.setFont(new Font("serif", Font.PLAIN, 18));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setBounds(220, 150, 80, 25);
        add(btn);

        txt = new JTextField();
        txt.setBounds(220, 100, 100, 25);
        add(txt);

        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(23, 250, 800, 300);

        JScrollPane pane = new JScrollPane(table);
        pane.setBackground(Color.WHITE);
        pane.setBounds(23, 250, 800, 300);
        add(pane);

        l3 = new JLabel("Flight Code");
        l3.setFont(new Font("serif", Font.PLAIN, 15));
        l3.setBounds(40,220, 115, 14);
        add(l3);

        l4 = new JLabel("Flight Name");
        l4.setFont(new Font("serif", Font.PLAIN, 15));
        l4.setBounds(160,220, 115, 14);
        add(l4);

        l5 = new JLabel("Source");
        l5.setFont(new Font("serif", Font.PLAIN, 15));
        l5.setBounds(280,220, 100, 14);
        add(l5);

        l6 = new JLabel("Destination");
        l6.setFont(new Font("serif", Font.PLAIN, 15));
        l6.setBounds(385,220, 100, 14);
        add(l6);

        l7 = new JLabel("Capacity");
        l7.setFont(new Font("serif", Font.PLAIN, 15));
        l7.setBounds(495,220, 100, 14);
        add(l7);

        l8 = new JLabel("Class Code");
        l8.setFont(new Font("serif", Font.PLAIN, 15));
        l8.setBounds(610,220, 115, 14);
        add(l8);

        l9 = new JLabel("Class Name");
        l9.setFont(new Font("serif", Font.PLAIN, 15));
        l9.setBounds(720,220, 115, 14);
        add(l9);

        btn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        String code = txt.getText();
        try{
            Conn c = new Conn();
            String str = "select f_code, f_name, src, dst, capacity, class_code, class_name from flight, sector where f_code = '"+code+"' ";

            ResultSet rs = c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FlightInfo().setVisible(true);
    }
}
