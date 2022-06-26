package vttp2022.conwaygol;

public class Conway {
    
    // properties
    
    // constructors

    // methods
    public int countNeighbours (int iPos, int jPos, char[][] grid) {
        int startI = iPos - 1;
        int startJ = jPos - 1;
        int count = 0;
        // int round = 0;

        for (int i = startI; i < iPos + 2; i++) {

            if ((i < 0) || (i >= grid.length))
                continue;
            

            for (int j = startJ; j < jPos + 2; j++) {
                if ((j < 0) || (j >= grid[i].length))
                    continue;
                
                // round++;
                // System.out.println("This is round = " + round);
                // System.out.println("This is iPos = " + iPos);
                // System.out.println("This is jPos = " + jPos);
                // System.out.println("This is i = " + i);
                // System.out.println("This is j = " + j);
                // System.out.println();

                if (grid[i][j] == '*') 
                {
                    count++;
                }
                
            }
        }

        if (grid[iPos][jPos] == '*') // if the own cell is populated, then remove one due to double counting
            count--;

        return count;
    }

    public void nextGen (char[][] grid) throws InterruptedException {
        int gen = 1;
        while (true) {
            char[][] newGrid = new char[grid.length][grid[0].length];

            // for (int i = 0; i < grid.length; i++) {
            //     for (int j = 0; j < grid[i].length; j++) {
            //         System.out.print(grid[i][j]);
            //     }
            //     System.out.println();
            // }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int numNeighbours = countNeighbours(i, j, grid);
                    // System.out.print(numNeighbours);
                    if (numNeighbours == 2) {
                        if (grid[i][j] == '*') {
                            newGrid[i][j] = '*';
                        } else 
                        {
                            newGrid[i][j] = ' ';
                        }
                        System.out.print(newGrid[i][j]);
                    } 
                    else if (numNeighbours == 3) 
                    {
                        newGrid[i][j] = '*';
                        System.out.print(newGrid[i][j]);
                    }
                    else if (2 > numNeighbours || numNeighbours > 3)
                    {
                        newGrid[i][j] = ' ';
                        System.out.print(newGrid[i][j]);
                    } 
                }
                System.out.println();
            }

            grid = newGrid;
            gen++;
            Thread.sleep(1500);
            System.out.println();
            System.out.printf("This is generation %d -------------------------------------------\n" , gen);
            System.out.println();

        }
    }
}
