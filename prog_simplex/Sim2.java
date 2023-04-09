package prog_simplex;


////////////////////combin avec maximisation////////////////////////
import java.util.Scanner;

public class Sim2 {	 
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter le nombre des ingrediant:");	
	int nIng = sc.nextInt();
	// nombre d'ingrédients	  
	 String[] nameIng = new String[nIng];	
	 double[] prices = new double[nIng];	
	 System.out.println("enter le nombre des nutrition:");
	 int nNut = sc.nextInt(); 
	 // nombre de nutrition	        
	 sc.nextLine();
	 double[][] nutrients = new double[nIng+1][nNut+nIng+1];
	 //  types de nutriments	        
	 String[] nameNut= new String[nNut];
	 for(int i=0;i<nNut;i++) {	
		 System.out.println("enter le nom de "+(i+1)+" nutrition:");	
		 nameNut[i]=sc.nextLine();	
		 }	
	  for(int i=0;i<nIng;i++) {	
		 System.out.println("enter le nom de "+i+"ingrediant:");	
		 nameIng[i]=sc.nextLine();	
		 System.out.println("enter le prix de 1kg de"+nameIng[i]);	
		 prices[i]=sc.nextInt();	
		 sc.nextLine();
		 for(int j=0;j<nNut;j++){	
			 System.out.println("enter la quantité de"+nameNut[j]);	
			 nutrients[j][i]=sc.nextInt();	
			 sc.nextLine();
			}
		}
	 //Entrée des objectifs nutritionnels	  
	  for(int i=0;i<nNut;i++) {	
		 System.out.println("Objectif de teneur en "+nameNut[i]);	
		 nutrients[i][nIng+nNut]=sc.nextInt();
		 sc.nextLine();
		 }	
		 for (int j = 0; j < nIng; j++)			
			 nutrients[nNut][j] = prices[j];		
		 for (int i = 0; i < nNut; i++) {	
			 int slack = 1;		
			 nutrients[i][nIng + i] = slack;		
			 }	 
		 for (int i = 0; i <= nIng; i++) {
			 for (int j = 0; j <= nIng+ nNut; j++) {	
				 System.out.printf("%7.2f ", nutrients[i][j]);		
				 }
			 System.out.println();		
			 }
		 
		 
		 
		 
		 
		 Simplex simplex = new Simplex(nutrients,nNut,nIng);	 
		 }

	 }


