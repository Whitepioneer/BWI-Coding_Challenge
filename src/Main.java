
public class Main {
    public static void main(String[] args) {

        /* values */
        /* transporter maximum capacity */
        double tr1_max = 1_100;
        double tr2_max = 1_100;

        /* driver weight */
        double d1 = 72.4;
        double d2 = 85.7;

        /* transporter capacity with drivers (t1 with d1, t2 with d2)  --> max capacity with drivers */
        double t1 = tr1_max - d1;  /* t1=1027.6 */
        double t2 = tr2_max - d2;  /* t2=1014.3 */


        /* product list */
        Product[] productList = {
                new Product("Notebook Büro 13\"", 205, 2.451, 40, false),
                new Product("Notebook Büro 14\"", 420, 2.978, 35, false),
                new Product("Notebook outdoor", 450, 3.625, 80, false),
                new Product("Mobiltelefon Büro", 60, 0.717, 30, false),
                new Product("Mobiltelefon Outdoor", 157, 0.988, 60, false),
                new Product("Mobiltelefon Heavy Duty", 220, 1.220, 65, false),
                new Product("Tablet Büro klein", 620, 1.450, 40, false),
                new Product("Tablet Büro groß", 250, 1.455, 40, false),
                new Product("Tablet outdoor klein", 540, 1.690, 45, false),
                new Product("Tablet outdoor groß", 370, 1.980, 68, false)
        };


        /* sort list by utility per weight */
        //if (productList[1].getUtility() <= productList[2].getUtility() && productList[2].getUtility() <= productList[3].getUtility() && productList[3].getUtility() <= productList[4].getUtility() && productList[4].getUtility() <= productList[5].getUtility() && productList[5].getUtility() <= productList[6].getUtility() && productList[6].getUtility() <= productList[7].getUtility() && productList[7].getUtility() <= productList[8].getUtility() && productList[8].getUtility() <= productList[9].getUtility() && productList[9].getUtility() <= productList[10].getUtility()) {
        for (int s = 0; s < 10; s++) {
            /* sort ten times, because the list has ten elements */
            //richtigen sortier-algorthmus wählen????

            for (int i = 0; i < productList.length - 1; i++) {
                /* the element can be moved to the end of the list */

                if ((productList[i].getUtility() / productList[i].getWeight()) <= (productList[i + 1].getUtility() / productList[i + 1].getWeight())) {
                    /* comparison of the ratio of utility to weight of the current element with that of the next element using a swap */

                    Product swap1 = productList[i];
                    Product swap2 = productList[i + 1];
                    productList[i + 1] = swap1;
                    productList[i] = swap2;
                    //System.out.println("TAUSCH!" + productList[i].getName());
                }
            }
            //System.out.println("Liste ist perfekt sortiert");
        }

        /* chosen Transporter */
        String currentTransporter;

        /* call transport list method and output results for both transporters
         * line 1: assign transporter name
         * line 2: output which transport list it is
         * line 3: call transport list method (input: transporter capacity with driver, product list, transporter name
         * line 4: output transport list and utility
         * */

        /* transport list transporter 1 */
        currentTransporter = "Transporter 1";
        System.out.println("Transportliste " + currentTransporter + "\n");
        double loaded_t1 = loading(t1, productList, currentTransporter);
        System.out.println("\n" + "Der optimale Nutzwert von " + currentTransporter + " ist " + loaded_t1 + "\n" + "\n");

        /* transport list transporter 2 */
        currentTransporter = "Transporter 2";
        System.out.println("Transportliste " + currentTransporter + "\n");
        double loaded_t2 = loading(t2, productList, currentTransporter);
        System.out.println("\n" + "Der optimale Nutzwert von " + currentTransporter + " ist " + loaded_t2 + "\n" + "\n");

        /* total utility */
        double loaded_total = loaded_t1 + loaded_t2;
        System.out.println("Der gesamte optimale Nutzwert beider Transporter ist " + loaded_total);

    }


    /* methode to create the transport list for the transporters
     * Greedy algorithm*/
    public static double loading(double t_weight, Product[] load, String currentTransporter) {

        /* values */
        int totalUtility = 0;                          /* total utility of the transporter */
        double totalWeight = 0;                        /* total weight of the transporter */
        int currentQuantity = 0;                       /* quantity of the current product */
        int i = 0;                                     /* current position in the list */


        while (totalWeight <= t_weight && i < load.length) {
            /* repeated, while the total weight is less than the maximum weight of the transporter and the end of the list is not yet reached */

            if (load[i].getTaken() == false) {
                /* is the product is still available? */

                if (load[i].getQuantity() <= 0 ^ totalWeight + load[i].getWeight() > t_weight) {
                    /* is the total value is less than or equal to zero xor the total weight with the weight of the current element is less than the maximum weight of the transporter? */

                    load[i].setTaken(true);                                                                                                                       /* product is already loaded, cannot be taken anymore */
                    System.out.println("Es wird das Produkt: " + load[i].getName() + " " + currentQuantity + " mal in " + currentTransporter + " gelegt!");       /* output of how much of which product is loaded into which transporter */
                    i++;
                    currentQuantity = 0;                                                                                                                          /* set loaded quantity of the next product to zero */
                    load[i - 1].setTaken(false);                                                                                                                  /* previous product is not loaded, is allowed to be taken anymore */

                } else if (totalWeight + load[i].getWeight() <= t_weight) {
                    /* is the total weight with the weight of the current element less or equal to the maximum weight of the transporter? */

                    totalWeight = totalWeight + load[i].getWeight();                  /* new total weight is the old total weight with the weight of the current element  */
                    totalUtility = totalUtility + load[i].getUtility();               /* new total utility is the old total utility with the utility of the current element  */
                    //System.out.println("1: " + load[i].getQuantity());
                    currentQuantity = currentQuantity + 1;                            /* quantity of loaded units of this product increases by one */
                    load[i].setQuantity(load[i].getQuantity() - 1);                   /* quantity of maximum loadable units of this product decreases by one */
                }
            }
        }
        return totalUtility;               /* return the total utility of the products in the current transporter */
    }

}