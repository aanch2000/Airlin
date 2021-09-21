package AirlineManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PaymentDetails extends JFrame implements ActionListener {

    JTextField txt;
    JTable tb;

     public PaymentDetails(){

        super("Payment Details");

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);

        JLabel l1, l2, l3, l4, l5, l6, l7, l8;
        JButton btn;

        l1 = new JLabel("PNR No");
        l1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.setBounds(50, 150, 100, 30);
        add(l1);

        txt = new JTextField();
        txt.setBounds(200, 150, 100, 30);
        add(txt);

        btn = new JButton("Show");
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setBounds(200, 200, 100, 30);
        add(btn);

        l2 = new JLabel("PNR_No");
        l2.setFont(new Font("serif", Font.PLAIN, 18));
        l2.setBounds(50, 250, 80, 25);
        add(l2);

        l3 = new JLabel("Paid_Amount");
        l3.setFont(new Font("serif", Font.PLAIN, 18));
        l3.setBounds(130, 250, 120, 25);
        add(l3);

        l4 = new JLabel("Pay_Date");
        l4.setFont(new Font("serif", Font.PLAIN, 18));
        l4.setBounds(250, 250, 100, 25);
        add(l4);

        l5 = new JLabel("Cheque_No");
        l5.setFont(new Font("serif", Font.PLAIN, 18));
        l5.setBounds(350, 250, 100, 25);
        add(l5);

        l6 = new JLabel("Card_No");
        l6.setFont(new Font("serif", Font.PLAIN, 18));
        l6.setBounds(450, 250, 100, 25);
        add(l6);

        l7 = new JLabel("Phone_No");
        l7.setFont(new Font("serif", Font.PLAIN, 18));
        l7.setBounds(550, 250, 100, 25);
        add(l7);

        l8 = new JLabel("PAYMENT DETAILS");
        l8.setFont(new Font("serif", Font.BOLD, 30));
        l8.setBounds(200, 50, 400, 50);
        add(l8);

        tb = new JTable();
        tb.setBounds(50, 300, 600, 250);
        add(tb);

        btn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String s = txt.getText();

        try{

            Conn c = new Conn();

            String str = "SELECT pnr_no, paid_amt, pay_date, cheque_no, card_no, ph_no FROM payment WHERE pnr_no = '"+s+"'";
            ResultSet rs = c.s.executeQuery(str);
            tb.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new PaymentDetails().setVisible(true);
    }

}
