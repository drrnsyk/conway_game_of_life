package vttp2022.conwayGoL;

import java.io.IOException;

public class Main 
{
    public static void main( String[] args ) throws IOException, InterruptedException 
    {
        
        // take in a .txt file
        Repository repo = new Repository(args[0]);
        
        // call Parser to do parsing and generte start state
        Parser parse = new Parser(); // initalize the parser
        System.out.println("This is the start state ----------------------------------------");
        System.out.println();
        char[][] startGen = parse.populateGrid(repo); // use parser methods to populate and generate the first gen
        
        // call Conway to generate the next generation
        System.out.println();
        System.out.println("This is generation 1 -------------------------------------------");
        System.out.println();
        Conway gameOfLife = new Conway();
        gameOfLife.nextGen(startGen);
        
        
    }
}
