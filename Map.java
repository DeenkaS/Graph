import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                
                cities[hash(row[0])].cityName = row[0];
                cities[hash(row[0])].addConnection(row[1],Integer.valueOf(row[2]));
                
                cities[hash(row[2])].cityName = row[2];
                cities[hash(row[2])].addConnection(row[1],Integer.valueOf(row[0]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

}