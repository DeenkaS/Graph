public class City{
    String cityName;
    Connection[] connections = new Connection[5];

    public City(String cityName){
        this.cityName = cityName;
    }

    public void addConnection(City city, Integer distance){
        int i = 0;
        
        while(this.connections[i] != null){
            i++;
        }
        connections[i].City = city;
        connections[i].distanceInMinutes = distance;
    }
}

