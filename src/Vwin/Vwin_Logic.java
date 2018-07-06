package Vwin;

import java.util.Arrays;

public class Vwin_Logic {
	/*
	 * 0 : Empty
	 * 1 : Red
	 * 2 : Yellow
	 */
	int[] place=new int[42];
	int color=0;
	
	public Vwin_Logic(){
		Arrays.fill(place, 0);
		this.color=1;
	}
	public void whereCircle(int row){
		if(!(correctInput(row))){
			return;
		}
		
		int position=row;
		while(true){
			if(position<=34){
				if(place[position+7]==0){
					position+=7;
				}
				else{
					setCircle(position, color);
					break;
				}
			}
			else{
				setCircle(position, color);
				break;
			}
		}
		
	}
	private boolean correctInput(int row){
		
		if(row<0 || row>6){
			System.out.println("Error, number between 0 and 6 pls");
			return false;
		}
		if(place[row]!=0){
			System.out.println("Error, row is full");
			return false;
		}
		return true;
	}
	private void setCircle(int position, int color){
		place[position]=color;
		System.out.println("Setting Circle on: " + position +" color: "+ color);
		testWinningPosition();
		changeColor(color);
	}
	private void changeColor(int color){
		if(color==1){
			this.color=2;
			System.out.println("Changing Color to Yellow");
		}else if(color==2){
			this.color=1;
			System.out.println("Changing Color to Red");
		}
	}
	private void testWinningPosition(){
		System.out.println("Test if anyone won...");
		int plus=0;
		int[] nrTest=new int[4];
		while(true){
			if(plus>38) break;
			if((plus+3) % 7 == 0){
				plus+=4;
			}
			else{
				boolean won=true;
	
				nrTest[0]=getPlace(0+plus);
				nrTest[1]=getPlace(1+plus);
				nrTest[2]=getPlace(2+plus);
				nrTest[3]=getPlace(3+plus);
				plus++;
	
				int first = nrTest[0];
				System.out.println("plus " + plus);
				System.out.println("first " + first);
				System.out.println(nrTest[0] +""+ nrTest[1] +""+ nrTest[2] +""+ nrTest[3]);
				for(int i = 1; i < 4 && won; i++)
				{
				  if (nrTest[i] != first) won = false;
				}
				if (won && first != 0) winMessage();
			}
		}
		
	}

	
	public int getPlace(int pos){
		return place[pos];
	}
	private void firstMove(){
		this.color=1;
	}
	private void winMessage(){
		System.out.println("********************************************");
		System.out.println("YAY");
		System.out.println("WIN");
		System.out.println("r/wholesomesyuri ");
		System.out.println("********************************************");

	}
	
}
