package DefiningClassesLab.Constructors;

public class CarConstructors {
    private String brand;
    private String model;
    private int horsePower;

    public CarConstructors(String brand, String model, int horsePower){
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }
    public CarConstructors(String brand, String model){
        this(brand, model, -1);
    }
    public CarConstructors(String brand, int horsePower){
        this(brand, "unknown", horsePower);
    }
    public CarConstructors(String brand){
        this(brand, "unknown", -1);
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.brand, this.model, this.horsePower);
    }

}
