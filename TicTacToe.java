import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe
{
    static ArrayList<Integer>playerPostions=new ArrayList<Integer>();
    static ArrayList<Integer>cpuPostions=new ArrayList<Integer>();



    public static void main(String[] args) {
        char[][] gameboard={{' ','|',' ','|',' ',},
                {'-','+','-','+','-',},
                {' ','|',' ','|',' ',},
                {'-','+','-','+','-',},
                {' ','|',' ','|',' ',}};
                printGameBoard(gameboard);
                
                while(true)
                {
                Scanner scan =new Scanner(System.in);
                System.out.println("Enter your placement (1-9) :");
                int playerpos=scan.nextInt();

                if(playerPostions.contains(playerpos) || cpuPostions.contains(playerpos))
                {
                    System.out.println("Position Taken..!Enter a correct position..!");
                    playerpos=scan.nextInt();
                }
               // System.out.println(pos);
                placepiece(playerpos, gameboard,"player");
                String result=checkwinner();
                if(result.length()>0)
                {
                    System.out.println(result);
                    break;
                }

                Random rand=new Random();
                int cpupos=rand.nextInt(9) + 1;
                // System.out.println(cpupos);
                if(playerPostions.contains(cpupos) || cpuPostions.contains(cpupos))
                {
                    // System.out.println("Position Taken..!Enter a correct position..!");
                    cpupos=rand.nextInt(9) + 1;
                    // System.out.println(cpupos);
                }
                placepiece(cpupos, gameboard,"cpu");

                printGameBoard(gameboard);

                 result=checkwinner();
                 if(result.length()>0)
                 {
                     System.out.println(result);
                     break;
                 }
                }
               

     
    }

    public static void printGameBoard(char[][] gameboard)
    {
        for(char[] row:gameboard)
        {
            for(char c:row)
            {
                System.out.print(c);
            }
            System.out.println();
        }  

    }

    public static void placepiece(int pos,char[][] gameboard,String user)
    {
        char symbol=' ';

        if(user.equals("player"))
        {
            symbol='X';
            playerPostions.add(pos);
        }
        else if(user.equals("cpu"))
        {
            symbol='O';
            cpuPostions.add(pos);
        }

        switch(pos)
        {
            case 1:
                   gameboard[0][0]=symbol;
                   break;
            case 2:
                   gameboard[0][2]=symbol;
                   break;
            case 3:
                   gameboard[0][4]=symbol;
                   break;
            case 4:
                   gameboard[2][0]=symbol;
                   break;
            case 5:
                   gameboard[2][2]=symbol;
                   break;
            case 6:
                   gameboard[2][4]=symbol;
                   break;
            case 7:
                   gameboard[4][0]=symbol;
                   break;
            case 8:
                   gameboard[4][2]=symbol;
                   break;
            case 9:
                   gameboard[4][4]=symbol;
                   break;
            default:
            break;       

        }
        
    }

    public static String checkwinner()
    {
        List toprow=Arrays.asList(1,2,3);
        List midrow=Arrays.asList(4,5,6);
        List botrow=Arrays.asList(7,8,9);
        List topcol=Arrays.asList(1,4,7);
        List midcol=Arrays.asList(2,5,8);
        List rightcol=Arrays.asList(3,6,9);
        List cross1=Arrays.asList(1,5,9);
        List croos2=Arrays.asList(3,5,7);

        List<List> winning=new ArrayList<List>();
        winning.add(toprow);
        winning.add(midrow);
        winning.add(botrow);
        winning.add(topcol);
        winning.add(midcol);
        winning.add(rightcol);
        winning.add(cross1);
        winning.add(croos2);

        for(List l:winning)
         {
            if(playerPostions.containsAll(l))
            {
                return "Congoratulations you Won the Game...!";
            }
            else if(cpuPostions.containsAll(l))
            {
                return "sorry :(  , CPU won the game...!";
            }
            else if(playerPostions.size()+cpuPostions.size()==9)
            {
                return "No more possibilities...!!";
            }
         }


        return "";
    }
}