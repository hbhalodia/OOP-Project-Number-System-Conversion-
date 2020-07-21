import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OctalConversion implements ActionListener {
    JFrame j1;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4;

    OctalConversion(){
        j1 = new JFrame("Binary conversion");
        l1 = new JLabel("Input Octal Number");
        l2 = new JLabel("Decimal Number ");
        l3 = new JLabel("Binary Number ");
        l4 = new JLabel("Hexadec Number");
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
        j1.setResizable(false);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    double OctalNumber2,FDeci2=0,fractionPart,fractionPart2;
    long []fpartMul = new long[6];
    long []fpartMul3 = new long[6];
    int decimal_num,i=0,flag=0;
    long OctNum;
    String Bin,Frpart="",Frpart3="",Hex,Hex1;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new ProjectFrame();
            j1.dispose();
        }else if(e.getSource()==b2){
            try {
                Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
                String OCCttt = t1.getText();
                OctalNumber2 = Double.parseDouble(OCCttt);
                Matcher matcher = pattern.matcher(OCCttt);
                if (matcher.matches()) {
                    int occtimm  = Integer.parseInt(OCCttt,8);
                    String Binaryyy = Integer.toBinaryString(Integer.parseInt(String.valueOf(occtimm)));
                    String Hex11 = Integer.toHexString(Integer.parseInt(String.valueOf(occtimm)));
                    String Heex = Hex11.toUpperCase();
                    t2.setText(String.valueOf(occtimm));
                    t3.setText(Binaryyy);
                    t4.setText(Heex);
                } else {

                    OctNum = (long) OctalNumber2;
                    String AcOctNum = String.valueOf(OctNum);
                    double Octim = Integer.parseInt(AcOctNum, 8);
                    int octim2 = (int) Octim;
                    // System.out.println(Octim);
                    double Foctt = OctalNumber2 - OctNum;
                    double Foct = Math.round((Foctt) * 1000.0) / 1000.0;
                    String FFoct = String.valueOf(Foct);
                    int n = FFoct.indexOf('.');
                    String SubOct = FFoct.substring(n + 1);
                    int len = SubOct.length();
                    int p = -1, deciOct;
                    char oct;
                    for (int i = 0; i < len; i++) {
                        oct = SubOct.charAt(i);
                        if (oct == 48 || oct == 49 || oct == 50 || oct == 51 || oct == 52 || oct == 53 || oct == 54 || oct == 55) {
                            deciOct = (int) oct - 48;
                            FDeci2 = FDeci2 + deciOct * Math.pow(8, p);
                            p--;
                            flag = 0;
                        } else {
                            flag = 1;
                            FDeci2 = 0;
                            Octim = 0;
                            break;
                        }
                    }
                    if (flag == 1) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        JOptionPane.showMessageDialog(j1, "Incorrect (Enter 0 to 7 Only)", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double roundOff = Math.round((Octim + FDeci2) * 1000.0) / 1000.0;
                        t2.setText(String.valueOf(roundOff));

                        String Binary = Integer.toBinaryString(Integer.parseInt(String.valueOf(octim2)));
                        fractionPart = Math.round((roundOff - Octim) * 10000.0) / 10000.0;

                        for (int i = 0; i < 6; i++) {
                            fractionPart = fractionPart * 2;
                            fpartMul[i] = (long) fractionPart;
                            Frpart = Frpart.concat(String.valueOf(fpartMul[i]));
                            fractionPart = Math.round((fractionPart) * 10000.0) / 10000.0;
                            fractionPart = fractionPart - fpartMul[i];
                        }

                        t3.setText(Binary + "." + Frpart);

                        Hex1 = Integer.toHexString(Integer.parseInt(String.valueOf(octim2)));
                        Hex = Hex1.toUpperCase();
                        fractionPart2 = Math.round((roundOff - Octim) * 10000.0) / 10000.0;

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
            }catch(NumberFormatException Ni){
                t1.setText("");
                JOptionPane.showMessageDialog(j1,"Incorrect (Enter 0 to 7 only)", "Error",JOptionPane.ERROR_MESSAGE);

            }
        }else if(e.getSource()==b3){
            new ThanksFrame();
            j1.dispose();
        }

    }

    public static void main(String[] args) {
        new OctalConversion();
    }
}