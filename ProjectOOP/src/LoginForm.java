import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JFrame frame;
    JTextField tf1;
    JButton btn1;
    JPasswordField p1;
    LoginForm() {
         frame = new JFrame("Login Form");
        l1 = new JLabel("Login Form");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Username");
        l3 = new JLabel("Password");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Login");

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(150, 70, 200, 30);
        p1.setBounds(150, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);
        frame.getContentPane().setBackground(Color.GREEN);

        frame.add(l1);
        frame.add(l2);
        frame.add(tf1);
        frame.add(l3);
        frame.add(p1);
        btn1.addActionListener(this);
        frame.add(btn1);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String uname = tf1.getText();
        String pass = p1.getText();
        if(uname.equals("Java") && pass.equals("abc@123"))
        {
            new BinaeryDes();
            frame.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Incorrect login or password",
                    "Error",JOptionPane.ERROR_MESSAGE);
            tf1.setText("");
            p1.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}