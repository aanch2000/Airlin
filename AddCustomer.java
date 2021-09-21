package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton r1, r2;
    public AddCustomer(){
        super("Add Customer Details");
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 600);
        setLocation(400, 100);
        setLayout(null);
        setVisible(true);

        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
        JButton btn;

        l1 = new JLabel("Flight Code");
        l1.setFont(new Font("serif", Font.PLAIN, 17));
        l1.setBounds(60, 90, 150, 27);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 90, 150, 27);
        add(t1);

        l2 = new JLabel("Passport No");
        l2.setFont(new Font("serif", Font.PLAIN, 17));
        l2.setBounds(60, 130, 150, 27);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(200, 130, 150, 27);
        add(t2);

        l3 = new JLabel("PNR No");
        l3.setFont(new Font("serif", Font.PLAIN, 17));
        l3.setBounds(60, 170, 150, 27);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(200, 170, 150, 27);
        add(t3);

        l4 = new JLabel("Address");
        l4.setFont(new Font("serif", Font.PLAIN, 17));
        l4.setBounds(60, 210, 150, 27);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(200, 210, 150, 27);
        add(t4);

        l5 = new JLabel("Nationality");
        l5.setFont(new Font("serif", Font.PLAIN, 17));
        l5.setBounds(60, 250, 150, 27);
        add(l5);

        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 27);
        add(t5);

        l6 = new JLabel("Name");
        l6.setFont(new Font("serif", Font.PLAIN, 17));
        l6.setBounds(60, 290, 150, 27);
        add(l6);

        t6 = new JTextField();
        t6.setBounds(200, 290, 150, 27);
        add(t6);

        l7 = new JLabel("Gender");
        l7.setFont(new Font("serif", Font.PLAIN, 17));
        l7.setBounds(60, 330, 150, 27);
        add(l7);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(200, 330, 100, 27);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(300, 330, 100, 27);
        add(r2);

        l8 = new JLabel("Phone No");
        l8.setFont(new Font("serif", Font.PLAIN, 17));
        l8.setBounds(60, 380, 150, 27);
        add(l8);

        t7 = new JTextField();
        t7.setBounds(200, 380, 150, 27);
        add(t7);

        l9 = new JLabel("Add Customer Details");
        l9.setFont(new Font("serif", Font.BOLD, 30));
        l9.setBounds(100, 30, 300, 30);
        add(l9);

        btn = new JButton("Save");
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setBounds(200, 440, 150, 30);
        add(btn);

        btn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {

        String flCode, passNo, pnrNo, add, nat, nam, gen, ph;
        flCode = t1.getText();
        passNo = t2.getText();
        pnrNo = t3.getText();
        add = t4.getText();
        nat = t5.getText();
        nam = t6.getText();
        gen = null;
        ph = t7.getText();

        if(r1.isSelected()){
            gen = "male";
        }
        else if (r2.isSelected()){
            gen = "female";
        }

        try{
            Conn c = new Conn();
            String str = "INSERT INTO passenger VALUES ('"+pnrNo+"','"+add+"','"+nat+"','"+nam+"','"+gen+"','"+ph+"','"+passNo+"','"+flCode+"')";

            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Customer Added");
            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}
