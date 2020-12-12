
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
        double t1 = tr1_max - d1;  //t1=1027.6
        double t2 = tr2_max - d2;  //t2=1014.3


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


        //sort list by utility per weight
        for (int i = 0; i < productList.length - 1; i++) {
            if ((productList[i].getUtility() / productList[i].getWeight()) <= (productList[i + 1].getUtility() / productList[i + 1].getWeight())) {
                Product a = productList[i];
                Product b = productList[i + 1];
                productList[i + 1] = a;
                productList[i] = b;
            }
        }

        //chosen Transporter
        String currentTransporter;

        //transport list transporter 1
        currentTransporter = "Transporter 1";
        System.out.println("Transportliste " + currentTransporter + "\n");
        double loaded_t1 = loading(t1, productList, currentTransporter);
        System.out.println("\n" + "Optimalernutzwert " + currentTransporter + ": " + loaded_t1 + "\n" + "\n");

        //transport list transporter 2
        currentTransporter = "Transporter 2";
        System.out.println("Transportliste " + currentTransporter + "\n");
        double loaded_t2 = loading(t2, productList, currentTransporter);
        System.out.println("\n" + "Optimalernutzwert " + currentTransporter + ": " + loaded_t2 + "\n" + "\n");

    }

    public static double loading(double t_weight, Product[] load, String currentTransporter) {
        int totalUtility = 0;
        double totalWeight = 0;
        int i = 0;
        int currentQuantitiy = 0;

        while (totalWeight <= t_weight && i < load.length) {
            if (load[i].getTaken() == false) {

                if (load[i].getQuantity() <= 0 ^ totalWeight + load[i].getWeight() > t_weight) {
                    load[i].setTaken(true);
                    System.out.println("Es wird das Produkt: " + load[i].getName() + " " + currentQuantitiy + " mal in " + currentTransporter + " gelegt!");
                    i++;
                    currentQuantitiy = 0;
                    load[i - 1].setTaken(false);

                } else if (totalWeight + load[i].getWeight() <= t_weight) {
                    totalWeight = totalWeight + load[i].getWeight();
                    totalUtility = totalUtility + load[i].getUtility();
                    //System.out.println("1: " + load[i].getQuantity());
                    currentQuantitiy = currentQuantitiy + 1;
                    load[i].setQuantity(load[i].getQuantity() - 1);
                }

            }
        }

        return totalUtility;
    }

}
 //genauer Kommentieren in loading
//reihenfolge nutzwerte überprüfen!!!!!!!!!!!!!!