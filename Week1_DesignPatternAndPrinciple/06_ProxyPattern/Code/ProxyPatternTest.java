// File: ProxyPatternTest.java
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature_photo.jpg");

        // First time loading
        image1.display();

        // Second time - should use cached image
        image1.display();

        // New image
        Image image2 = new ProxyImage("mountain_view.jpg");
        image2.display();
    }
}
