import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        // What to do when the window closes:
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Size of the window, in pixels
        gui.setSize(800,500);
        // Make the window "visible"
        gui.setVisible(true);

    }
}