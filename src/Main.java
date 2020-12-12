
public class Main {
    public static void main(String[] args) {

        //values
        //transporter max capacity
        double tr1_max = 1_100;
        double tr2_max = 1_100;

        //driver weight
        double d1 = 72.4;
        double d2 = 85.7;

        //transporter with drivers (t1 with d1, t2 with d2)  --> max capacity with drivers
        double t1 = tr1_max - d1;
        double t2 = tr2_max - d2;

        //Gesamtgewicht = Gewicht pro Produkt * Anzahl(Bsp.: 205*2,451=502,455)


        //Product list
        Product[] productList = {
                new Product("Notebook Büro 13\"", 205, 2.451, 40, false),
                new Product("Notebook Büro 14\"", 420, 2.978, 35, false),
                new Product("Notebook outdoor", 450, 3.625, 80, false),
                new Product("Mobiltelefon Büro", 60, 0.717, 30, false),
                new Product("Mobiltelefon Outdoor", 157, 0.988, 60, false),
                new Product("Mobiltelefon Heavy Duty", 220, 1.220, 65, false),
                new Product("Tablet Büro klein", 620, 1.450, 40, false),
                new Product("Tablet Büro groß", 250, 1.455, 40, false),
                new Product("Tablet Büro groß", 540, 1.690, 45, false),
                new Product("Tablet outdoor groß", 370, 1.980, 68, false)
        };

        double loaded_t1 = loading(t1, productList);
        System.out.println("Taken T1: " + loaded_t1);

        double loaded_t2 = loading(t2, productList);
        System.out.println("Taken T2: " + loaded_t2);

    }

    public static double loading(double t_weight, Product[] load) {
        int totalUtility = 0;
        double totalWeight = 0;
        int totalQuantity = 0;
        boolean isTaken = false;

        for (int i = 0; i < load.length - 1; i++) {
            if ((load[i].getUtility() / load[1].getWeight()) <= (load[i + 1].getUtility() / load[1 + 1].getWeight())) {
                Product a = load[i];
                Product b = load[i + 1];
                load[i + 1] = a;
                load[i] = b;
            }
        }

        int i = 0;

        while (totalWeight <= t_weight && i < load.length) {
            if (load[i].getTaken() == false) {
                if (load[i].getQuantity() <= 0 ^ totalWeight + load[i].getWeight() > t_weight) {
                    load[i].setTaken(true);
                    i++;
                    System.out.println("2: i++");
                    load[i - 1].setTaken(false);


                } else if (totalWeight + load[i].getWeight() <= t_weight) {
                    totalWeight = totalWeight + load[i].getWeight();
                    totalUtility = totalUtility + load[i].getUtility();
                    System.out.println("1: " + load[i].getQuantity());
                    load[i].setQuantity(load[i].getQuantity() - 1);

                }
            }
        }

        return totalUtility;
    }

}