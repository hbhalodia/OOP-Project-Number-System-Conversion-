import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryNew {
    public static void main(String[] args) throws IOException {
        double DecimalFraction,fractionPart,BinaryNumber;
        long DecimalPart;
        long []fpartMul = new long [6];
        String Frpart = "" ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Decimal Numebr : ");
        DecimalFraction = Double.parseDouble(br.readLine());
         DecimalPart = (long) DecimalFraction;
        String Decimal = Integer.toBinaryString(Integer.parseInt(String.valueOf(DecimalPart)));
         fractionPart = Math.round((DecimalFraction- DecimalPart) * 10000.0) / 10000.0;

         for(int i=0;i<6;i++){
             fractionPart = fractionPart*2;
             fpartMul[i] = (long)fractionPart;
             Frpart=Frpart.concat(String.valueOf(fpartMul[i]));
             fractionPart = Math.round((fractionPart) * 10000.0) / 10000.0;
             fractionPart = fractionPart-fpartMul[i];
         }
        System.out.println("Decimal to binary : "+Decimal+"."+Frpart);

         // Binary to decimal
        System.out.println("Enter Binary Numebr : ");
        BinaryNumber = Double.parseDouble(br.readLine());
        long binNum = (long)BinaryNumber;
        String AcBinNum = String.valueOf(binNum);
        double decim = Integer.parseInt(AcBinNum, 2);
        double  Fbinn = BinaryNumber - binNum;

        double Fbin = Math.round((Fbinn) * 1000.0) / 1000.0;

        String FFbin = String.valueOf(Fbin);
        int n=FFbin.indexOf('.');
        String SubBin = FFbin.substring(n+1);

        int len =  SubBin.length(),p=-1;
        char bin;
        int deciBin;
        double Fdeci=0;

        for(int i=0;i<len;i++){
            bin = SubBin.charAt(i);
            deciBin = (int) bin - 48;
            Fdeci = Fdeci + deciBin*Math.pow(2,p);

            p--;

        }
        double roundOff = Math.round((decim+Fdeci) * 1000.0) / 1000.0;

        System.out.println("Binary to decimal "+roundOff);




    }
}
