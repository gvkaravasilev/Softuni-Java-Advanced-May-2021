package DefiningClassesLab.CarInfo;

public class CarInfo {
    private String brand;
    private String model;
    private int horsePower;

    public CarInfo(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
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
    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.brand, this.model, this.horsePower);
    }
}
