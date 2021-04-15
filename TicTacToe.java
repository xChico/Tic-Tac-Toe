import java.util.Scanner;
public class TicTacToe
{
   Scanner kbd= new Scanner(System.in);
   private int size;
   private String[] playersNames = new String[2];
   private String grid[][] = new String[size][size];
   int turn=0;
   public TicTacToe(int size, String[] playersNames)
   {
     this.size=size;
     this.playersNames=playersNames;   
   }
   private void initializeGrid()
   {
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         { 
            grid[i][j]= "-";
         }   
      }
   }
   public void setPlayer()
   {

      System.out.println(playersNames[(turn++)%2] + "'s your turn");
   }
   public void play()
   {
     int c=0;
     initializeGrid();

      //isFull();
      setPlayer();
      getPosition();
      toString();
      
  
     if(winner())
      {System.out.println(playersNames[c%2] + " is a winner");
     }
     else if(isFull() && !winner()){
      System.out.println("It's a tie");
      c++;
      }
   }
   public void getPosition()
   {
      System.out.println("Enter row and colum: ");
      int row = kbd.nextInt();
      int col = kbd.nextInt();
      
      isOccupied(grid, row, col);
   }
   public boolean isFull(String grid[][])
   {
      boolean full=false;
      int count3=0;
      for(int i=0; i<size; i++)
      {
         for(int j=0; j<size; j++)
         {
            if(grid[i][j]=="-")
            count3++;
             if(count3 == (size*size)) 
            full= true;
         }
         
      }
     
      return full;
   }
   public boolean isOccupied(String grid2[][], int a, int b)
   {
     boolean occupied = false; 
     if(grid2[a][b] == "O" || grid2[a][b]=="X")
     {
      System.out.println(occupied + "hmm, already taken, try again");
     }
     return occupied;
   }
   public boolean winner()
   {
     boolean winnerX=false;
     boolean winnerO=false;
      int count1;
      int count2; 
      for(int i=0; i<size; i++) 
      {
      count1=0;
      count2=0;
        if(grid[i][0] == "O")
        {count1++;}
        else if(grid[i][0]=="X")
        {count2++; }
        if(count1==size)return winnerO;
        else if(count2==size)return winnerX;
      }    
      for(int i=0; i<size; i++) 
      {
      count1=0;
      count2=0;
         for(int j=0; j<size; j++)
         {
            if(i==j)
            {
               if(grid[0][i] =="O")
                  {count1++;}
               else if(grid[0][i]=="X")
                  {count2++;}
            }
         }
          if(count1==size)return winnerO;
        else if(count2==size)return winnerX;
      }
      for(int i=0; i<size; i++)
      {  
      count1=0;
      count2=0;
         for(int j=0; j<size; j++)
         {
            if(grid[i][j] =="O")
            {count1++;}
            else if(grid[i][j] =="X")
            {count2++;}
         }
          if(count1==size)return winnerO;
        else if(count2==size)return winnerX;
   }
      for(int i=0; i<size; i++)
      {
      count1=0;
      count2=0;
      for(int j=0; i<size; j++)
      {
         if((i+j)==(size-1))
         {
            if(grid[i][j]=="O")
            {count1++;}
             else if(grid[i][j]=="X")
            { count2++;}
         }
      }
       if(count1==size)return winnerO;
        else if(count2==size)return winnerX;
      }
      
      return winnerO || winnerX;
   }
   @Override
   public String toString()
   {
      String str="";
      System.out.println("                ");
      for(int i=0; i<size; i++)
      {
         System.out.print(" ");
         for(int j=0; j<size; j++)
         {
            str= grid[i][j] + " ";
         }
         System.out.println();
         System.out.println("              ");
      }
         return str ;
   }
}