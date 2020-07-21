/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalTohex {
    public static void main(String[] args) throws IOException {
        double DecimalFraction3,fractionPart3;
        long DecimalPart3;
        String Frpart3 = "";
        long[] fpartMul3 = new long[6];
       // String []fpartMul = new String[6];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter Decimal Number");
        DecimalFraction3 = Double.parseDouble(br.readLine());
        DecimalPart3 = (long)DecimalFraction3;
        fractionPart3 = DecimalFraction3-DecimalPart3;
        String Hex1 = Integer.toHexString(Integer.parseInt(String.valueOf(DecimalPart3)));
        fractionPart3 = Math.round((DecimalFraction3 - DecimalPart3) * 10000.0) / 10000.0;
        String Hex = Hex1.toUpperCase();
        //System.out.println(Hex);

        for (int i = 0; i < 6; i++) {
            fractionPart3 = fractionPart3 * 16;
            fpartMul3[i] = (long) fractionPart3;
            if(fpartMul3[i]==10){
                Frpart3 = Frpart3.concat("A");
            }else if(fpartMul3[i]==11){
                Frpart3 = Frpart3.concat("B");
            }else if(fpartMul3[i]==12){
                Frpart3 = Frpart3.concat("C");
            }else if(fpartMul3[i]==13){
                Frpart3 = Frpart3.concat("D");
            }if(fpartMul3[i]==14){
                Frpart3 = Frpart3.concat("E");
            }else if(fpartMul3[i]==15){
                Frpart3 = Frpart3.concat("F");
            }else if(fpartMul3[i]>=0&&fpartMul3[i]<10) {
                Frpart3 = Frpart3.concat(String.valueOf(fpartMul3[i]));
            }
            fractionPart3 = Math.round((fractionPart3) * 10000.0) / 10000.0;
            fractionPart3 = fractionPart3 - fpartMul3[i];
        }
        System.out.println("Decimal To hex : "+ Hex + "." + Frpart3);

        // HexaDecimal To Decimal

        */
/*double HexNumber2;
        System.out.println("Enter HexaDecimal  Numebr : ");
        HexNumber2 = Double.parseDouble(br.readLine());
        long Hexnum = (long)HexNumber2;
        String AcHexNum = String.valueOf(Hexnum);
        double Hexim = Integer.parseInt(AcHexNum, 16);
        System.out.println(Hexim);
        double  FHexx = HexNumber2- Hexnum;

        double FHex= Math.round((FHexx) * 1000.0) / 1000.0;

        String FFHex = String.valueOf(FHex);
        int n=FFHex.indexOf('.');
        System.out.println(n);
        String SubHex = FFHex.substring(n+1);

        int len =  SubHex.length();
        int p=-1;
        char hex;
        int decihex;
        double FDeci3=0;

        for(int i=0;i<len;i++){
            // oct = SubOct.charAt(i);
            hex = SubHex.charAt(i);
            decihex =  (int)hex - 48;
            FDeci3 = FDeci3 + decihex*Math.pow(16,p);
            p--;
        }
        double roundOff = Math.round((Hexim+FDeci3) * 1000.0) / 1000.0;

        System.out.println("Octal to decimal "+roundOff);*//*


        String HexNumber2,HexNumbbb="";
        System.out.println("Enter HexaDecimal  Numebr : ");
        HexNumber2 = br.readLine();
        int n=HexNumber2.indexOf('.');
        char hex;
        for(int i=0;i<n;i++){
            hex = HexNumber2.charAt(i);
            HexNumbbb = HexNumbbb.concat(String.valueOf(hex));
        }
       // System.out.println(HexNumbbb);
        double decimal = Integer.parseInt(HexNumbbb,16) ;
        //System.out.println(decimal);

        String SubHex = HexNumber2.substring(n+1);
        int len =  SubHex.length();
        int p=-1;
        char hexxx;
        int decihex;
        double FDeci3=0;

        for(int i=0;i<len;i++){
            // oct = SubOct.charAt(i);
            hexxx= SubHex.charAt(i);
            decihex =  (int)hexxx - 48;
            FDeci3 = FDeci3 + decihex*Math.pow(16,p);
            p--;
        }
        double roundOff = Math.round((decimal+FDeci3) * 1000.0) / 1000.0;

        System.out.println("hexaDecimal to decimal "+roundOff);
    }
}
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DecimalToHex {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        String str ;
        Scanner Sc = new Scanner(System.in);
        str = Sc.next();
        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            System.out.println("string '"+str + "' contains special character");
        } else {
            System.out.println("string '"+str + "' doesn't contains special character");
        }

    }
}