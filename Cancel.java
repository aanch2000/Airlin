package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Cancel extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5;

    public Cancel(){
        super("Cancellation");

        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 200, 450, 550);

        JLabel l1, l2, l3, l4, l5, l6;
        JButton btn;

        l6 = new JLabel("CANCELLATION");
        l6.setForeground(new Color(100, 149, 237));
        l6.setFont(new Font("serif", Font.BOLD, 30));
        l6.setBounds(100, 40, 250, 50);
        add(l6);

        l1 = new JLabel("Passenger No");
        l1.setFont(new Font("serif", Font.PLAIN, 18));
        l1.setBounds(60, 150, 150, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(260, 150, 100, 30);
        add(t1);

        l2 = new JLabel("Cancellation No");
        l2.setFont(new Font("serif", Font.PLAIN, 18));
        l2.setBounds(60, 200, 150, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(260, 200, 100, 30);
        add(t2);

        l3 = new JLabel("Cancellation Date");
        l3.setFont(new Font("serif", Font.PLAIN, 18));
        l3.setBounds(60, 250, 150, 30);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(260, 250, 100, 30);
        add(t3);

        l4 = new JLabel("Ticket ID");
        l4.setFont(new Font("serif", Font.PLAIN, 18));
        l4.setBounds(60, 300, 150, 30);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(260, 300, 100, 30);
        add(t4);

        l5 = new JLabel("Flight Code");
        l5.setFont(new Font("serif", Font.PLAIN, 18));
        l5.setBounds(60, 350, 150, 30);
        add(l5);

        t5 = new JTextField();
        t5.setBounds(260, 350, 100, 30);
        add(t5);

        btn = new JButton("Save");
        btn.setFont(new Font("serif", Font.PLAIN, 18));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setBounds(260, 420, 70, 30);
        add(btn);

        btn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        String pasNo, canNo, canDa, ticID, fltCd;

        pasNo = t1.getText();
        canNo = t2.getText();
        canDa = t3.getText();
        ticID = t4.getText();
        fltCd = t5.getText();

        try{
            Conn c = new Conn();
            String str = "INSERT INTO cancellation VALUES ('"+pasNo+"','"+canNo+"','"+canDa+"','"+ticID+"','"+fltCd+"')";

            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Ticket Cancelled");
            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Cancel().setVisible(true);
    }
}
