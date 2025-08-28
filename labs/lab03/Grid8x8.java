import javax.swing.*;
import java.awt.*;

public class Grid8x8 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        int stepX = w / 8;
        int stepY = h / 8;

        for (int i = 0; i <= 8; i++) {
            g.drawLine(i * stepX, 0, i * stepX, h); // verticais
            g.drawLine(0, i * stepY, w, i * stepY); // horizontais
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid 8x8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Grid8x8());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
