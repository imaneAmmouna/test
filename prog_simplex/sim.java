package prog_simplex;

import java.util.Scanner;

public class sim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		//nbre des ingredients
		System.out.println("enter le nombre des ingrediant:");
		int nIng = sc.nextInt(); 
		 
		String[] nameIng = new String[nIng]; 
		int[] prices = new int[nIng];
		// nombre des nutritions 
		System.out.println("enter le nombre des nutrition:");	
		int nNut = sc.nextInt(); 
		
		// nombre de nutritment       
		sc.nextLine();	 
		int[][] nutrients = new int[nIng][nNut]; 
		
		//  noms des nutriments	        
		String[] nameNut= new String[nNut]; 
		for(int i=0;i<nNut;i++) {	
			System.out.println("enter le nom du nutrition "+(i+1)+":");
			nameNut[i]=sc.nextLine();	
			}
		
		//pourcentage voulu _ right side
		int[] pourcentage = new int[nNut];
		for(int i=0;i<nNut;i++) {
			System.out.println("Objectif de teneur en "+nameNut[i]);	
			pourcentage[i]=sc.nextInt();
			sc.nextLine();
			}
		
		//les noms des ingredients
			for(int k=0;k<nIng;k++) {
				System.out.println("enter le nom de ingrediant "+(k+1)+":");
				nameIng[k]=sc.nextLine();
				//prix de chaque ingrediant
				System.out.println("enter le prix de 1kg de "+nameIng[k]+":");
				prices[k]=sc.nextInt();
				sc.nextLine();	
				//quantite des nutriments dans chaque ingrediants
				for(int j=0;j<nNut;j++){	
					System.out.println("enter la quantité de "+nameNut[j]+":");	
					nutrients[k][j]=sc.nextInt();	
					sc.nextLine();
					}
				}
		//affichage
			System.out.println("_______________right side__________________");
			for(int i=0;i<nNut;i++) {
				for(int j=0;j<nutrients.length;j++){	
				System.out.print(nutrients[j][i]+"  ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("_____________fct objectif____________________");
			for(int i=0;i<prices.length;i++) {	
				System.out.print(prices[i]+"  ");
			}
			System.out.println();
			System.out.println("_________________left side________________");
			for(int i=0;i<nNut;i++){	
				System.out.println(pourcentage[i]);
				}
			
			//table initial du dual
			System.out.println("_______________right side dual initial__________________");
			int new_nutrients[][] = new int[nNut][nIng];
			for(int i = 0; i<nIng ;i++){
		         for(int j = 0; j<nNut ;j++){
		            	new_nutrients[j][i] = nutrients[i][j];
		            	System.out.print(new_nutrients[j][i]+" ");
		         }
		         System.out.println();
		      }
			
			//dual dans une seule matrice
			System.out.println("_______________table dual initial__________________");
			int new_nNut=nNut+1;
			int new_nIng=nIng+1;
			
			double[][] table_dual = new double[new_nIng][new_nNut];
			
			for(int i = 0; i<new_nIng-1 ;i++){
		         for(int j = 0; j<new_nNut-1 ;j++){
		        	 table_dual[i][j] = nutrients[i][j];
		         }
		      }
			
			for(int i=0;i<new_nIng-1;i++) {
				for(int j = new_nNut-1; j<new_nNut ;j++) {
					table_dual[i][j] =prices[i] ;
				}
			}
			
			for(int i=new_nIng-1;i<new_nNut;i++) {
				for(int j = 0; j<new_nNut-1 ;j++) {
					table_dual[i][j] = pourcentage[j];
				}
			}
			//System.out.print(new_nutrients[j][i]+" ");
			for(int i = 0; i<new_nIng ;i++){
		         for(int j = 0; j<new_nNut ;j++){
		            	System.out.print(table_dual[i][j]+" ");
		         }
		         System.out.println();
		      }
			
			//Dual2 combin = new Dual2(table_dual,new_nIng,new_nNut);
			
		}
	}
