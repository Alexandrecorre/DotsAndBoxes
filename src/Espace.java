
public class Espace {
	int dim;	
	public Espace(int dim){
		StdDraw.clear();
		int rayon=2;
		int x=50;
		int y=50;
		int MinX =0;
		int MinY=0;
		int MaxX=(dim)*50;
		int MaxY=(dim)*50;
		StdDraw.setXscale(MinX,MaxX);
		StdDraw.setYscale(MinY,MaxY);
		for (int i=0;i<(dim*dim);i++){
			StdDraw.filledCircle(x,y,rayon);
			x=x+50;
			if (x>MaxX){
				x=50;
				y=y+50;}
			if (y>MaxY){
				y=0;}}
		for(int t=1;t<=dim;t++){
			String v=""+(t-1);
			StdDraw.text(0, t*50, v);
			StdDraw.text(t*50, 0, v);
		}
	}
}