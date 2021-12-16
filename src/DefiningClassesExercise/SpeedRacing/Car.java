package DefiningClassesExercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public Car(int fuelAmount, double fuelCostPerKm){
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void ableToDrive(String model, double distance){
        double neededLiters = distance * this.fuelCostPerKm;

        if(this.fuelAmount >= neededLiters){
            this.fuelAmount -= neededLiters;
            this.distanceTraveled += distance;
        }else{

            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
