package Task3_Class_Queue_Version;

abstract class abstraction {
    public abstract void fill();
    public abstract void initialise(FuelQueue[][] customers);

    public abstract void viewQueue(FuelQueue[][] customers);

    public abstract void emptyQueue(FuelQueue[][] customers);

    public abstract void remainingFuel();

    public abstract void addFuel();

    public abstract void fuelQueueIncome(FuelQueue[][] customers);

    public abstract void enqueue(String fname, String sname, String vNo, double liter);

    public abstract void dequeue();
}
