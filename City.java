import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class City{
    String City;
    Connection[] connections;

    public City(String City){
        this.City = City;
    }

    public void addConnection(Connection input){
        int i = 0;
        if(this.City == null){
            this.connections = new Connection[5];
            this.connections[0] = input;
        } else {
            while(this.connections[i] != null){
                i++;
            }
        }
    }

    public void filereader(){
        try{
        BufferedReader reader = new BufferedReader(new FileReader("trains.csv"));
        System.out.println(reader.readLine());
        } catch (IOException e){
            System.out.println("File not found");
        }
    }
}

