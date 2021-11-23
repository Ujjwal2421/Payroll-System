
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Employee extends JFrame implements ActionListener {

    JLabel l0, l1, l2, l3, l4, l5, l6, l7;
    JTextField t0, t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c1;

    New_Employee() {
        super("NEW EMPLOYEE DETAILS");
        setSize(600, 650);
        setLocation(600, 200);
        getContentPane().setBackground(Color.BLACK);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLACK);
        p1.setLayout(new GridLayout(10, 9, 16, 50));

        l0 = new JLabel("EMPLOYEE ID");
        l0.setForeground(Color.WHITE);

        t0 = new JTextField(15);
        t0.setBackground(Color.BLACK);
        t0.setForeground(Color.WHITE);
        p1.add(l0);
        p1.add(t0);

        l1 = new JLabel("Name");
        l1.setForeground(Color.WHITE);

        t1 = new JTextField(15);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);

        p1.add(l1);
        p1.add(t1);

        c1 = new Choice();
        c1.add("MALE");
        c1.add("FEMALE");
        c1.add("OTHERS");
        c1.setBackground(Color.BLACK);
        c1.setForeground(Color.WHITE);

        l2 = new JLabel("Gender");
        l2.setForeground(Color.WHITE);

        p1.add(l2);
        p1.add(c1);
        l3 = new JLabel("Address");
        l3.setForeground(Color.WHITE);

        t3 = new JTextField(15);
        t3.setBackground(Color.BLACK);
        t3.setForeground(Color.WHITE);
        p1.add(l3);
        p1.add(t3);
        l4 = new JLabel("State");
        l4.setForeground(Color.WHITE);

        t4 = new JTextField(15);
        t4.setBackground(Color.BLACK);
        t4.setForeground(Color.WHITE);

        p1.add(l4);
        p1.add(t4);
        l5 = new JLabel("City");
        l5.setForeground(Color.WHITE);

        t5 = new JTextField(15);
        t5.setBackground(Color.BLACK);
        t5.setForeground(Color.WHITE);
        p1.add(l5);
        p1.add(t5);

        l6 = new JLabel("Email");
        l6.setForeground(Color.WHITE);
        t6 = new JTextField(15);
        t6.setBackground(Color.BLACK);
        t6.setForeground(Color.WHITE);

        p1.add(l6);
        p1.add(t6);

        l7 = new JLabel("Phone");
        l7.setForeground(Color.WHITE);

        t7 = new JTextField(15);
        t7.setBackground(Color.BLACK);
        t7.setForeground(Color.WHITE);
        p1.add(l7);
        p1.add(t7);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))), "West");
        add(p1, "Center");

        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String j = t0.getText();
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();

        String qry = "insert into employee values('" + j + "','" + n + "','" + g + "','" + a + "','" + s + "','" + c + "','" + e + "','" + p + "')";
        try {
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Employee Created");
            this.setVisible(false);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String s[]) {
        new New_Employee().setVisible(true);
    }
}
