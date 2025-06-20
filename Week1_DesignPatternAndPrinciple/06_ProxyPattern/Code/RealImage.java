// File: RealImage.java
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer(fileName);
    }

    private void loadFromRemoteServer(String fileName) {
        System.out.println("Loading image from remote server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
