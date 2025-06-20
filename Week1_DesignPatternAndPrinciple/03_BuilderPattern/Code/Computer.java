// File: Computer.java
public class Computer {
    // Required attributes
    private String cpu;
    private String ram;

    // Optional attributes
    private String storage;
    private String graphicsCard;
    private boolean hasWiFi;

    // Private constructor that uses the Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.hasWiFi = builder.hasWiFi;
    }

    // Static nested Builder class
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private boolean hasWiFi;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder hasWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    // Display method
    public void showConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + (storage != null ? storage : "Not included"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not included"));
        System.out.println("WiFi: " + (hasWiFi ? "Included" : "Not included"));
        System.out.println();
    }
}
