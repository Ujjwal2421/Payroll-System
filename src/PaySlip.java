
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class PaySlip extends JFrame implements ActionListener {

    Choice c1;
    JTextArea t1;
    JButton b1;

    PaySlip() {

        setSize(800, 700);
        setLocation(400, 150);
        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while (rs.next()) {
                c1.add(rs.getString("id"));
            }
        } catch (SQLException e) {
        }

        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Select Id"));
        p1.add(c1);
        add(p1, "North");
        //c1.addItemListener(this);

        t1 = new JTextArea(30, 80);
        JScrollPane jsp = new JScrollPane(t1);

        Font f1 = new Font("arial", Font.BOLD, 20);
        t1.setFont(f1);

        b1 = new JButton("Generate Pay Slip");

        add(b1, "South");
        add(jsp, "Center");
        b1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        try {
            conn c = new conn();
            System.out.println("Generating pay slip.....");

            String empid = c1.getSelectedItem();

            ResultSet rs = c.s.executeQuery("select * from employee where id=" + empid);
            rs.next();
            String name = rs.getString("name");
            rs.close();
           
            String n = "Present";
            String query = "Select * from attendence where id='" + empid + "' and f_half='Present'";
            rs = c.s.executeQuery(query);
            int count = 0;
            while (rs.next()) {
                count++;
            }

            int nf_half = count;
            rs.close();

            rs = c.s.executeQuery("Select * from attendence where id='" + empid + "' and s_half='Present'");
            int count1 = 0;
            while (rs.next()) {
                count1++;
            }

            int ns_half = count1;
            rs.close();

            rs = c.s.executeQuery("select * from salary where id=" + empid);
            double gross = 0.0;
            double net = 0.0;

            java.util.Date d1 = new java.util.Date();
            int month = d1.getMonth();
            t1.setText(" ----------------   PAY SLIP FOR THE MONTH OF " + month + " ,2021 ------------------------");
            t1.append("\n");

            if (rs.next()) {

                t1.append("\n     Employee ID= " + rs.getString("id"));
                t1.append("\n     Employee Name= " + name);

                t1.append("\n----------------------------------------------------------------");
                t1.append("\n");

                double hra = rs.getDouble("hra");
                t1.append("\n                  HRA         : " + hra);
                double da = rs.getDouble("da");
                t1.append("\n                  DA          : " + da);
                double med = rs.getDouble("med");
                t1.append("\n                  MED         : " + med);
                double pf = rs.getDouble("pf");
                t1.append("\n                  PF          : " + pf);
                double basic = rs.getDouble("basic_salary");
                t1.append("\n                  Basic          : " + basic);

                double perday = basic / 30;

                double f_half = perday / 2;
                double s_half = perday / 2;

                System.out.println(f_half);
                System.out.println(s_half);

                System.out.println(nf_half);
                System.out.println(ns_half);

                gross = hra + da + med + pf + (nf_half * f_half) + (ns_half * s_half);
                net = gross - pf;

                t1.append("\n-------------------------------------------------------");
                t1.append("\n");

                t1.append("\n       GROSS SALARY :" + gross + "    \n       NET SALARY : " + net);
                t1.append("\n       Tax   :   2.1% of gross " + (gross * 2.1 / 100));
                t1.append("\n -------------------------------------------------");
                t1.append("\n");
                t1.append("\n");
                t1.append("\n");
                

            }
        } catch (SQLException ee) {
        }

    }

    public static void main(String[] args) {
        new PaySlip().setVisible(true);
    }
}
