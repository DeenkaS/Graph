public class bench {

    public static void main(String[] args){
        Map test = new Map("trains.csv");
        int k = 1;
        for(int i = 0; i < 541; i++){
            if(test.cities[i] != null){
                System.out.print("City nr " + k + " : " + test.cities[i].cityName + " connects to ");
                // for(int j = 0; j < 1; j++){
                //     if(test.cities[i].connections[j].City.cityName != null){
                //         System.out.println(test.cities[i].connections[j].City.cityName + ", ");
                //     }
                // }
                k++;
            }
        }
    }
}