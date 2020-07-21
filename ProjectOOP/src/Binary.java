import java.util.Scanner;

public class Binary {
    /*double frDecimal,fraBinary,Bfractional=0.0,dFractional,FraFactor=0.1;
    long dIntegral,bIntegral=0;
    long intFactor=1,remainder,temp,i;
    public static void main(String[] args) throws IOException {
      Binary B = new Binary();
     B.decToBin();
    }

   public void decToBin() throws IOException {


       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("enter Frational Decimal NUmber ");
       frDecimal = Double.parseDouble(br.readLine());
       *//*String DecimalT= String.valueOf(frDecimal);
       int t=DecimalT.indexOf('.');
       String SubDeci = DecimalT.substring(t+1);
       int len1 = SubDeci.length();*//*
       dIntegral = (long) frDecimal;
       String DINtegral = String.valueOf(dIntegral);
       int decimal;
       decimal = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(DINtegral)));

       dFractional = frDecimal - dIntegral;

*//*
       while (dIntegral != 0) {
           remainder = dIntegral % 2;
           bIntegral = bIntegral + remainder * intFactor;
           dIntegral = dIntegral / 2;
           intFactor = intFactor * 10;
       }*//*
       for (i = 0; i <6; i++) {
           dFractional = dFractional * 2;
           temp = (long) dFractional;

           Bfractional = Bfractional + FraFactor * temp;
           if (temp == 1)
               dFractional = dFractional - temp;
           FraFactor = FraFactor / 10;
       }
       fraBinary = decimal + Bfractional;

       System.out.println("Binary is :" + fraBinary);


       String Bin = String.valueOf(fraBinary);
       //System.out.println(Bin);
       int n=Bin.indexOf('.');
       String SubBin = Bin.substring(n+1);
       //System.out.println(SubBin);
       int len = SubBin.length(),p=-1;
       char bin;
       double deci=0.0;
       int deciBin;
       for(int i=0;i<len;i++){
           bin =  SubBin.charAt(i);
           deciBin = (int)bin-48;
          // System.out.println("bin "+bin);
           //System.out.println("deciBin"+deciBin);
           deci = deci + deciBin*Math.pow(2,p);
           p--;
       }
       double decim = Integer.parseInt(String.valueOf(decimal),2);
       double roundOff = Math.round((decim+deci) * 100.0) / 100.0;
       System.out.println("Decimal Of Number Is : "+roundOff);


   }*/
    public static void main(String[] args) {
        int num1,num2;
        char bin1,bin2;
        String result = "";

        Scanner Sc = new Scanner(System.in);
        System.out.println("enter Integers : ");
        num1 = Sc.nextInt();
        num2 = Sc.nextInt();
        String binaryStr1 = Integer.toBinaryString(num1);
        String binaryStr2 = Integer.toBinaryString(num2);
        String output1 = String.format("%8s", binaryStr1).replace(' ', '0');
        String output2 = String.format("%8s", binaryStr2).replace(' ', '0');
        System.out.println("8 bit Binary Is : "+output1);
        System.out.println("8 bit Binary Is : "+output2);

        int result1 = num1+(~num2+1);
        result = Integer.toBinaryString(result1);
        System.out.println(result);
        String Outout1 = String.format("%8s", result).replace(' ', '0');
        System.out.println(Outout1);
    }
}