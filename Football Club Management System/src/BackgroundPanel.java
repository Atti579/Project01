import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String fileName) {
        try {
            // Load the image from the resources folder
            backgroundImage = new ImageIcon(getClass().getResource("/images/" + fileName)).getImage();
        } catch (Exception e) {
            System.out.println("Background image not found.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Draw the background image to fit the panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}