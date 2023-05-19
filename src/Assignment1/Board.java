package Assignment1;
import javax.swing.JOptionPane;
public class Board {
	private char play[][]= new char[6][7];
	public Board() {
		for(int i=0; i<play.length; i++)
		{
			for (int j = 0; j < play[0].length; j++) {
				this.play[i][j]=' ';
			}
		}
	}
	public void DisplayBoard()
	{
		for (int i = 0; i < play[0].length; i++) {
			System.out.print("\t"+(i+1)+"\t");
		}
		System.out.print("\n");
		for (int i = 0; i < play.length; i++) {
			System.out.print(" "+(i+1)+"  ");
			for (int j = 0; j < play[0].length; j++) {
				System.out.print("\t"+play[i][j]+"\t");
				if(j%(play[0].length-1)!=0||j==0)
					System.out.print('|');
			}
			if(i%(play.length-1)!=0||i==0)
			{
				System.out.print("\n");
				for (int j = 0; j < play[0].length; j++) {
					System.out.print("----------------");
				}
				System.out.print("\n");
			}
		}
		System.out.print("\n\n\n");
	}
	private boolean EmptySpace(int x,int y)
	{
		boolean z=true;
		if(play[x][y]!=' ')
			z=false;
		return z;
	}
	private void Insert(char z)
	{
		int x,y;
		String M=JOptionPane.showInputDialog("Enter Row Coordinates for "+z+": ");
		String N=JOptionPane.showInputDialog("Enter Column Coordinates "+z+": ");
		if(M!=null&&N!=null)
		{
			x=Integer.parseInt(M)-1;
			y=Integer.parseInt(N)-1;
			if(x<play.length&&y<play[0].length)
			{
				if(EmptySpace(x, y))
					play[x][y]=z;
				else
				{
					System.out.println("Error,This move is played before by "+play[x][y]);
					Insert(z);
				}
			}
			else
			{
				System.out.println("The Entered Coordanites is not found");
				Insert(z);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					"Please,Enter Coordinates","Error"
					,JOptionPane.ERROR_MESSAGE);
			Insert(z);
		}
	}
	private boolean CheckHorizontal(char z)
	{
		boolean win=false;
		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[0].length; j++) {
				if(play[i][j]==z)
				{
					if(j+1<play[0].length&&j+2<play[0].length)
					{
						if(play[i][j+1]==z&&play[i][j+2]==z)
							win=true;
					}
					}
			}
		}
		return win;
	}
	private boolean CheckVertical(char z)
	{
		boolean win=false;
		for (int j = 0; j < play[0].length; j++) {
			for (int i = 0; i < play.length; i++) {
				if(play[i][j]==z)
				{
					if(i+1<play[0].length&&i+2<play[0].length)
					{
						if(play[i+1][j]==z&&play[i+2][j]==z)
						win=true;
					}
				}
			}
		}
		return win;
	}
	private boolean CheckRighDiagonal(char z)
	{
		boolean win=false;
		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[0].length; j++) {
				if(play[i][j]==z)
				{
					if(i+1<play.length&&i+2<play.length&&j+1<play[0].length&&j+2<play[0].length)
					{
						if(play[i+1][j+1]==z&&play[i+2][j+2]==z)
							win=true;
					}
				}
			}
		}
		return win;
	}
	private boolean CheckLeftDiagonal(char z)
	{
		boolean win=false;
		for (int i = 0; i < play.length; i++){
			for (int j = play[0].length-1; j>=0 ; j--) {
				if(play[i][j]==z)
				{
					if(i+1<play.length&&i+2<play.length&&j-1>=0&&j-2>=0)
					{
						if(play[i+1][j-1]==z&&play[i+2][j-2]==z)
							win=true;
					}
				}
				}
			}
		return win;
	}
	public void Play()
	{
		String player1,player2;
		player1=JOptionPane.showInputDialog("Enter Player 1 Name:");
		player2=JOptionPane.showInputDialog("Enter Player 2 Name:");
		if(player1!=null&&player2!=null)
		{
		System.out.println(player1+" is O\n"+player2+" is X\n");
		DisplayBoard();
		boolean win=false;
		for (int i = 0; i < play.length*play[0].length; i++) {
			if(i%2!=0)
			{
				char x='X';
				Insert(x);
				if(i>3)
				{
					if(CheckHorizontal(x)||CheckVertical(x)||CheckRighDiagonal(x)||CheckLeftDiagonal(x))
					{
						DisplayBoard();
						win=true;
						JOptionPane.showMessageDialog(null,player2+" Win!!");
						break;
					}
				}
			}
			else if (i%2==0)
			{
				char x='O';
				Insert(x);
				if(i>3)
				{
					if(CheckHorizontal(x)||CheckVertical(x)||CheckRighDiagonal(x)||CheckLeftDiagonal(x))
					{
						DisplayBoard();
						win=true;
						JOptionPane.showMessageDialog(null,player1+" Win!!");
						break;
					}
				}
			}
			DisplayBoard();
		}
		if(!win)
		{
			JOptionPane.showMessageDialog(null,"Draw");
			return;
		}
		return;
	}
	else
		Play();
}
	}