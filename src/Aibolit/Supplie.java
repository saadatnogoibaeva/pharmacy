package Aibolit;

class Supplie {
    public Supplie() {
    }

    private String name, address, number, town;

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String infoSupplie() {
        return getname() + " " + getAddress() + " " + getTown() + " " + getNumber();
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
