package vttp2022.conwaygol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Repository {

    // properties
    public String line = "";
    public FileReader r;
    public BufferedReader br;

    // constructors
    public Repository(String fileName) throws FileNotFoundException {

        r = new FileReader(fileName);
        br = new BufferedReader(r);

    }

    // methods
    public String getNextLine () throws IOException {
        return this.line = br.readLine();
    }

}
