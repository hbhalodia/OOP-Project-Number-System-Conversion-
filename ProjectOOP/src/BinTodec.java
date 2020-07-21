import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinTodec {
    public static void main(String[] args) throws IOException {
        double DecimalFraction, Fraction, BinaryFraction = 0.0, FractionalFactor = 0.1, Binary,Fdeci=0.0;
        int DecimalInteger, temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter Decimal Number : ");
        DecimalFraction = Double.parseDouble(br.readLine());

        DecimalInteger = (int) DecimalFraction;
        Fraction =  Math.round((DecimalFraction - DecimalInteger) * 100.0) / 100.0;
        System.out.println(Fraction);
        String dec = String.valueOf(DecimalInteger);

        String Decimal = Integer.toBinaryString(Integer.parseInt(dec));

        System.out.println(Decimal);
        for (int i = 0; i < 6; i++) {
            Fraction = Fraction * 2;
            temp = (int) Fraction;

            BinaryFraction = BinaryFraction + FractionalFactor * temp;
            if (temp == 1) {
                Fraction = Fraction - temp;
                FractionalFactor = FractionalFactor / 10;

            }
        }
        System.out.println(BinaryFraction);
        Binary = Double.parseDouble(Decimal);
        System.out.println("Binary Conversion is : " + (Binary + BinaryFraction));


        // For Binary To decimal

        double decim = Integer.parseInt(Decimal, 2);
        int deciBin;
        String Fbin = String.valueOf(BinaryFraction);
        int n = Fbin.indexOf('.');
        String SubBin = Fbin.substring(n + 1);
        int len = SubBin.length(), p = -1;
        char bin;
        for (int i = 0; i < len; i++) {
            bin = SubBin.charAt(i);
            deciBin = (int) bin - 48;
            Fdeci = Fdeci + deciBin*Math.pow(2,p);
            p--;
        }
        double roundOff = Math.round((decim+Fdeci) * 100.0) / 100.0;
        System.out.println("Decimal Of Number Is : "+roundOff);
    }
}
