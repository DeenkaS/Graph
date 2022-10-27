public class bench {

    public static void main(String[] args){
        Map test = new Map("trains.csv");
        int k = 1;
        for(int i = 0; i < 541; i++){
            if(test.cities[i] != null){
                System.out.print("City nr " + k + " : " + test.cities[i].cityName + " connects to ");
                for(int j = 0; j < 5; j++){
                    if(test.cities[i].connections[j] != null){
                        System.out.print(test.cities[i].connections[j].City.cityName + ", ");
                    }
                }
                System.out.println();
                k++;
            }
        }
        int hash = 7;
        int mod = 541;
        String name = "BorlÃ¤nge";
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        
        System.out.println(hash % mod);
        System.out.println(test.cities[3].cityName);
    }
}