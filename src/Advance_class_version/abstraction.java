package Advance_class_version;

abstract class abstraction {
    public abstract void fill();
    public abstract void initialise(FuelQueue[][] customers);

    public abstract void viewQueue(FuelQueue[][] customers);

    public abstract void emptyQueue(FuelQueue[][] customers);

    public abstract void remainingFuel();

    public abstract void addFuel();

    public abstract void storeDataFile(FuelQueue[][] customers);

    public abstract void loadDataFile(FuelQueue[][] customers);


    public abstract void fuelQueueIncome(FuelQueue[][] customers);
}
