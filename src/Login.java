
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Login() {
        super("LOGIN PAGE");
        setLayout(new BorderLayout());
        t2 = new JPasswordField(10);
        t1 = new JTextField(10);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/pic.png")));

        b1 = new JButton("SUBMIT");
        b2 = new JButton("CANCEL");
        b1.addActionListener(this);
        b2.addActionListener(this);
        JPanel p1, p2, p3, p4;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        ImageIcon c1 = new ImageIcon("submit.jpg");
        JLabel m1 = new JLabel(c1);

        add(l, BorderLayout.WEST);

        p2.add(new JLabel("User Name"));
        p2.add(t1);
        p2.add(new JLabel("Password"));
        p2.add(t2);
        add(p2, BorderLayout.CENTER);
        p4.add(b1);
        p4.add(b2);
        add(p4, BorderLayout.SOUTH);
        setVisible(true);
        setSize(400, 250);
        setLocation(600, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            conn c1 = new conn();
            String u = t1.getText();
            String P = t2.getText();

            String q = "select*from login where username = '" + u + "' and password= '" + P + "' ";

            ResultSet rs = c1.s.executeQuery(q);
            if (rs.next()) {
                new project().setVisible(true); //to show frame setvisisble
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Inavalid user or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
