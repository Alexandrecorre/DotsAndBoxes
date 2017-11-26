import java.util.Scanner;

public class Console {
	Scanner scan=new Scanner(System.in);

	public String[] Recouvrement(int[] A,String tab[],int dim){
		int max;
		if(A[0]==A[2]){
			max = Math.max(A[1],A[3]);
			tab[2*dim-max*2]=tab[2*dim-max*2].substring(0,8+A[0]*5)+" "+tab[2*dim-max*2].substring(9+A[0]*5);}
		else{
			max = Math.min(A[0],A[2]);
			tab[2*dim-1-A[1]*2]=tab[2*dim-1-A[1]*2].substring(0,2+max*5+1)+"    "+tab[2*dim-1-A[1]*2].substring(2+5*(max+1));}

		return tab;

	}

	public int[] demarrageConsole(int dim){
		int[] Choix=new int [2];
		System.out.println("Veuillez saisir le nombre de pointillés souhaité maximum :" +(dim*(dim-1)*2));
		Choix[0]=scan.nextInt();
		while(Choix[0]>dim*(dim+1)*2){
			System.out.println("Veuillez saisir le nombre de pointillés souhaité maximum :" +(dim*(dim+1)*2));
			Choix[0]=scan.nextInt();
		}

		String ligne=scan.nextLine();
		while(!ligne.equals("IA vs IA")||!ligne.equals("ia vs ia")
				||!ligne.equals("Player vs IA")||!ligne.equals("player vs ia")
				||!ligne.equals("Player vs Player")||!ligne.equals("player vs player")){
			System.out.println("Veuillez choisir votre mode de jeu");
			System.out.println("IA vs IA");
			System.out.println("Player vs IA");
			System.out.println("Player vs Player");
			ligne=scan.nextLine();
			if(ligne.equals("IA vs IA")||ligne.equals("ia vs ia")
					||ligne.equals("Player vs IA")||ligne.equals("player vs ia")
					||ligne.equals("Player vs Player")||ligne.equals("player vs player")){
				break;
			}}
		if(ligne.equals("IA vs IA")||ligne.equals("ia vs ia")){
			Choix[1]=3;			
		}
		else if(ligne.equals("Player vs IA")||ligne.equals("player vs ia")){
			Choix[1]=2;			
		}
		else if(ligne.equals("Player vs Player")||ligne.equals("player vs player")){
			Choix[1]=1;			
		}
		return Choix;

	}

	public String[] randomPointille(int n, int [][] tab,String [] tableau,int dim){
		for(int i=0;i<n;i++){
			int a=(int)(Math.random()*tab.length);
			if(tab[a][4]==0){tab[a][4]=-1;
			tableau=Pointille(tab[a],tableau,dim);}
			else{ i--;}}
		return tableau;		
	}

	public void randomIA(int[][] tab,String[] tableau,int dim){
		int[] A=new int[4];
		int a=(int)(Math.random()*tab.length);
		while(tab[a][4]==1){a=(int)(Math.random()*tab.length);}
		if(tab[a][4]==0){
			tab[a][4]=1;
			A[0]=tab[a][0];A[1]=tab[a][1];A[2]=tab[a][2];A[3]=tab[a][3];
			ligneTableau(A,tableau,dim);
		}
		else{
			tab[a][4]=0;
			A[0]=tab[a][0];A[1]=tab[a][1];A[2]=tab[a][2];A[3]=tab[a][3];
			Recouvrement(A,tableau,dim);	
		}
	}




	public String[] Pointille(int [] A,String [] tab,int dim){
		int max;
		if(A[0]==A[2]){
			max = Math.max(A[1],A[3]);
			tab[2*dim-max*2]=tab[2*dim-max*2].substring(0,8+A[0]*5)+"."+tab[2*dim-max*2].substring(9+A[0]*5);}
		else{
			max = Math.min(A[0],A[2]);
			tab[2*dim-1-A[1]*2]=tab[2*dim-1-A[1]*2].substring(0,2+max*5+1)+"...."+tab[2*dim-1-A[1]*2].substring(2+5*(max+1));}

		return tab;

	}

	public int IfConsole(){
		System.out.println("taper 5 pour 5x5");
		System.out.println("taper 4 pour 4x4");
		System.out.println("taper 3 pour 3x3");
		System.out.println("taper 2 pour 2x2");
		System.out.println("veuillez saisir la dimension que vous souhaitez :");
		int dim=scan.nextInt();
		while(dim!=5 || dim!=4 || dim!=3 ||dim!=2){
			if(dim==5 || dim==4||dim==3 || dim==2)break;
			System.out.println("veuillez saisir la dimension que vous souhaitez :");
			dim=scan.nextInt();}
		return dim+1;}

	public void afficheTableau(String[] tab){
		for(int i=0;i<tab.length-1;i++){
			System.out.println(tab[i]);System.out.println();
		}
		System.out.println();System.out.println(tab[tab.length-1]);
	}	


	public String[] ligneTableau(int[] A,String tab[],int dim){
		int max;
		if(A[0]==A[2]){
			max = Math.max(A[1],A[3]);
			tab[2*dim-max*2]=tab[2*dim-max*2].substring(0,8+A[0]*5)+"|"+tab[2*dim-max*2].substring(9+A[0]*5);}
		else{
			max = Math.min(A[0],A[2]);
			tab[2*dim-1-A[1]*2]=tab[2*dim-1-A[1]*2].substring(0,2+max*5+1)+"----"+tab[2*dim-1-A[1]*2].substring(2+5*(max+1));}

		return tab;}

	public String[] consoleTableau(int dim){
		String [] tab=new String[2*dim+1];
		int nbligne=dim-1;
		for(int i=1;i<=2*dim-1;i++){
			if(i%2==1){
				String line=nbligne+"	O";
				nbligne=nbligne-1;
				for(int j=0;j<dim-1;j++){
					line=line+"    O";}
				tab[i]=line;
			}
			else{
				String line="         ";
				for(int j=0;j<dim-1;j++){
					line=line+"     ";}
				tab[i]=line;
			}
			System.out.println(tab[i]);System.out.println();}
		tab[2*dim]=" 	0";
		for(int t=1;t<dim;t++){
			tab[2*dim]=tab[2*dim]+"    "+t;}
		System.out.println();
		System.out.println(tab[2*dim]);
		return tab;}

	public void rechercheConsole(int[] A, int [][] tab,int x,String tableau[],int dim){
		for(int i=0;i<tab.length;i++){
			if(tab[i][0]==A[0]){
				if(tab[i][1]==A[1]){
					if(tab[i][2]==A[2]){
						if(tab[i][3]==A[3]){
							if(tab[i][4]==1){
								System.out.println("Coup déja joué");}
							else if(tab[i][4]==-1){
								Recouvrement(A,tableau,dim);
								tab[i][4]=0;}
							else{tab[i][4]=1;
							ligneTableau(A,tableau,dim);
							x=x+1;
							}}}}}
			if(tab[i][0]==A[2]){
				if(tab[i][1]==A[3]){
					if(tab[i][2]==A[0]){
						if(tab[i][3]==A[1]){
							if(tab[i][4]==1){
								System.out.println("Coup déja joué");}
							else if(tab[i][4]==-1){
								Recouvrement(A,tableau,dim);
								tab[i][4]=0;}
							else{tab[i][4]=1;
							ligneTableau(A,tableau,dim);
							x=x+1;
							}
						}}}}}}


	public int carreConsole(int [][] tab,int dim,int tours,int player1,int player2,int[] Carre,String[] tableau){
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
						tableau[2*dim-(y+1)*2]=tableau[2*dim-(y+1)*2].substring(0,11+x*5)+ (player+1)+tableau[2*dim-(y+1)*2].substring(11+x*5+1);
						nbCarre=nbCarre+1;

					}}}}
		if(nbCarre!=0){tours=tours-1;}
		return tours;
	}
}
