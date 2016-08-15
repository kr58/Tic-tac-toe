import java.util.*;
public class GAME {
	public void randomfun(char[][] a,int[] te)
	{
		Random r=new Random();
		int arr[][]=new int[9][2];
		int size=0,z;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]=='-')
				{
					arr[size][0]=i;
					arr[size][1]=j;
					++size;
					}
				}
			}
		z=r.nextInt(size);
		te[0]=arr[z][0];
		te[1]=arr[z][1];
	}
	public int AIwin(char[][] a,int[] tr)
	{
		int i,j,cx=0,co=0,dx=0,dy=0,d=0,flag=0;
		//ROWS
		for(i=0;i<3;i++)
		{
			cx=0;co=0;d=0;
			for(j=0;j<3;j++)
			{
				if(a[i][j]=='X') ++cx;
				if(a[i][j]=='-') {	++d;dx=i;dy=j;	}
			}
			if(d==1 && cx==2){	flag=1;tr[0]=dx;tr[1]=dy;	}
		}
		if(flag==1) return 1;
		//COLUMNS
		for(j=0;j<3;j++)
		{
			cx=0;co=0;d=0;
			for(i=0;i<3;i++)
			{
				if(a[i][j]=='X') ++cx;
				if(a[i][j]=='-') {	++d;dx=i;dy=j;	}
			}
			if(d==1 && (cx==2)) {	flag=1;tr[0]=dx;tr[1]=dy;	}
		}
		if(flag==1) return 1;
		//DIAGONALS
		cx=0;co=0;d=0;
		for(i=0;i<3;i++)
		{
			if(a[i][i]=='X') ++cx;
			if(a[i][i]=='-') {	++d;dx=i;dy=i;	}
		}
		if(d==1 && (cx==2)) {	flag=1;tr[0]=dx;tr[1]=dy;	}
		if(flag==1) return 1;
		cx=0;co=0;d=0;
		for(i=0;i<3;i++)
		{
			if(a[i][2-i]=='X') ++cx;
			if(a[i][2-i]=='-'){	++d;dx=i;dy=2-i;	}
		}
		if(d==1 && (cx==2)){	flag=1; tr[0]=dx;tr[1]=dy;	}
		if(flag==1) return 1;
		return 0;
	}
	public int AIsaving(char[][] a,int[] tr)
	{
		int i,j,cx=0,co=0,dx=0,dy=0,d=0,flag=0;
		//ROWS
		for(i=0;i<3;i++)
		{
			cx=0;co=0;d=0;
			for(j=0;j<3;j++)
			{
				if(a[i][j]=='O') ++co;
				if(a[i][j]=='-') {	++d;dx=i;dy=j;	}
			}
			if(d==1 && co==2){	flag=1;tr[0]=dx;tr[1]=dy;	}
		}
		if(flag==1) return 1;
		//COLUMNS
		for(j=0;j<3;j++)
		{
			cx=0;co=0;d=0;
			for(i=0;i<3;i++)
			{
				if(a[i][j]=='O') ++co;
				if(a[i][j]=='-') {	++d;dx=i;dy=j;	}
			}
			if(d==1 && (co==2)) {	flag=1;tr[0]=dx;tr[1]=dy;	}
		}
		if(flag==1) return 1;
		//DIAGONALS
		cx=0;co=0;d=0;
		for(i=0;i<3;i++)
		{
			if(a[i][i]=='O') ++co;
			if(a[i][i]=='-') {	++d;dx=i;dy=i;	}
		}
		if(d==1 && (co==2)) {	flag=1;tr[0]=dx;tr[1]=dy;	}
		if(flag==1) return 1;
		cx=0;co=0;d=0;
		for(i=0;i<3;i++)
		{
			if(a[i][2-i]=='O') ++co;
			if(a[i][2-i]=='-'){	++d;dx=i;dy=2-i;	}
		}
		if(d==1 && (co==2)){	flag=1; tr[0]=dx;tr[1]=dy;	}
		if(flag==1) return 1;
		return 0;
	}
	public void useranduser()
	{
		System.out.println("Player 1 (O) and Player 2 (X)");
		Scanner s=new Scanner(System.in);
		int x,y,c,size=0;
		BOARD b = new BOARD();
		b.print();
		while(true)
		{
			System.out.println("Player 1 turn");
			x=s.nextInt();
			y=s.nextInt();
			b.put(x,y,'O');
			b.print();
			c=b.checkState();
			if(c==1) break;
			System.out.println("Player 2 turn");
			x=s.nextInt();
			y=s.nextInt();
			b.put(x,y,'X');
			b.print();
			c=b.checkState();
			if(c==1) break;
		}
		s.close();
	}
	public void userandcomp()
	{
		System.out.print("When do you want to play First or second : ");
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println("Player 1 start with 'O' and Player 2 start with 'X'");
		int x,y,c,z;
		BOARD b = new BOARD();
		b.print();
		if(str.length()==5)
		{
			while(true)
			{
				System.out.println("User input");
				x=s.nextInt();y=s.nextInt();
				int[] te=new int[2];
				b.put(x,y,'O');
				b.print();
				c=b.checkState();
				if(c==1) break;
				randomfun(b.a,te);
				b.put(te[0],te[1],'X');
				System.out.println("After Computer turn:");
				b.print();
				c=b.checkState();
				if(c==1) break; 
			}
		}
		else 
		{
			while(true)
			{
				int[] te=new int[2];
				randomfun(b.a,te);
				b.put(te[0],te[1],'O');
				System.out.println("After Computer turn:");
				b.print();
				c=b.checkState();
				if(c==1) break;
				System.out.println("User input");
				x=s.nextInt();y=s.nextInt();
				b.put(x,y,'X');
				b.print();
				c=b.checkState();
				if(c==1) break; 
			}	
		}
	}
	public void compandAI()
	{
		Scanner s=new Scanner(System.in);
		BOARD b=new BOARD();
		int x,y,c;
		b.print();
		while(true)
		{
			System.out.println("Computer :");
			int[] te=new int[2];
			randomfun(b.a,te);
			b.put(te[0],te[1],'O');
			System.out.println("After Computer turn:");
			b.print();
			c=b.checkState();
			if(c==1) break;
			c=AIwin(b.a,te);
			if(c==0)
			{
				c=AIsaving(b.a,te);int[][] temp=new int[4][4];int tempsize=0;
				if(c==0 && b.a[1][1]=='-') b.put(1,1,'X');
				else if(c==0)
				{
					if(b.a[0][0]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=0;++tempsize;}
					if(b.a[0][2]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=2;++tempsize;}
					if(b.a[2][0]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=0;++tempsize;}
					if(b.a[2][2]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=2;++tempsize;}
					if(tempsize>0)
					{
						Random r=new Random();
						int z=r.nextInt(tempsize);
						b.put(temp[z][0],temp[z][1],'X');
					}
					else
					{
						randomfun(b.a,te);
						b.put(te[0],te[1],'X');	
					}
				}
				else b.put(te[0],te[1],'X');
			}
			else b.put(te[0],te[1],'X');
			System.out.println("After AI turn:");
			b.print();
			c=b.checkState();
			if(c==1) break; 
		}
	}
	public void userandAI()
	{
		System.out.println("When do you want to play firts or second : ");
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println("USer starts with 'O' and AI start with 'X' ");		
		BOARD b=new BOARD();
		int x,y,c,flag=0;
		char val;
		b.print();
		if(str.length()==5)
		{
			while(true)
			{
				int[] te=new int[2];
				System.out.println("User turn:");
				x=s.nextInt();
				y=s.nextInt();
				if(flag==2)
				{
					if((x==0 && y==0) || (x==2 && y==2) || (x==0 && y==2) || (x==2 && y==0)) flag=0;
					else  flag=1;	
				}
				else
				{
					if((x==0 && y==0) || (x==2 && y==2) || (x==0 && y==2) || (x==2 && y==0)) flag=1;
					else if(x==1 && y==1) flag=2;
					else flag=0;
				}
				val='O';
				b.put(x,y,val);
				System.out.println("After User turn:");
				b.print();
				c=b.checkState();
				if(c==1) break;
				c=AIwin(b.a,te);val='X';
				if(c==0)
				{
				 	c=AIsaving(b.a,te);int[][] temp=new int[4][4];int tempsize=0;
					if(c==0 && b.a[1][1]=='-') b.put(1,1,'X');
					else if(c==0)
					{
						if(flag==0 || flag==2)
						{
							if(b.a[0][0]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=0;++tempsize;}
							if(b.a[0][2]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=2;++tempsize;}
							if(b.a[2][0]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=0;++tempsize;}
							if(b.a[2][2]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=2;++tempsize;}
							if(tempsize>0)
							{
								Random r=new Random();
								int z=r.nextInt(tempsize);
								b.put(temp[z][0],temp[z][1],val);
							}
						}
						else 
						{
							if(b.a[0][1]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=1;++tempsize;}
							if(b.a[1][0]=='-'){ temp[tempsize][0]=1;temp[tempsize][1]=0;++tempsize;}
							if(b.a[1][2]=='-'){ temp[tempsize][0]=1;temp[tempsize][1]=2;++tempsize;}
							if(b.a[2][1]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=1;++tempsize;}
							if(tempsize>0)
							{
								Random r=new Random();
								int z=r.nextInt(tempsize);
								b.put(temp[z][0],temp[z][1],val);
							}	
						}
					}
					else b.put(te[0],te[1],val);
				}
				else b.put(te[0],te[1],val);
				System.out.println("After AI turn:");
				b.print();
				c=b.checkState();
				if(c==1) break;
			}
		}
		else
		{
			flag=1;int z,chk=0;val='X';
			int[][] temp=new int[5][4];int tempsize=0;
			if(b.a[0][0]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=0;++tempsize;}
			if(b.a[0][2]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=2;++tempsize;}
			if(b.a[2][0]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=0;++tempsize;}
			if(b.a[2][2]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=2;++tempsize;}
			if(b.a[1][1]=='-'){ temp[tempsize][0]=1;temp[tempsize][1]=1;++tempsize;}
			Random r=new Random();
			z=r.nextInt(tempsize);
			b.put(temp[z][0],temp[z][1],val);
			if(temp[z][0]==1 && temp[z][1]==1) chk=1;
			System.out.println("After AI turn:");
			b.print();
			System.out.println("User input");
			x=s.nextInt();
			y=s.nextInt();
			if((x==0 && y==0) || (x==2 && y==2) || (x==0 && y==2) || (x==2 && y==0)) flag=1;
			else if(x==1 && y==1) flag=0;
			else flag=2;
			val='O';
			b.put(x,y,val);
			System.out.println("After User turn:");
			b.print();
			if(flag==0 && chk==0)
			{
				val='X';
				if(temp[z][0]==0 && temp[z][1]==0) b.put(2,2,val);
				else if(temp[z][0]==2 && temp[z][1]==2) b.put(0,0,val);
				else if(temp[z][0]==0 && temp[z][1]==2) b.put(2,0,val);
				else if(temp[z][0]==2 && temp[z][1]==0) b.put(0,2,val);
				System.out.println("After AI turn:");
				b.print();
				System.out.println("User input");
				x=s.nextInt();
				y=s.nextInt();
				if((x==0 && y==0) || (x==2 && y==2) || (x==0 && y==2) || (x==2 && y==0)) flag=1;
				else if(x==1 && y==1) flag=0;
				else flag=2;
				val='O';
				b.put(x,y,val);
				System.out.println("After User turn:");
				b.print();
			}
			else if(flag==2 && chk==0)
			{
				val='X';
				b.put(1,1,val);
				b.print();
				flag=1;
				System.out.println("User input");
				x=s.nextInt();
				y=s.nextInt();
				val='O';
				b.put(x,y,val);
				System.out.println("After User turn:");
				b.print();
			}
			if(chk==1)
			{
				if(flag==2) flag=1;
			}
			while(true)
			{		
				int[] te=new int[2];tempsize=0;
				c=AIwin(b.a,te);
				if(c==0)
				{
				 	c=AIsaving(b.a,te);
					if(c==0)
					{
						if(flag==1)
						{
							if(b.a[0][0]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=0;++tempsize;}
							if(b.a[0][2]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=2;++tempsize;}
							if(b.a[2][0]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=0;++tempsize;}
							if(b.a[2][2]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=2;++tempsize;}
							if(tempsize>0)
							{
								z=r.nextInt(tempsize);
								b.put(temp[z][0],temp[z][1],'X');
							}
						}
						else if(flag==2 && c==0 && b.a[1][1]=='-') b.put(1,1,'X');
						else 
						{
							if(b.a[0][1]=='-'){ temp[tempsize][0]=0;temp[tempsize][1]=1;++tempsize;}
							if(b.a[1][0]=='-'){ temp[tempsize][0]=1;temp[tempsize][1]=0;++tempsize;}
							if(b.a[1][2]=='-'){ temp[tempsize][0]=1;temp[tempsize][1]=2;++tempsize;}
							if(b.a[2][1]=='-'){ temp[tempsize][0]=2;temp[tempsize][1]=1;++tempsize;}
							if(tempsize>0)
							{
								z=r.nextInt(tempsize);
								b.put(temp[z][0],temp[z][1],'X');
							}	
						}
					}
					else b.put(te[0],te[1],'X');
				}
				else b.put(te[0],te[1],'X');
				System.out.println("After AI turn:");
				b.print();
				c=b.checkState();
				if(c==1) break;
				x=s.nextInt();
				y=s.nextInt();
				{
					if((x==0 && y==0) || (x==2 && y==2) || (x==0 && y==2) || (x==2 && y==0)) flag=1;
					else if(x==1 && y==1) flag=0;
					else flag=1;
				}
				b.put(x,y,'O');
				System.out.println("After User turn:");
				b.print();
				c=b.checkState();
				if(c==1) break;	
			}
		}
	}
	public static void main(String[] args) //throws IOException 
	{
		// TODO Auto-generated method stub
		GAME g= new GAME();
		System.out.println("1. Game between user and user.");
		System.out.println("2. Game between user and computer");
		System.out.println("3. Game between computer and AI");
		System.out.println("4. Game between AI and user");
		System.out.println("Enter your choice");
		int ch;Scanner s=new Scanner(System.in);
		ch=s.nextInt();
		if(ch==1) g.useranduser();
		else if(ch==2) g.userandcomp();
		else if(ch==3) g.compandAI();
		else if(ch==4) g.userandAI();
		else System.out.println("Invalid Choice");  
	}
}
