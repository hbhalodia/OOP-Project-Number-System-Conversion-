import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaeryDes implements ActionListener {
    JButton B1,B2;
    JFrame f1;
    JLabel l;
     public BinaeryDes(){

            f1 = new JFrame("Description Page");
            B1 = new JButton("EXIT");
            B2 = new JButton("NEXT");


            B1.setBounds(0,640,208,65);
            B1.setBackground(new Color(79, 213, 45));
            B2.setBounds(616,640,220,67);
            B2.setBackground(new Color(52, 115, 237));
            ImageIcon manu = new ImageIcon("C:\\Users\\hp\\Desktop\\BinarySystem1.png");
            l= new JLabel(manu);
             l.setBounds(0,0,850,670);

            B1.addActionListener(this);
            B2.addActionListener(this);

            f1.add(B1);
            f1.add(B2);
            f1.add(l);
         f1.setSize(850,770);

         f1.setVisible(true);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    public static void main(String[] args) {
        new BinaeryDes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==B1){
            new ThanksFrame();
            f1.dispose();

          }else if(e.getSource()==B2) {
            new ProjectFrame();
            f1.dispose();
        }
    }
}