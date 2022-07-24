package Task2_Class_Version;

abstract class abstraction {
    public abstract void fill();
    public abstract void initialise(FuelQueue[][] customers);

    public abstract void viewQueue(FuelQueue[][] customers);

    public abstract void emptyQueue(FuelQueue[][] customers);

    public abstract void remainingFuel();

    public abstract void addFuel();

    public abstract void fuelQueueIncome(FuelQueue[][] customers);
}
