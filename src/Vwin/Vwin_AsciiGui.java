package Vwin;

import java.util.Scanner;

public class Vwin_AsciiGui {
	Vwin_Logic l=new Vwin_Logic();
	Scanner sc=new Scanner(System.in);
	
	public Vwin_AsciiGui(){
		while(true){
			System.out.println("Which Row?");
			int row=sc.nextInt();
			l.whereCircle(row);
			AsciiOutput();

		}
	}
	public void AsciiOutput(){
		int pos=0;
		while(pos<42){
			System.out.print(l.getPlace(pos));
			pos++;
			if(pos % 7 == 0){
				System.out.println("");
			}
		}
		
		
	}
	
}
