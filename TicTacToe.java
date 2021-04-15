//Miriam Chico
//CS 304 Data Structures
//Homework 1
import java.util.Scanner;
public class TicTacToe
{
   Scanner kbd = new Scanner(System.in);
   private int size;
   private String[] playersNames = new String[2];
   private char[][] grid;
   private int turn = 0;
   int row=0;
   int col=0;
   
   public TicTacToe(int size, String[] playersNames)
   {
     this.size=size;
     this.playersNames[0] = playersNames[0];
     this.playersNames[1] = playersNames[1];
     initializeGrid();

   }
   private void initializeGrid()
   {
      grid = new char[size][size];
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         {
            grid[i][j]= '-';
         }
      }
   }
   public void setPlayer()
   {
      System.out.println(playersNames[(turn++)%2] + "'s your turn");   
   }
   public void play()
   {
      setPlayer();
      getPosition();
      System.out.print(this.toString());
      if( isFull())
      {
         System.out.println( "It's a tie");
      }
      else if(winner())
      {
         System.out.println(playersNames[turn++%2] + " is a winner");
      } 
   }
   public void getPosition()
   {
     System.out.println("enter row and col: ");
     row = kbd.nextInt();
     col = kbd.nextInt();
     if(isOccupied()==false)
      {
         if(this.turn%2 ==0)
         {
            grid[row-1][col-1]='X';
         }
            else 
         {
            grid[row-1][col-1]='O'; 
         }
      }
   }
   public boolean isFull()
   {
     boolean full = true;
     for(int i=0; i<size; i++)
     {
      for(int j=0; j<size; j++)
      {
         if(grid[i][j]=='-')
         {
            full=false;
         }
      }
     } 
      return full;    
   }
   public boolean isOccupied()
   {
      boolean occupied= false;
      if(grid[row-1][col-1] =='O' || grid[row-1][col-1] == 'X')
      { 
         System.out.println( "hmm, already taken, try again");
         getPosition();
         occupied= true;
      }
      return occupied;
   }
   public boolean winner()
   {
      boolean win=false;
    
      int count5=0;
      int count7=0;
      int count8=0;
      int count6=0;
      for(int i=0; i<size; i++)
      {
         int count1=0;
         int count2=0;
         for(int j=0; j<size; j++)
         {
            if(grid[i][j]=='O')
               count1++;
            else if(grid[i][j]=='X')
               count2++;    
         } 
         if(count1==size) 
            win=true;
         else if(count2==size)
            win=true;
      }
      for(int i=0; i<size; i++)
      {
         int count3=0;
         int count4=0;
         for(int j=0; j<size; j++)
         {
            if(grid[j][i] == 'O')
               count3++;
            if(grid[j][i] == 'X')
               count4++;     
         }
         if(count3==size) 
         win=true;
         else if(count4==size)
         win=true;     
      }
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         {
            if(i==j)
            {
               if(grid[i][j]=='O')
                  count5++;
               else if(grid[i][j] == 'X')
                  count6++;
            }
         }
      }
      if(count5==size)
         win=true;
      else if(count6==size)
         win=true;
   
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         {
            if((i+j)==(size-1))
            {
               if(grid[i][j]=='O')
                  count7++;
               else if(grid[i][j]=='X')
                  count8++;
            }
         }  
      }
      if(count7==size)
         win=true;
      else if(count8==size)
         win=true;
      return win;
      
   }
   @Override
   public String toString()
   {
      String str=" ";
      for(int i=0; i<size; i++)
         {
            for(int j=0; j<size; j++)
            {
               str+=grid[i][j] + " " ;
            }
            str+="\n ";
         }
      return str;
   }
}