import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordPlayDriver
{
    public static void main(String[] args) throws  IOException
    {
        Scanner input = new Scanner(System.in);

        WordPlay game = new WordPlay(5,newTileBag(), newDictionary());

        while(!game.gameOver())
        {
            System.out.println("Score: " + game.getScore());
            System.out.println(game);

            String[] menu = {"1: Move",
                    "2: Draw Tile",
                    "3: Shuffle Tiles"};

            for(String item : menu)
                System.out.println(item);

            System.out.print("<-- ");
            int choice = Integer.parseInt(input.nextLine());
            System.out.println("--> " + menu[choice - 1].substring(3));

            if(choice == 1)
            {
                System.out.print("<-- ");
                String word = input.nextLine();
                double score = game.move(new TileWord(word));

                System.out.println("--> " + score + " points for " + word);
            }
            else if(choice == 2)
                game.draw();
            else
                game.shuffle();

            System.out.println();
        }

        System.out.println("Final Score: " + game.getScore());
    }

    public static ArrayList<Tile> newTileBag()
    {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //A,B,C,D, E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
        int[] counts = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,0,6,4,6,4,2,2,0,2,0};

        ArrayList<Tile> tileBag = new ArrayList<Tile>();

        for(int i = 0; i < letters.length(); i++)
            for(int k = 0; k < counts[i]; k++)
                tileBag.add(new Tile(letters.charAt(i) + ""));

        return tileBag;
    }

    public static ArrayList<String> newDictionary() throws IOException
    {
        ArrayList<String> dictionary = new ArrayList<String>();

        Scanner input = new Scanner(new File("words.txt"));
        while(input.hasNextLine())
            dictionary.add(input.nextLine().toLowerCase());

        return dictionary;
    }
}

