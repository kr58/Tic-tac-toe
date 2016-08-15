import java.util.*;
public class BOARD {
	char a[][]=new char[3][3];
	public BOARD()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				a[i][j]='-';
			}
		}
	}
	public void put(int x,int y,char val)
	{
		Scanner te=new Scanner(System.in);
		while(x<0 || x>=3 || y<0 || y>=3 || a[x][y]!='-')
		{
			System.out.println("Invalid coordinates. Please enter again");
			x=te.nextInt();
			y=te.nextInt();
		}
		a[x][y]=val;
	}
	public char[][] get()
	{
		return a;
	}
	public void print()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	public int checkState()
	{
		int i,j,flago=0,flagx=0;
		// Diagonal
		for(i=0;i<3;i++)
		{
			if(a[i][i]!='O') flago=1;
			if(a[i][i]!='X') flagx=1;
		}
		if(flago==0 || flagx==0)
		{
			if(flago==0) System.out.println("  'O'  Wins");
			if(flagx==0) System.out.println("  'X'  Wins");
			return 1;
		}
		flagx=0;flago=0;
		for(i=0;i<3;i++)
		{
			if(a[i][2-i]!='O') flago=1;
			if(a[i][2-i]!='X') flagx=1;
		}
		if(flago==0 || flagx==0)
		{
			if(flago==0) System.out.println("  'O'  Wins");
			if(flagx==0) System.out.println("  'X'  Wins");
			return 1;
		}
		//rows
		for(i=0;i<3;i++)
		{
			flagx=0;flago=0;
			for(j=0;j<3;j++)
			{
				if(a[i][j]!='O') flago=1;
				if(a[i][j]!='X') flagx=1;
			}
			if(flago==0 || flagx==0)
			{
				if(flago==0) System.out.println("  'O'  Wins");
				if(flagx==0) System.out.println("  'X'  Wins");
				return 1;
			}
		}
		//columns
		for(j=0;j<3;j++)
		{
			flagx=0;flago=0;
			for(i=0;i<3;i++)
			{
				if(a[i][j]!='O') flago=1;
				if(a[i][j]!='X') flagx=1;
			}
			if(flago==0 || flagx==0)
			{
				if(flago==0) System.out.println("  'O'  Wins");
				if(flagx==0) System.out.println("  'X'  Wins");
				return 1;
			}
		}
		//tie
		flagx=0;flago=0;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(a[i][j]=='-')
					flagx=1;
			}
		}
		if(flagx==0) 
		{
			System.out.println("  Tie  !!!!!!!");
			return 1;
		}
		flagx=0;
		return 0;
	}
}
