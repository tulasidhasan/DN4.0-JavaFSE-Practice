// File: BuilderPatternTest.java
public class BuilderPatternTest {
    public static void main(String[] args) {
        // Creating a basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
                                    .build();
        basicComputer.showConfig();

        // Creating a gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                                    .storage("1TB SSD")
                                    .graphicsCard("NVIDIA RTX 4080")
                                    .hasWiFi(true)
                                    .build();
        gamingComputer.showConfig();

        // Creating a workstation
        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB")
                                    .storage("2TB HDD")
                                    .hasWiFi(true)
                                    .build();
        workstation.showConfig();
    }
}
