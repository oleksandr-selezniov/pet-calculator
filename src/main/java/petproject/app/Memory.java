package petproject.app;

public class Memory {
    private static double memory;

    public static void storeToMemory(double value){memory = value;}
    public static double recallFromMemory() {return memory;}
    public static void increaseMemory(double value) {memory += value;}
}
