import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryConversion implements ActionListener {
    JFrame j1;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4;

    BinaryConversion(){
        j1 = new JFrame("Binary conversion");
        l1 = new JLabel("Input Bin Number");
        l2 = new JLabel("Decimal Number ");
        l3 = new JLabel("Octal Number ");
        l4 = new JLabel("Hexadec Number");
        b1 = new JButton("Back");
        b2 = new JButton("Convert");
        b3 = new JButton("Cancel");
        t1 = new JTextField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        t4 = new JTextField("");


        j1.setSize(500,500);

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
        Font font1 = new Font(" ",Font.BOLD,20);
        Font font2 = new Font(" ",Font.BOLD,15);

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
        l1.setFont(font2);
        l2.setFont(font2);
        l3.setFont(font2);
        l4.setFont(font2);
        t1.setFont(font1);
        t2.setFont(font1);
        t3.setFont(font1);
        t4.setFont(font1);


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
        j1.setResizable(false);

        j1.setVisible(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    String Bin,Oct,Frpart2="",Frpart3 = "",Octal,Hex,Hex1;
    long[] fpartMul3 = new long[6];
    long []fpartMul2 = new long[6];
    int decimal,len ,p=-1,deciBin,flag=0;
    double fractionPart2,BinaryNumber, roundOff,Fdeci=0;
    char bin;
    long DecimalPart2;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new ProjectFrame();
            j1.dispose();
        }else if(e.getSource()==b2) {
            try{
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            Bin = t1.getText();
            Matcher matcher = pattern.matcher(Bin);
                if (matcher.matches()) {
                    int decimal1 = Integer.parseInt(Bin, 2);
                    String Octal1 = Integer.toOctalString(Integer.parseInt(String.valueOf(decimal1)));
                    String Hex11 = Integer.toHexString(Integer.parseInt(String.valueOf(decimal1)));
                    String Heex = Hex11.toUpperCase();
                    t2.setText(String.valueOf(decimal1));
                    t3.setText(Octal1);
                    t4.setText(Heex);
                } else {
                    BinaryNumber = Double.parseDouble(Bin);
                    long binNum = (long) BinaryNumber;

                    String AcBinNum = String.valueOf(binNum);
                    double decim = Integer.parseInt(AcBinNum, 2);
                    double Fbinn = BinaryNumber - binNum;

                    double Fbin = Math.round((Fbinn) * 1000.0) / 1000.0;
                    String FFbin = String.valueOf(Fbin);
                    int n = FFbin.indexOf('.');
                    String SubBin = FFbin.substring(n + 1);
                    len = SubBin.length();


                    for (int i = 0; i < len; i++) {
                        bin = SubBin.charAt(i);

                        if (bin == 48 || bin == 49) {
                            deciBin = (int) bin - 48;
                            Fdeci = Fdeci + deciBin * Math.pow(2, p);
                            p--;
                            flag = 0;
                        } else {
                            flag = 1;
                            Fdeci = 0;
                            decim = 0;
                            break;
                        }

                    }
                    if (flag == 1) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        JOptionPane.showMessageDialog(j1, "Incorrect (Enter 0 or 1)", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        roundOff = Math.round((decim + Fdeci) * 1000.0) / 1000.0;
                        t2.setText(String.valueOf(roundOff));

                        DecimalPart2 = (long) roundOff;
                        Octal = Integer.toOctalString(Integer.parseInt(String.valueOf(DecimalPart2)));
                        fractionPart2 = Math.round((roundOff - DecimalPart2) * 10000.0) / 10000.0;
                        for (int i = 0; i < 6; i++) {
                            fractionPart2 = fractionPart2 * 8;
                            fpartMul2[i] = (long) fractionPart2;
                            Frpart2 = Frpart2.concat(String.valueOf(fpartMul2[i]));
                            fractionPart2 = Math.round((fractionPart2) * 10000.0) / 10000.0;
                            fractionPart2 = fractionPart2 - fpartMul2[i];
                        }
                        t3.setText(Octal + "." + Frpart2);

                        Hex1 = Integer.toHexString(Integer.parseInt(String.valueOf(DecimalPart2)));
                        Hex = Hex1.toUpperCase();
                        fractionPart2 = Math.round((roundOff - DecimalPart2) * 10000.0) / 10000.0;

                        for (int i = 0; i < 6; i++) {
                            fractionPart2 = fractionPart2 * 16;
                            fpartMul3[i] = (long) fractionPart2;
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
                            fractionPart2 = Math.round((fractionPart2) * 10000.0) / 10000.0;
                            fractionPart2 = fractionPart2 - fpartMul3[i];
                        }

                        t4.setText(Hex + "." + Frpart3);
                    }
                }
            }catch (NumberFormatException Ni){
                t1.setText("");
                JOptionPane.showMessageDialog(j1,"Incorrect(Enter 0 or 1)",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }

            } else if(e.getSource()==b3){
            new ThanksFrame();
            j1.dispose();
        }

    }

    public static void main(String[] args) {
        new BinaryConversion();
    }

}