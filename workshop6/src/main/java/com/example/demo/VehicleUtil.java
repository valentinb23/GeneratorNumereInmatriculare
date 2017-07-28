package com.example.demo;

import java.text.DecimalFormat;
import java.util.Random;

public class VehicleUtil {
	public static DecimalFormat df2 = new DecimalFormat("00");
	public static DecimalFormat df3 = new DecimalFormat("000");
	public static DecimalFormat df6 = new DecimalFormat("000000");
	public static DecimalFormat df7 = new DecimalFormat("0000000");

	public static String Normal(String judet) {
		String numberPlate;
		Random r = new Random();
		char A;
		char B; 
		char C;
		String ABC;
		do{
		A = (char) (r.nextInt(26) + 'A');
		B = (char) (r.nextInt(26) + 'A');
		C = (char) (r.nextInt(26) + 'A');
		ABC = ""+A+B+C;
		}
		while (ABC.contains("II")==true || ABC.contains("OO")==true);
			
		if (judet.equals("B"))
			numberPlate = judet + " " + String.valueOf(df3.format(Math.random() * 1000)).substring(0, 3) + " " + ABC;
		else
			numberPlate = judet + " " + String.valueOf(df2.format(Math.random() * 100)).substring(0, 2) + " " + ABC;

		return numberPlate;
	}

	public static String Provizoriu(String judet) {
		String numberPlate;
		if (judet.equals("CD"))
			numberPlate = "CD " + String.valueOf(df6.format(Math.random() * 1000000)).substring(0, 6);
		else if (judet.equals("TC"))
			numberPlate = "TC " + String.valueOf(df6.format(Math.random() * 1000000)).substring(0, 6);
		else
			numberPlate = judet + " " + String.valueOf(df6.format(Math.random() * 1000000)).substring(0, 6);
		return numberPlate;
	}

	public static String Armata() {
		String numberPlate;
		if (Math.random() < 0.5)
			numberPlate = "A " + String.valueOf(df3.format(Math.random() * 1000)).substring(0, 3);
		else
			numberPlate = "A " + String.valueOf(df7.format(Math.random() * 10000000)).substring(0, 7);
		return numberPlate;
	}

}
