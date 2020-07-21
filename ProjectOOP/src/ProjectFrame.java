import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectFrame implements ActionListener {
    JFrame J1 ;
    JButton b1,b2,b3,b4,b5;
    JLabel l1;

    ProjectFrame(){
        J1 = new JFrame("NUMBER CONVERSION(MAIN FRAME)");
        b2 = new JButton("BINARY NUMBER ");
        b3 = new JButton("OCTAL NUMBER");
        b4 = new JButton("HEXA DECIMAL NUMBER ");
        b1 = new JButton("DECIMAL NUMBER");
        b5 = new JButton("CANCEL");
        l1 = new JLabel("CLICK ON ANY BUTTON BELOW");


        J1.setSize(525,650);
        b1.setBounds(100,100,300,50);
        b2.setBounds(100,200,300,50);
        b3.setBounds(100,300,300,50);
        b4.setBounds(100,400,300,50);
        b5.setBounds(200,500,100,50);
        l1.setSize(200,50);

        l1.setLocation(150,25);
        J1.setLayout(null);
        l1.setFont(new Font("",Font.BOLD,15));

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b3.setBackground(Color.BLACK);
        b4.setBackground(Color.BLACK);
        b5.setBackground(Color.BLACK);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        J1.getContentPane().setBackground(Color.GREEN);

        l1.setForeground(Color.BLACK);

        J1.add(b1);
        J1.add(b2);
        J1.add(b3);
        J1.add(b4);
        J1.add(b5);
        J1.add(l1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);


        J1.setResizable(false);
        J1.setVisible(true);

        J1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ProjectFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new DecimalConversion();
            J1.dispose();
        }else if(e.getSource()==b2){
            new BinaryConversion();
            J1.dispose();
        }else if(e.getSource()==b3){
            new OctalConversion();
            J1.dispose();
        }else if(e.getSource()==b4){
            new HexaDecimalConversion();
            J1.dispose();
        }else if(e.getSource()==b5){
            new ThanksFrame();
            J1.dispose();
        }
    }
}