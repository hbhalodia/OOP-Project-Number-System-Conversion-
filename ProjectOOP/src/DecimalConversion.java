import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalConversion implements ActionListener {

    JFrame j1;
    JLabel l1, l2, l3, l4,l5;
    JButton b1, b2, b3;
    JTextField t1, t2, t3, t4 ,t5;

    DecimalConversion() {
        j1 = new JFrame("Binary conversion");
        l1 = new JLabel("Input Decimal Number");
        l2 = new JLabel("Binary Number ");
        l3 = new JLabel("Octal Number ");
        l4 = new JLabel("Hexadec Number");
        l5 = new JLabel("ERROR In %");
        b1 = new JButton("Back");
        b2 = new JButton("Convert");
        b3 = new JButton("Cancel");
        t1 = new JTextField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        t4 = new JTextField("");
        t5 = new JTextField("");


        j1.setSize(650, 500);
        Font font1 = new Font(" ",Font.BOLD,15);
        Font font2 = new Font(" ",Font.BOLD,20);

        t1.setBounds(200, 50, 200, 30);
        t2.setBounds(200, 125, 200, 30);
        t3.setBounds(200, 200, 200, 30);
        t4.setBounds(200, 275, 200, 30);
        t5.setBounds(500,165,30,30);
        b1.setBounds(50, 400, 100, 50);
        b2.setBounds(200, 400, 100, 50);
        b3.setBounds(350, 400, 100, 50);

        l1.setBounds(50, 50, 100, 30);
        l2.setBounds(50, 125, 100, 30);
        l3.setBounds(50, 200, 100, 30);
        l4.setBounds(50, 275, 100, 30);
        l5.setBounds(485,125,100,50);

        j1.getContentPane().setBackground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b3.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        t1.setBackground(Color.BLACK);
        t3.setBackground(Color.BLACK);
        t4.setBackground(Color.BLACK);
        t2.setBackground(Color.BLACK);
        t5.setBackground(Color.BLACK);
        t1.setForeground(Color.white);
        t2.setForeground(Color.ORANGE);
        t3.setForeground(Color.ORANGE);
        t4.setForeground(Color.orange);
        t5.setForeground(Color.WHITE);
        l1.setFont(font1);
        l2.setFont(font1);
        l3.setFont(font1);
        l4.setFont(font1);
        l5.setFont(font1);
        t1.setFont(font2);
        t2.setFont(font2);
        t3.setFont(font2);
        t4.setFont(font2);
        t5.setFont(font2);
        j1.setResizable(false);

        j1.setLayout(null);

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j1.add(t1);
        j1.add(t2);
        j1.add(t3);
        j1.add(t4);
        j1.add(t5);
        j1.add(l1);
        j1.add(l2);
        j1.add(l3);
        j1.add(l4);
        j1.add(l5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        j1.setVisible(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    double Dec;
    double DecimalFraction,fractionPart,fractionPart2,fractionPart3, ErrorAllow,InErroal;
    int ErrorTake,ll;
    long DecimalPart;
    long []fpartMul = new long [10];
    long []fpartMul2 = new long [6];
    long []fpartMul3 = new long[6];
    String Frpart = "" ,Frpart2="",Frpart3="";
    String Binary,Octal,Hex1,Hex;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new ProjectFrame();
            j1.dispose();
        } else if(e.getSource()==b2){
            try {

                Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
                String Deccc = t1.getText();

                Matcher matcher = pattern.matcher(Deccc);
                if (matcher.matches()) {
                    String Binarrryy  = Integer.toBinaryString(Integer.parseInt(Deccc));
                    String Octal1 = Integer.toOctalString(Integer.parseInt(String.valueOf(Deccc)));
                    String Hex11 = Integer.toHexString(Integer.parseInt(String.valueOf(Deccc)));
                    String Heex = Hex11.toUpperCase();
                    t2.setText(Binarrryy);
                    t3.setText(Octal1);
                    t4.setText(Heex);
                } else {

                    Dec = Double.parseDouble(Deccc);
                    // t2.setText(Integer.toBinaryString(Dec));
                    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    DecimalFraction = Dec;

                    ErrorTake = Integer.parseInt(t5.getText());
                    DecimalPart = (long) DecimalFraction;
                    Binary = Integer.toBinaryString(Integer.parseInt(String.valueOf(DecimalPart)));
                    fractionPart = Math.round((DecimalFraction - DecimalPart) * 100000.0) / 100000.0;
                    ErrorAllow = (ErrorTake * fractionPart) / 100;
                    InErroal = 1 / ErrorAllow;
                    ll = (int) (Math.log(InErroal) / Math.log(2.0));
                    for (int i = 0; i < ll; i++) {
                        fractionPart = fractionPart * 2;
                        fpartMul[i] = (long) fractionPart;
                        Frpart = Frpart.concat(String.valueOf(fpartMul[i]));
                        fractionPart = Math.round((fractionPart) * 100000.0) / 100000.0;
                        fractionPart = fractionPart - fpartMul[i];
                    }
                    Octal = Integer.toOctalString(Integer.parseInt(String.valueOf(DecimalPart)));
                    fractionPart2 = Math.round((DecimalFraction - DecimalPart) * 10000.0) / 10000.0;

                    for (int i = 0; i < 6; i++) {
                        fractionPart2 = fractionPart2 * 8;
                        fpartMul2[i] = (long) fractionPart2;
                        Frpart2 = Frpart2.concat(String.valueOf(fpartMul2[i]));
                        fractionPart2 = Math.round((fractionPart2) * 10000.0) / 10000.0;
                        fractionPart2 = fractionPart2 - fpartMul2[i];
                    }

                    Hex1 = Integer.toHexString(Integer.parseInt(String.valueOf(DecimalPart)));
                    fractionPart3 = Math.round((DecimalFraction - DecimalPart) * 10000.0) / 10000.0;
                    Hex = Hex1.toUpperCase();

                    for (int i = 0; i < 6; i++) {
                        fractionPart3 = fractionPart3 * 16;
                        fpartMul3[i] = (long) fractionPart3;
                        if (fpartMul3[i] == 10) {
                            Frpart3 = Frpart3.concat("A");
                        } else if (fpartMul3[i] == 11) {
                            Frpart3 = Frpart3.concat("B");
                        } else if (fpartMul3[i] == 12) {
                            Frpart3 = Frpart3.concat("C");
                        } else if (fpartMul3[i] == 13) {
                            Frpart3 = Frpart3.concat("D");
                        }
                        if (fpartMul3[i] == 14) {
                            Frpart3 = Frpart3.concat("E");
                        } else if (fpartMul3[i] == 15) {
                            Frpart3 = Frpart3.concat("F");
                        } else if (fpartMul3[i] >= 0 && fpartMul3[i] < 10) {
                            Frpart3 = Frpart3.concat(String.valueOf(fpartMul3[i]));
                        }
                        fractionPart3 = Math.round((fractionPart3) * 10000.0) / 10000.0;
                        fractionPart3 = fractionPart3 - fpartMul3[i];
                    }


                    t2.setText(Binary + "." + Frpart);
                    t3.setText(Octal + "." + Frpart2);
                    t4.setText(Hex + "." + Frpart3);
                }
            }catch(NumberFormatException Ni){
                t1.setText("");
                JOptionPane.showMessageDialog(j1,"Incorrect (Enter Only Number)", "Error",JOptionPane.ERROR_MESSAGE);

            }
        }else if (e.getSource() == b3) {
            new ThanksFrame();
            j1.dispose();
        }

    }

    public static void main(String[] args) {
        new DecimalConversion();
    }
}