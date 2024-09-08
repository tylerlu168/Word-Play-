import java.util.ArrayList;
import java.util.Collections;

public class WordPlay
{
    private ArrayList<Tile> tiles, tileBag;
    private double score;
    private ArrayList<String> dictionary;

    /**
     * Constructs a WordPlay using tileBag and dictionary.
     * Removes startingTiles random Tiles from tileBag and
     *      adds them to tiles.
     * Sets score to 0.
     *
     * @param startingTiles number of Tiles the game starts with
     * @param tileBag the bag in which new tiles are drawn from
     * @param dictionary the dictionary used to check words
     */
    public WordPlay(int startingTiles, ArrayList<Tile> tileBag, ArrayList<String> dictionary)
    {
        tiles = new ArrayList<Tile>();
        this.tileBag = tileBag;
        this.dictionary = dictionary;
        for (int i = 0; i < startingTiles; i++) //loop for starting tiles
        {
            int random = (int) (Math.random() * tileBag.size());

            tiles.add(tileBag.remove(random));
        }
        score = 0;
    }

    /**
     * @return score
     */
    public double getScore()
    {
        return score; //get score
    }

    /**
     * Performs a WordPlay move by removing all the Tiles from tiles
     *      that can be found in tileWord and increases score by an
     *      amount equal to the value of each letter in tileWord
     *      if dictionary contains tileWord; subtracts one from score
     *      if dictionary does not contain tileWord
     *
     * Precondition: the Tiles in tileWord can be found in tiles
     *
     * @param tileWord
     * @return the number of points earned
     */
    public double move(TileWord tileWord)
    {
        int pointsEarned = 0;
        if(!dictionary.contains(tileWord.toString()))
        {
            pointsEarned--; // subtracts one point if dictionary does not have entered tileWord
        }
        else
        {
            for(Tile tile: tileWord.getTiles())
            {
                pointsEarned += tile.getValue();
                tiles.remove(tile);
            }
        }
        score += pointsEarned;
        return pointsEarned;

    }

    /**
     * Removes a Tile from tileBag and add it to tiles
     */
    public void draw()
    {

        tiles.add(tileBag.get((int) (Math.random() * tileBag.size()))); //adds a random tile to tiles arraylist

    }

    /**
     * Shuffles tiles
     */
    public void shuffle()
    {
        //Collections.shuffle(tiles); <-- one way to shuffle tiles
        ArrayList<Tile> shuffle = new ArrayList<Tile>(); // <-- another way to shuffle tiles

        while(tiles.size() > 0)
        {
            int i = (int) (Math.random() * tiles.size());
            shuffle.add(tiles.remove(i));
        }
        tiles = shuffle;
    }

    /**
     * @return true if there are no more Tiles in tiles or tileBag;
     *          false otherwise
     */
    public boolean gameOver() //method depends if game is over
    {
        if(tiles.size() == 0 || tileBag.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @return a String representation of the contents of tiles
     *          Example:
     *              [D][O][G]
     */
    @Override
    public String toString() //toString/output method
    {
        String output = "";

        for (int i = 0; i < tiles.size(); i++)
        {
            output += "[";
            output += tiles.get(i);
            output += "]";
        }
        return output;
    }
}
