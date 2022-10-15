package rekurencja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class NWW {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj a = ");
		int a = sc.nextInt();
		System.out.println("Podaj b = ");
		int b = sc.nextInt();
		ArrayList<Integer> liczbyPierwsze = pierwsze();
		System.out.println("NWW liczby "+ a +" i "+ b +" = " + rozklad(a, b, liczbyPierwsze));

		}
		public static ArrayList<Integer> pierwsze() {
			ArrayList<Integer> pierwsze = new ArrayList<>();
			pierwsze.add(2);
			for (int i=1; i<100; i++) {
				for (int j=i-1; j>0; j--) {
					if(i%j!=0) {
						if(j==2) {
							pierwsze.add(i);
						}		
					}else {
						j=0;
					}	
				}
			}
			return pierwsze;
		}
		
		public static int rozklad(int a, int b, ArrayList<Integer> pierwsze) {
			ArrayList<Integer> rozkladA = new ArrayList<>();
			ArrayList<Integer> rozkladB = new ArrayList<>();
			int wynik=1;
			while(a!=1) {
				 for(int i:pierwsze) {
					 if(a%i==0) {
						 a=a/i;
						 rozkladA.add(i);
					 }
			 }
			}
			while(b!=1) {
				 for(int i:pierwsze) {
					 if(b%i==0) {
						 b=b/i;
						 rozkladB.add(i);
					 }
			 }
			}
			List<Integer> newRozkladA = rozkladA.stream().distinct().collect(Collectors.toList());
			List<Integer> newRozkladB = rozkladB.stream().distinct().collect(Collectors.toList());
			for(int i:newRozkladA) {
				wynik=(int) (wynik*Math.pow(i,(Math.max(Collections.frequency(rozkladA, i), Collections.frequency(rozkladB, i)))));
				for(int j:newRozkladB) {
					if(rozkladA.contains(j)) {
					}else {
						wynik=(int) (wynik*Math.pow(j, Collections.frequency(rozkladB, j)));
					}
				}
		
			}
			return wynik;

	}
}
