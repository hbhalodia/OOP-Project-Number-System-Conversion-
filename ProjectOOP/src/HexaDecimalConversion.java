import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexaDecimalConversion implements ActionListener {
    JFrame j1;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4;

    HexaDecimalConversion(){
        j1 = new JFrame("Binary conversion");
        l1 = new JLabel("Input HexDec Number");
        l2 = new JLabel("Decimal Number ");
        l3 = new JLabel("Binary Number ");
        l4 = new JLabel("Octal Number");
        b1 = new JButton("Back");
        b2 = new JButton("Convert");
        b3 = new JButton("Cancel");
        t1 = new JTextField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        t4 = new JTextField("");


        j1.setSize(500,500);
        Font font1 = new Font(" ",Font.BOLD,15);
        Font font2 = new Font(" ",Font.BOLD,20);

        t1.setBounds(200,50,200,30);
        t2.setBounds(200,125,200,30);
        t3.setBounds(200,200,200,30);
        t4.setBounds(200,275,200,30);
        b1.setBounds(50,400,100,50);
        b2.setBounds(200,400,100,50);
        b3.setBounds(350,400,100,50);

        l1.setBounds(50,50,100,30);
        l2.setBounds(50,125,100,30);
        l3.setBounds(50,200,100,30);
        l4.setBounds(50,275,100,30);

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
        t1.setForeground(Color.WHITE);
        t2.setForeground(Color.ORANGE);
        t3.setForeground(Color.ORANGE);
        t4.setForeground(Color.orange);
        l1.setFont(font1);
        l2.setFont(font1);
        l3.setFont(font1);
        l4.setFont(font1);
        t1.setFont(font2);
        t2.setFont(font2);
        t3.setFont(font2);
        t4.setFont(font2);


        j1.setResizable(false);
        j1.setLayout(null);

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j1.add(t1);
        j1.add(t2);
        j1.add(t3);
        j1.add(t4);
        j1.add(l1);
        j1.add(l2);
        j1.add(l3);
        j1.add(l4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);


        j1.setVisible(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    String HexNumber2,HexNumbbb="",Frpart="",Frpart2="";
    String SubHex;
    int p=-1;
    char hexxx;
    int decihex;
    double FDeci3=0,fractionPart,fractionPart2;
    int len,flag = 0;;
    long DecimalPart;
    long []fpartMul = new long[6];
    long []fpartMul2 = new long[6];
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new ProjectFrame();
            j1.dispose();
        }else if(e.getSource()==b2){
            try {

                Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
                HexNumber2 = t1.getText();
                Matcher matcher = pattern.matcher(HexNumber2);

                if (matcher.matches()) {
                    int decimal1 = Integer.parseInt(HexNumber2, 16);
                    String Octal1 = Integer.toOctalString(Integer.parseInt(String.valueOf(decimal1)));
                    String Binary1 = Integer.toBinaryString(Integer.parseInt(String.valueOf(decimal1)));
                    t2.setText(String.valueOf(decimal1));
                    t3.setText(Binary1);
                    t4.setText(Octal1);
                } else {

                    int n = HexNumber2.indexOf('.');
                    char hex;
                    for (int i = 0; i < n; i++) {
                        hex = HexNumber2.charAt(i);
                        HexNumbbb = HexNumbbb.concat(String.valueOf(hex));
                    }
                    double decimal = Integer.parseInt(HexNumbbb, 16);

                    SubHex = HexNumber2.substring(n + 1);
                    len = SubHex.length();
                    for (int i = 0; i < len; i++) {
                        hexxx = SubHex.charAt(i);
                        if (hexxx == 48 || hexxx == 49 || hexxx == 50 || hexxx == 51 || hexxx == 52 || hexxx == 53 || hexxx == 54 || hexxx == 55 || hexxx == 56 || hexxx == 57
                                || hexxx == 65 || hexxx == 66 || hexxx == 67 || hexxx == 68 || hexxx == 69 || hexxx == 70) {
                            decihex = (int) hexxx - 48;
                            FDeci3 = FDeci3 + decihex * Math.pow(16, p);
                            p--;
                            flag = 0;
                        } else {
                            flag = 1;
                            FDeci3 = 0;
                            decimal = 0;
                            break;
                        }
                    }
                    if (flag == 1) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        JOptionPane.showMessageDialog(j1, "Incorrect (Enter 0 to 9 OR A-F)", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double roundOff = Math.round((decimal + FDeci3) * 1000.0) / 1000.0;
                        t2.setText(String.valueOf(roundOff));


                        DecimalPart = (long) roundOff;
                        String Binary = Integer.toBinaryString(Integer.parseInt(String.valueOf(DecimalPart)));
                        fractionPart = Math.round((roundOff - DecimalPart) * 10000.0) / 10000.0;

                        for (int i = 0; i < 6; i++) {
                            fractionPart = fractionPart * 2;
                            fpartMul[i] = (long) fractionPart;
                            Frpart = Frpart.concat(String.valueOf(fpartMul[i]));
                            fractionPart = Math.round((fractionPart) * 10000.0) / 10000.0;
                            fractionPart = fractionPart - fpartMul[i];
                        }
                        t3.setText(Binary + "." + Frpart);


                        String Octal = Integer.toOctalString(Integer.parseInt(String.valueOf(DecimalPart)));
                        fractionPart2 = Math.round((roundOff - DecimalPart) * 10000.0) / 10000.0;

                        for (int i = 0; i < 6; i++) {
                            fractionPart2 = fractionPart2 * 8;
                            fpartMul2[i] = (long) fractionPart2;
                            Frpart2 = Frpart2.concat(String.valueOf(fpartMul2[i]));
                            fractionPart2 = Math.round((fractionPart2) * 10000.0) / 10000.0;
                            fractionPart2 = fractionPart2 - fpartMul2[i];
                        }

                        t4.setText(Octal + "." + Frpart2);
                    }
                }
            }catch(NumberFormatException Ni){
                t1.setText("");
                JOptionPane.showMessageDialog(j1,"Incorrect (Enter 0 to 9 OR A-F)", "Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if(e.getSource()==b3){
            new ThanksFrame();
            j1.dispose();
        }

    }

    public static void main(String[] args) {
        new HexaDecimalConversion();
    }
}