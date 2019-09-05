// Christopher De Jong
// CECS 277
// 09/04/2019
import java.util.Scanner;
public class Rational
{
    private int numerator;
    private int denominator;
    public Rational()
    {
    		numerator = 0;
    		denominator = 1;
	}
	public Rational(int num, int den)
	{
		numerator = num;
		denominator = den;
	}
    public int getNumerator()
    {
        return numerator;
    }
    public int getDenominator()
    {
        return denominator;
    }
    public void setNumerator(int value){
        numerator = value;
    }
    public void setDenominator(int value)
    {
        denominator = value;
    }
    public void inputRational()
    {
	   Scanner in = new Scanner(System.in);
	   System.out.print("Enter the Numerator:");
	   numerator = in.nextInt();
	   System.out.print("Enter the Denominator:");
	   denominator = in.nextInt();

    }
    public String toString()
    {
	   if (denominator < 0)
	   	{
			denominator = Math.abs(denominator);
			return "-" + numerator + "/" + denominator;
		}
	   else if (numerator == 0)
	   {
	   return "0";
    	   }
        return numerator + "/" + denominator;
    }
    private int gcd(int m, int n)
    {
        int r;
        while(n!=0)
        {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
    public void add(Rational r1, Rational r2)
    {
        numerator = (r1.numerator*r2.denominator)+(r2.numerator*r1.denominator);
        denominator = r1.denominator*r2.denominator;
        int gcd = gcd(numerator, denominator);
        denominator /= gcd;
        numerator /= gcd;
    }
    public Rational sub(Rational r)
    {
	   int comden = denominator*r.getDenominator();
        int num1 = numerator*r.getDenominator();
        int num2 = r.getNumerator()*denominator;
	   int dif = num1-num2;
        int gcd = gcd(dif, comden);
        comden /= gcd;
        dif /= gcd;
	   return new Rational(dif, comden);
    }
    public void mul(Rational r1,Rational r2)
    {
        numerator = r1.numerator*r2.numerator;
        denominator = r1.denominator*r2.denominator;
        int gcd = gcd(numerator, denominator);
        denominator /= gcd;
        numerator /= gcd;
    }
    public Rational div(Rational r)
    {
        int comden = numerator* r.getDenominator();
        int dif = denominator*r.getNumerator();
        int gcd = gcd(dif, comden);
        comden /= gcd;
        dif /= gcd;
	   return new Rational(dif, comden);
    }
    public static double divToDouble(Rational r1,Rational r2)
    {
        int denominator = r1.denominator * r2.numerator;
        int numerator = r1.numerator * r2.denominator;
        return (double)numerator/denominator;
    }
    public static void main(String[] args){
        Rational R1 = new Rational();
        Rational R2 = new Rational();
        R1.inputRational();
        R2.inputRational();

        Rational R3 = new Rational();
        R3.add(R1, R2);
        System.out.println(R1 + " + " + R2 + " = " + R3);
        R3 = R1.sub(R2);
        System.out.println(R1 + " - " + R2 + " = " + R3);
        R3.mul(R1, R2);
        System.out.println(R1 + " * " + R2 + " = " + R3);
        R3 = R2.div(R1);
        System.out.println(R1 + " / " + R2 + " = " + R3);
        System.out.println(R1 + " / " + R2 + " = " + divToDouble(R1, R2));
        R1.setNumerator(2);
        R2.setDenominator(5);
        System.out.println("Numerator: " + R1.getNumerator());
        System.out.println("Denominator: " + R2.getDenominator());
    }
}
