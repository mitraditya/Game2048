import java.util.Random;
public class Game {
     
   protected int[][] tile;
   protected int score=0;
   private Random r=new Random();
           
   public Game()
   {
       tile =new int[4][4];
   }
   
   public void printarray() 
   {
       for(int i=0;i<4;i++)
       {for(int j=0;j<4;j++)
       { System.out.print(tile[i][j]+"\t");
           }
       System.out.println();
       }
   }
   public void randomchoose()
   {
       int p,q;
       int ran=r.nextInt(10);
       int choice=2;
       if(ran==0)
       choice=4;
       for(int i=0;;i++)
       {p=((int)(Math.random()*10))%4;
        q=((int)(Math.random()*10))%4;
        if(tile[p][q]==0)
        {tile[p][q]=choice;
         break;}
       }
   }
   
   public void pushup()
   {
       for(int j=0;j<4;j++)
       {boolean[] alreadycombined={false,false,false,false};
        for(int i=1;i<4;i++)
       {if(tile[i][j]!=0)
       { int k=tile[i][j];
         int x=i-1;
         while((x>=0)&&(tile[x][j]==0))
         {x--;}
         if(x==-1)
         {tile[i][j]=0; 
          tile[0][j]=k;
         }
         else if(tile[x][j]!=k)
         {   tile[i][j]=0;
             tile[x+1][j]=k;
         }
         else{
             if(alreadycombined[x])
             {   tile[i][j]=0;
                 tile[x+1][j]=k;
               }
             else{
               tile[i][j]=0;
               tile[x][j]*=2;
               score += tile[x][j];
               alreadycombined[x]=true;
               }
          }     
         }
        }
       }
      }
   public void pushdown()
   {
       for(int j=0;j<4;j++)
       {boolean[] alreadycombined={false,false,false,false};
        for(int i=2;i>=0;i--)
       {if(tile[i][j]!=0)
       { int k=tile[i][j];
         int x=i+1;
         while((x<=3)&&(tile[x][j]==0))
         {x++;}
         if(x==4)
         {tile[i][j]=0; 
          tile[3][j]=k;
         }
         else if(tile[x][j]!=k)
         {tile[i][j]=0;
          tile[x-1][j]=k;
         }
         else{
             if(alreadycombined[x])
             {tile[i][j]=0;
              tile[x-1][j]=k;}
             else{
               tile[i][j]=0;
               tile[x][j]*=2;
               score += tile[x][j];
               alreadycombined[x]=true;
               }
          }     
         }
        }
       }
      }  
   
   public void pushleft() 
   {
       for(int i=0;i<4;i++)
       {boolean[] alreadycombined={false,false,false,false};
        for(int j=1;j<4;j++)
       {if(tile[i][j]!=0)
       { int k=tile[i][j];
         int x=j-1;
         while((x>=0)&&(tile[i][x]==0))
         {x--;}
         if(x==-1)
         {tile[i][j]=0;
          tile[i][0]=k;;
         }
         else if(tile[i][x]!=k)
         {tile[i][j]=0;
          tile[i][x+1]=k; 
         }
         else{
             if(alreadycombined[x])
             {tile[i][j]=0;
              tile[i][x+1]=k;}
             else{
               tile[i][j]=0;
               tile[i][x]*=2;
               score += tile[x][j];
               alreadycombined[x]=true;}
          }     
         }
        }
       }
      }  
   
   public void pushright() 
   {
       for(int i=0;i<4;i++)
       {boolean[] alreadycombined={false,false,false,false};
        for(int j=2;j>=0;j--)
       {if(tile[i][j]!=0)
       { int k=tile[i][j];
         int x=j+1;
         while((x<=3)&&(tile[i][x]==0))
         {x++;}
         if(x==4)
         {tile[i][j]=0;
          tile[i][3]=k;
         }
         else if(tile[i][x]!=k)
         {tile[i][j]=0;
          tile[i][x-1]=k;
         }
         else{
             if(alreadycombined[x])
             {tile[i][j]=0;
              tile[i][x-1]=k;}
             else{
               tile[i][j]=0;
               tile[i][x]*=2;
               score += tile[x][j];
               alreadycombined[x]=true;}
          }     
         }
        }
       }
      }  
   
   public boolean checkfor2048()
   {
       for(int i=0;i<4;i++)
       {for(int j=0;j<4;j++)
        { if(tile[i][j]==2048)
         return true;
        }
       }
      return false;
   }
   
public boolean gameover()
{
    for(int i=0;i<4;i++)
       {for(int j=0;j<4;j++)
        { if(tile[i][j]==0)
            return false;
         }
       }
     return true;
}
}
