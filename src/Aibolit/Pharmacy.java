package Aibolit;

import java.util.ArrayList;
import java.util.Random;

class Pharmacy {

    private String name;

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    int soldAmount;

    @Override
    public String toString() {
        return "medicament{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", informationSupplie='" + informationSupplie + '\'' +
                ", supplie=" + supplie +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    private String description;
    private String informationSupplie;
    private String date;
    ArrayList<String> dateR = new ArrayList<>();

    Random r = new Random();
    int low = 0;
    int high = 6;
    int result = r.nextInt(high - low) + low;

    Supplie supplie = new Supplie();

    public String getInformationSupplie() {
        return informationSupplie;
    }

    public void setInformationSupplie(String informationSupplie) {
        this.informationSupplie = informationSupplie;
    }

    public Supplie getSupplie() {
        return supplie;
    }

    public void setSupplie(Supplie supplie) {
        this.supplie = supplie;
    }

    private int amount;
    private double price;

    public Pharmacy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setname(String nextLine) {
        supplie.setname(nextLine);
    }

    public String getname() {
        return supplie.getname();
    }

    public void setAddress(String nextLine) {
        supplie.setAddress(nextLine);
    }

    public String getAddress() {
        return supplie.getAddress();
    }

    public void setTown(String nextLine) {
        supplie.setTown(nextLine);
    }

    public String getTown() {
        return supplie.getTown();
    }

    public void setNumber(String nextLine) {
        supplie.setNumber(nextLine);
    }

    public String getNumber() {
        return supplie.getNumber();
    }
}
