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
		if(place[row]!=0){
			System.out.println("Error, row is full");
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
	private void setCircle(int position, int color){
		place[position]=color;
		System.out.println("Setting Circle on: " + position +" color: "+ color);
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
	public int getPlace(int pos){
		return place[pos];
	}
	private void firstMove(){
		this.color=1;
	}
	
}
