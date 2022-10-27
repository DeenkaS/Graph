public class Paths {
    static City[] path = new City[54];
    static int sp = 0;

    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        String from = "Malmö";
        String to = "Stockholm";
        Paths path = new Paths();
        Integer max = Integer.valueOf(1000000);
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;

        for (int i = 0; i < from.connections.length; i++) {
            if (from.connections[i] != null) {
                Connection conn = from.connections[i];
                Integer distance = shortest(conn.City, to, max - conn.distanceInMinutes);
                if((distance != null) && ((shrt == null) || (shrt > distance + conn.distanceInMinutes)))
                    shrt = distance + conn.distanceInMinutes;

            }
        }
        path[sp--] = null;
        return shrt;
    }
    
  


}
