import java.util.Scanner;

public class Afficheur {

	Scanner scan=new Scanner(System.in);

	public int carreAfficheur(int [][] tab,int dim,int tours,int player1,int player2,int[]A,int[] Carre){
		int player=tours%2;
		int nbCarre=0;
		for(int x=0;x<dim;x++){
			for(int y=0;y<dim;y++){
				int carre=0;
				for(int i=0;i<tab.length;i++){
					if (tab[i][0]==x){
						if (tab[i][1]==y){
							if (tab[i][2]==x+1){
								if (tab[i][3]==y){
									if(tab[i][4]==1){
										carre=carre+1;
									}}}}}
					if (tab[i][0]==x){
						if (tab[i][1]==y){
							if (tab[i][2]==x){
								if (tab[i][3]==y+1){
									if(tab[i][4]==1){
										carre=carre+1;
									}}}}}
					if (tab[i][0]==x+1){
						if (tab[i][1]==y){
							if (tab[i][2]==x+1){
								if (tab[i][3]==y+1){
									if(tab[i][4]==1){
										carre=carre+1;
									}}}}}
					if (tab[i][0]==x){
						if (tab[i][1]==y+1){
							if (tab[i][2]==x+1){
								if (tab[i][3]==y+1){
									if(tab[i][4]==1){
										carre=carre+1;
									}}}}}
					if(carre==4 && Carre[x+y*(dim-1)]==0){
						Carre[x+y*(dim-1)]=player+1;
						StdDraw.text((x+1)*50+25, (y+1)*50+25,"Player "+ ((tours%2+1)));
						nbCarre=nbCarre+1;
					}
				}
			}}
		if(nbCarre!=0){tours=tours-1;}
		return tours;
	}



	public void Recouvrement(int[]A){
		StdDraw.setPenColor(StdDraw.WHITE);
		Ligne(A);
		StdDraw.setPenColor(StdDraw.BLACK);}

	public void Pointille(int [] A){
		int n=5;
		for(int i=0;i<n;i++){
			if(A[0]==A[2]){
				StdDraw.line((A[0]+1)*50,(A[1]+1)*50+i*((int)50/n),(A[2]+1)*50,(A[1]+1)*50+(i+1)*(int)((50/n))-5);
			}
			else{
				StdDraw.line((A[0]+1)*50+i*((int)50/n),(A[1]+1)*50,(A[0]+1)*50+(i+1)*(int)((50/n))-5,(A[3]+1)*50);}}}

	public void randomPointille(int n,int[][] tab){
		for(int i=0;i<n;i++){
			int a=(int)(Math.random()*tab.length);
			if(tab[a][4]==0){tab[a][4]=-1;
			Pointille(tab[a]);}
			else{ i--;}
		}
	}

	public int[] randomIA(int[][] tab){
		int[] A=new int[4];
		int a=(int)(Math.random()*tab.length);
		while(tab[a][4]==1){a=(int)(Math.random()*tab.length);}
		if(tab[a][4]==0){
			tab[a][4]=1;
			A[0]=(tab[a][0]+1)*50;A[1]=(tab[a][1]+1)*50;A[2]=(tab[a][2]+1)*50;A[3]=(tab[a][3]+1)*50;
			Ligne(A);
			return A;}
		else{
			tab[a][4]=0;
			A[0]=(tab[a][0]+1)*50;A[1]=(tab[a][1]+1)*50;A[2]=(tab[a][2]+1)*50;A[3]=(tab[a][3]+1)*50;
			Recouvrement(A);	
			return A;}}


	public int[] Affichage(){
		int dim=0;
		StdDraw.clear();
		StdDraw.setXscale(0,500);
		StdDraw.setYscale(0,500);		
		StdDraw.text(250,450, "5x5");
		StdDraw.text(250,350, "4x4");
		StdDraw.text(250,250, "3x3");
		StdDraw.text(250,150, "2x2");
		StdDraw.text(250,100,"Veuillez choisir votre nombre de boites" );
		Double Y;
		while(dim==0){
			Y =StdDraw.mouseY();
			if(StdDraw.mousePressed()){
				if(Y>300 && Y<400){dim=5;break;}
				else if(Y>400 && Y<500){dim=6;break;}
				else if(Y>200 && Y<300){dim=4;break;}
				else if(Y>0 && Y<200){dim=3;break;}}}

		StdDraw.clear();
		StdDraw.text(250,450, "Veuillez saisir le nombre de pointillé que vous souhaitez maximum :"+(dim*(dim-1)*2));
		int pointille=scan.nextInt();
		while(pointille>dim*(dim+1)*2){
			StdDraw.text(250,450, "Veuillez saisir le nombre de pointillé que vous souhaitez maximum :"+(dim*(dim-1)*2));
			pointille=scan.nextInt();
		}
		int [] A={dim,pointille};
		return A;
	}



	public int[] Coup(int dim,int tours){
		StdDraw.show(500);
		Double Y1=0.0;Double X1=0.0;Double Y2=0.0;Double X2=0.0;
		int[] A=new int[4];
		int boucle=1;
		System.out.println("Player " +((tours%2)+1));
		System.out.println("veuillez choisir votre 1er point");
		while(boucle==1){
			while(!StdDraw.mousePressed()){StdDraw.show(50);}
			X1=StdDraw.mouseX();
			Y1=StdDraw.mouseY();
			StdDraw.show(200);
			System.out.println("veuillez choisir votre 2er point");
			while(!StdDraw.mousePressed()){StdDraw.show(50);}
			X2=StdDraw.mouseX();
			Y2=StdDraw.mouseY();
			boucle=0;}
		A[0]=(int)(Math.round(X1/50)*50);
		A[1]=(int)(Math.round(Y1/50)*50);
		A[2]=(int)(Math.round(X2/50)*50);
		A[3]=(int)(Math.round(Y2/50)*50);
		return A;}

	public void Ligne(int []A){
		StdDraw.line(A[0],A[1],A[2],A[3]);
	}
	public int choixAdversaire(){
		int choix=0;
		StdDraw.clear();
		StdDraw.setXscale(0,500);
		StdDraw.setYscale(0,500);		
		StdDraw.text(250,450, "IA VS IA");
		StdDraw.text(250,350, "Player VS IA");
		StdDraw.text(250,250, "Player VS Player");
		StdDraw.text(250,100,"Veuillez choisir votre mode de jeu" );
		Double Y;
		while(choix==0){
			Y =StdDraw.mouseY();
			if(StdDraw.mousePressed()){
				if(Y>300 && Y<400){choix=2;break;}
				else if(Y>400 && Y<500){choix=3;break;}
				else if(Y>0 && Y<300){choix=1;break;}
			}}

		return choix;
	}

	public boolean rechercheAfficheur(int[] A, int [][] tab){
		for(int i=0;i<tab.length;i++){
			if(tab[i][0]==A[0]/50-1){
				if(tab[i][1]==A[1]/50-1){
					if(tab[i][2]==A[2]/50-1){
						if(tab[i][3]==A[3]/50-1){
							if(tab[i][4]==1){
								System.out.println("Coup déjà joué");
								return false;}
							else if(tab[i][4]==-1){
								Recouvrement(A);
								tab[i][4]=0;}
							else{tab[i][4]=1;
							Ligne(A);

							}
						}}}}
			if(tab[i][0]==A[2]/50-1){
				if(tab[i][1]==A[3]/50-1){
					if(tab[i][2]==A[0]/50-1){
						if(tab[i][3]==A[1]/50-1){
							if(tab[i][4]==1){
								System.out.println("Coup déjà joué");
								return false;}
							else if(tab[i][4]==-1){
								Recouvrement(A);
								tab[i][4]=0;}
							else{tab[i][4]=1;
							Ligne(A);
							}
						}}}}}
		return true;
	}


}
