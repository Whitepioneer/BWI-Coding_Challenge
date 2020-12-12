public class Product {
    private String name;
    private int quantity;
    private double weight;
    private int utility;
    private boolean taken;

    /**
     * object containing information for a product
     *
     * @param name     name of the product
     * @param quantity quantity needed of the product
     * @param weight   weight in kilogram
     * @param utility  utility of the product
     * @param taken  if the product is loaded
     */

    public Product(String name, int quantity, double weight, int utility, boolean taken) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.utility = utility;
        this.taken =taken;
    }

    public String getName(){
        return  name;
    }

    public void setName(String n){
        name=n;
    }

    public int getQuantity(){
        return  quantity;
    }

    public void setQuantity(int q){
        quantity=q;
    }

    public double getWeight(){
        return  weight;
    }

    public void setWeight(double w){
        weight=w;
    }

    public int getUtility(){
        return  utility;
    }

    public void setUtility(int u){
        utility=u;
    }

    public boolean getTaken(){
        return  taken;
    }

    public void setTaken(boolean t){
        taken=t;
    }

}

