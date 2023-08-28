public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    public void forestFire ( int x, int y )
    {
        if  (x+1 < myGrid.length)
        {
            if (myGrid[x+1][y].getStatus() == FireCell.GREEN)
            {
                myGrid [x+1][y].setStatus(FireCell.BURNING);
                forestFire (x+1, y);

            }
        }
        if  (x-1 >=0)
        {
            if (myGrid[x-1][y].getStatus() == FireCell.GREEN)
            {
                myGrid [x-1][y].setStatus(FireCell.BURNING);
                forestFire (x-1, y);
            }
        }
        if  (y+1 < myGrid.length)
        {
            if (myGrid[x][y+1].getStatus() == FireCell.GREEN)
            {
                myGrid [x][y+1].setStatus(FireCell.BURNING);
                forestFire (x, y+1);
            }
        }
        if  (y-1 >=0)
        {
            if (myGrid[x][y-1].getStatus() == FireCell.GREEN)
            {
                myGrid [x][y-1].setStatus(FireCell.BURNING);
                forestFire (x, y-1);
            }
        }

    }

    public void solve()
    {
        for (int i = 0; i<myGrid.length; i++)
        {
            if (myGrid [myGrid.length-1][i].getStatus() == FireCell.GREEN)
            {
                myGrid[myGrid.length-1][i].setStatus(FireCell.BURNING);
                forestFire(myGrid.length-1, i);
            }
        }
        boolean danger = false;
        for (int i = 0; i<myGrid.length; i++)
        {
            if (myGrid[0][i].getStatus() == FireCell.BURNING)
            {
                danger = true;
                break;
            }
        }
        if (danger)
        {
            System.out.println("Onett is in trouble");
        }
        else
        {
            System.out.println ("Onett is safe");
        }
        myView.updateView(myGrid);
    }

}