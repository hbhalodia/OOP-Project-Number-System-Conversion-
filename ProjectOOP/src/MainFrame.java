import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    JButton B1,B2;
    JFrame f1;
    JLabel l;
    public MainFrame(){
        f1 = new JFrame("WELCOME TO HIT BHALODIA PROJECT");
        B1 = new JButton("ENTER");
        B2 = new JButton("EXIT");
        B1.setBounds(0,540,208,65);
        B1.setBackground(new Color(90,155,213));
        B2.setBounds(616,541,220,67);
        B2.setBackground(new Color(237,125,49));
        ImageIcon manu = new ImageIcon("F:\\JAVA PDF\\PngFilePage\\ProjectFrontPage.png");
        l= new JLabel(manu);

        B1.addActionListener(this);
        B2.addActionListener(this);

        f1.add(B1);
        f1.add(B2);
        f1.add(l);
        f1.setSize(850,670);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MainFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == B1){
            f1.dispose();
            new LoginForm();

        }
        if(e.getSource() == B2){
            f1.dispose();
            new ThanksFrame();
        }
    }
}
