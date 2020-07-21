import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalToOctal {
    public static void main(String[] args) throws IOException {
        double DecimalFraction2, fractionPart2;
        long DecimalPart2;
        String Frpart2 = "";
        long[] fpartMul2 = new long[6];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Decimal Numebr : ");
        DecimalFraction2 = Double.parseDouble(br.readLine());
        DecimalPart2 = (long) DecimalFraction2;
        String Octal = Integer.toOctalString(Integer.parseInt(String.valueOf(DecimalPart2)));
        fractionPart2 = Math.round((DecimalFraction2 - DecimalPart2) * 10000.0) / 10000.0;

        for (int i = 0; i < 6; i++) {
            fractionPart2 = fractionPart2 * 8;
            fpartMul2[i] = (long) fractionPart2;
            Frpart2 = Frpart2.concat(String.valueOf(fpartMul2[i]));
            fractionPart2 = Math.round((fractionPart2) * 10000.0) / 10000.0;
            fractionPart2 = fractionPart2 - fpartMul2[i];
        }
        System.out.println("Decimal to Octal : " + Octal + "." + Frpart2);

        double OctalNumber2;
        System.out.println("Enter Octal  Numebr : ");
        OctalNumber2 = Double.parseDouble(br.readLine());
        long OctNum = (long)OctalNumber2;
        String AcOctNum = String.valueOf(OctNum);
        double Octim = Integer.parseInt(AcOctNum, 8);
        System.out.println(Octim);
        double  Foctt = OctalNumber2 - OctNum;

        double Foct= Math.round((Foctt) * 1000.0) / 1000.0;

        String FFoct = String.valueOf(Foct);
        int n=FFoct.indexOf('.');
        System.out.println(n);
        String SubOct = FFoct.substring(n+1);
        System.out.println(SubOct);
        int len =  SubOct.length();
        int p=-1;
        char oct;
        int deciOct;
        double FDeci2=0;
        for(int i=0;i<len;i++){
           // oct = SubOct.charAt(i);
            oct = SubOct.charAt(i);
            deciOct =  (int)oct - 48;
            FDeci2 = FDeci2 + deciOct*Math.pow(8,p);
            p--;

        }
        double roundOff = Math.round((Octim+FDeci2) * 1000.0) / 1000.0;

        System.out.println("Octal to decimal "+roundOff);
    }
}
