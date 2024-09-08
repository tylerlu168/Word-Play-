public class Tile
{
    private String letter;
    private int value;

    private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

    /**
     * Constructs a tile using letter.  The value of the tile
     *      can be derived from using letters and values.
     *
     * Precondition: letter.length() == 1; letters contains letter
     * Postcondition: letter is uppercase
     *
     * @param letter
     */
    public Tile(String letter)
    {
        this.letter = letter.toUpperCase();
        int index = letters.indexOf(this.letter);
        this.value = values[index];
    }

    /**
     * @return letter
     */
    public String getLetter()
    {
        return letter;
    }

    /**
     * @return value
     */
    public int getValue()
    {
        return this.value; //gets value of letter
    }

    /**
     * Returns true if this tile is equal to the other tile.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o)
    {
        Tile other = (Tile) o;
        return letter.equals(other.letter) && value == other.value;
    }

    /**
     * @return [letter]
     */
    public String toString()//toString/output method
    {
        return letter;
    }
}
