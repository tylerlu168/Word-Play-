import java.util.ArrayList;

public class TileWord
{
    private ArrayList<Tile> tiles;

    /**
     * Constructs a TileWord from word by turing each
     *      character from word into a tile and adding it
     *      to tiles
     *
     * Precondition: the individual characters in word meet
     *               the precondition of Tile
     *
     * @param word
     */
    public TileWord(String word)
    {
        tiles = new ArrayList<Tile>();
        for (int i = 0; i < word.length(); i++)
        {
            tiles.add(new Tile(word.substring(i, i + 1)));
        }
    }

    /**
     * @return tiles
     */
    public ArrayList<Tile> getTiles() //get tiles method
    {
        return tiles;
    }

    /**
     * Returns a lowercase String representation of tiles
     *   Example: [D][O][G] --> dog
     *
     * @return
     */
    @Override
    public String toString()//toString/output method
    {
        String output = "";

        for (int i = 0; i < tiles.size(); i++)
        {
            output += tiles.get(i);
        }
        return output.toLowerCase();
    }
}