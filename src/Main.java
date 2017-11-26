import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Jeu ex=new Jeu();
		Afficheur aff=new Afficheur();
		Console csl=new Console();
		Scanner scan=new Scanner(System.in);
		int restart =1;
		while(restart==1){
			int[] dimchoix=ex.demarrage();
			int dim=dimchoix[0];int pointille=dimchoix[1];int choix=dimchoix[2];
			int tab [][]=new int [dim*(dim-1)*2][5];
			int tours=0;
			int player1=0;
			int player2=0;
			int[] résultat=new int[3];
			ex.Tableaucoup(dim-1, tab);
			int[] Carre=ex.Carre(dim);
			if (choix==0){//console
				int[] Choix=csl.demarrageConsole(dim);
				String [] tableau=csl.consoleTableau(dim);
				tableau=csl.randomPointille(Choix[0], tab, tableau, dim);
				csl.afficheTableau(tableau);
				if(Choix[1]==1){// player vs player
					while(!ex.Compteur(tab)){
						System.out.println("veuillez saisir les coordonnées  de départ puis d'arrivée que vous souhaitez :");
						int a=scan.nextInt();
						int b=scan.nextInt();
						int c=scan.nextInt();
						int d=scan.nextInt();
						int[]A={a,b,c,d};
						csl.rechercheConsole(A, tab, tours,tableau,dim);
						tours=csl.carreConsole(tab, dim, tours, player1, player2, Carre, tableau);
						tours=tours+1;
						csl.afficheTableau(tableau);}}

				else if(Choix[1]==2){// player vs ia
					if(tours%2==0){
						System.out.println("veuillez saisir les coordonnées  de départ puis d'arrivée que vous souhaitez :");
						int a=scan.nextInt();int b=scan.nextInt();
						int c=scan.nextInt();int d=scan.nextInt();
						int[]A={a,b,c,d};
						csl.rechercheConsole(A, tab, tours,tableau,dim);
						tours=csl.carreConsole(tab, dim, tours, player1, player2, Carre, tableau);
						tours=tours+1;
						csl.afficheTableau(tableau);}
					else{
						csl.randomIA(tab, tableau, dim);
						tours++;
						tours=csl.carreConsole(tab, dim, tours, player1, player2, Carre, tableau);
						tours=tours+1;
						csl.afficheTableau(tableau);
					}}

				else if(Choix[1]==3){// ia vs ia
					while(!ex.Compteur(tab)){
						csl.randomIA(tab,tableau,dim);
						tours=csl.carreConsole(tab, dim, tours, player1, player2, Carre, tableau);
						tours=tours+1;
						csl.afficheTableau(tableau);	
					}}
				for(int i=0;i<Carre.length;i++){
					if(Carre[i]==1){résultat[0]++;}
					else{résultat[1]++;}
				}
				if(résultat[0]>résultat[1]){
					System.out.println( "Winner Player  1");
					System.out.println("Player  1 : "+ résultat[0]+"      "+"Player  2 : "+ résultat[1]);}
				else if(résultat[0]==résultat[1]){
					System.out.println("Egalité");}
				else{	System.out.println( "Winner Player  2");
				System.out.println("Player  1 : "+ résultat[0]+"      "+"Player  2 : "+ résultat[1]);}
				System.out.println("Voulez-vous rejouer ?  oui   non ");
				String réponse=scan.next();
				if(réponse.equals("non")){
					restart=0;
					break;
				}else{restart=1;}}

			else{//Afficheur
				int Adversaire=aff.choixAdversaire();
				Espace page=new Espace(dim);
				aff.randomPointille(pointille,tab);
				if(Adversaire==1){// player vs player
					while(!ex.Compteur(tab)){				
						int[] A=aff.Coup(dim,tours);
						if(aff.rechercheAfficheur(A, tab)){
							tours=aff.carreAfficheur(tab, dim, tours, player1, player2,A,Carre);
							tours=tours+1;
						}
					}}
				else if(Adversaire==2){// player vs ia
					while(!ex.Compteur(tab)){
						if(tours%2==0){
							int[] A=aff.Coup(dim,tours);
							if(aff.rechercheAfficheur(A, tab)){
								tours=aff.carreAfficheur(tab, dim, tours, player1, player2,A,Carre);
								tours=tours+1;
							}}
						else{
							int[] A=aff.randomIA(tab);
							tours=aff.carreAfficheur(tab, dim, tours, player1, player2,A,Carre);
							tours=tours+1;
							StdDraw.show(800);}	
					}}
				else{while(!ex.Compteur(tab)){// ia vs ia
					StdDraw.show(200);
					int[] A=aff.randomIA(tab);
					tours=aff.carreAfficheur(tab, dim, tours, player1, player2,A,Carre);
					tours=tours+1;
					StdDraw.show(400);}
				}
				for(int i=0;i<Carre.length;i++){
					if(Carre[i]==1){résultat[0]++;}
					else{résultat[1]++;}
				}
				StdDraw.show();
				StdDraw.clear();
				if(résultat[0]>résultat[1]){
					StdDraw.text((int)((dim)*50/2), (int)((dim)*50/2), "Winner Player  1");
					StdDraw.text((int)((dim)*50/2), (int)((dim)*50/2)-50, "Player  1 : "+ résultat[0]+"      "+"Player  2 : "+ résultat[1]);}
				else if(résultat[0]==résultat[1]){
					StdDraw.text((int)((dim)*50/2), (int)((dim)*50/2), "Egalité");}
				else{StdDraw.text((int)((dim)*50/2), (int)((dim)*50/2), "Winner Player  2");
				StdDraw.text((int)((dim)*50/2), (int)((dim)*50/2)-50, "Player  1 : "+ résultat[0]+"      "+"Player  2 : "+ résultat[1]);}

				System.out.println("Voulez-vous rejouer ?  oui   non ");
				String réponse=scan.next();
				if(réponse.equals("non")){
					restart=0;
					break;
				}else{restart=1;}
			}}}}

