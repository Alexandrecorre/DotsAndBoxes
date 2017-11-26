import java.util.Scanner;

public class Jeu {
	Scanner scan=new Scanner(System.in);

	public int[] demarrage(){
		Afficheur aff=new Afficheur();
		Console csl=new Console();
		int[] dimchoix=new int[3];
		System.out.println("Afficheur ou console ?");
		String type=scan.nextLine();
		while(!type.equals("console") || !type.equals("Console") || !type.equals("Afficheur") || !type.equals("afficheur") ){
			if(type.equals("console") || type.equals("Console") || type.equals("Afficheur") || type.equals("afficheur"))break;
			System.out.println("Veuillez choisir le mode console ou afficheur");
			type=scan.nextLine();}
		if(type.equals("console") || type.equals("Console") ){ //console
			dimchoix[0]= csl.IfConsole();dimchoix[1]=0;}
		else if(type.equals("Afficheur") || type.equals("afficheur")){ // Affichage
			int[] A=aff.Affichage();
			dimchoix[0]=A[0];dimchoix[1]=A[1];dimchoix[2]=1;}
		return dimchoix;
	}

	public int[] Carre(int dim){
		int[] Carre=new int [(dim-1)*(dim-1)];
		for (int i=0;i<Carre.length;i++){
			Carre[i]=0;
		}
		return Carre;
	}

	public void Tableaucoup(int dim, int [][] tab){
		int ligne=0;
		for(int y=0;y<=dim;y++){
			for(int x=0;x<dim;x++){
				tab[ligne][0]=x;
				tab[ligne][1]=y;
				tab[ligne][2]=x+1;
				tab[ligne][3]=y;
				tab[ligne][4]=0;
				ligne=ligne+1;
			}}
		for(int x=0;x<=dim;x++){
			for(int y=0;y<dim;y++){
				tab[ligne][0]=x;
				tab[ligne][1]=y;
				tab[ligne][2]=x;
				tab[ligne][3]=y+1;
				tab[ligne][4]=0;
				ligne=ligne+1;	
			}}

	}

	public boolean Compteur(int[][] tab){
		int x=0;
		for(int i=0;i<tab.length;i++){
			if(tab[i][4]==1){
				x++;}
		}
		if(x==tab.length){
			return true;
		}else{
			return false;}
	}


}
