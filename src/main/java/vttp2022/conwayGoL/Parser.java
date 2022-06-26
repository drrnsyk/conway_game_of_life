package vttp2022.conwaygol;

import java.io.IOException;

public class Parser {
    
    // properties
    Repository parseRepo;
    String line = "";
    Integer maxRows = 0;
    Integer maxCols = 0;
    Integer startX = 0;
    Integer startY = 0;
    char[][] grid = null; // remember to initialised the grid 
    
    // constructors

    // methods
    public char[][] populateGrid(Repository parseRepo) throws IOException {
        
        while (true) {
            line = parseRepo.getNextLine();
            if (line == null)
                break;

            String[] lineArray = line.split(" ");

            if (lineArray[0].equalsIgnoreCase("#"))
            {
                continue;
            }
            else if (lineArray[0].equalsIgnoreCase("GRID"))
            {
                maxRows = Integer.parseInt(lineArray[1]);
                maxCols = Integer.parseInt(lineArray[2]);
                grid = new char[maxRows][maxCols];
            }
            else if (lineArray[0].equalsIgnoreCase("START")) 
            {
                startX = Integer.parseInt(lineArray[1]);
                startY = Integer.parseInt(lineArray[2]);
            } 
            else if (lineArray[0].equalsIgnoreCase("DATA"))
            {
                for (int i = 0; i < maxRows; i++) {
                    for (int j = 0; j < maxCols; j++) {
                        if (i == startX && j == startY) {
                            line = parseRepo.getNextLine();
                            if (line != null) {
                                char[] charArray = line.toCharArray();
                                // System.out.println("charArray[0]=" + charArray[0]);
                                // System.out.println("charArray[1]=" + charArray[1]);
                                for (int k = 0; k < charArray.length; k++) {
                                    grid[i][j] = charArray[k];
                                    System.out.print(grid[i][j]);
                                    j++;
                                }

                                while (j < maxCols) {
                                    grid[i][j] = '.';
                                    System.out.print(grid[i][j]);
                                    j++;
                                }
                                
                                startX++;
                            }
                            else if (line == null) 
                            {
                                grid[i][j] = '.';
                                System.out.print(grid[i][j]);
                            }
                        }
                        else 
                        {
                            grid[i][j] = '.';
                            System.out.print(grid[i][j]);
                        }
                    }

                    System.out.println();

                }
            }
        }
        return grid;
    }
}
