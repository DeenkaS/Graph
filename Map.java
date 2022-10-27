import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    public City[] cities;
    private final int mod = 541;
    private int emptyfill = 0;
    private int nothing1 = 0;
    private int step = 0;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                City city1 = lookup(row[0]);
                City city2 = lookup(row[1]);

                Integer distance = Integer.parseInt(row[2]);

                city1.addConnection(city2, distance);
                city2.addConnection(city1, distance);

                hashadd(city1);
                hashadd(city2);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    // takes cityname. returns city if found in list. otherwise creates new city and
    // returns that.
    private City lookup(String cityName) {
        int i = hash(cityName);
        if (cities[i] != null && cities[i].cityName.equals(cityName)) {
            return cities[i];
        } else {
            while (cities[i] != null) {
                if (cities[i].cityName.equals(cityName)) {
                    return cities[i];
                }
                i++;
            }

            City newCity = new City(cityName);
            return newCity;

        }
    }

    private void hashadd(City input) {
        int i = hash(input.cityName);

        if (cities[i] == null) {
            cities[i] = input;

        } else if (cities[i] == input) {
            return;
        } else {
            while (cities[i] != null) {
                i++;
                if (cities[i] == null) {
                    cities[i] = input;
                    return;

                } else if (cities[i] == input) {
                    return;
                }
            }
            cities[i] = input;
        }
    }
}