import javax.swing.*;
import java.awt.*;

public class Spiral extends JPanel {
    private double angle = 0;

    public Spiral() {
        Timer timer = new Timer(50, e -> {
            angle += Math.PI / 60; // gira
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int n = 200;
        int[] x = new int[n];
        int[] y = new int[n];
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (int i = 0; i < n; i++) {
            double t = i * 0.2;
            double r = 5 * t;
            double a = t + angle;
            x[i] = (int) (centerX + r * Math.cos(a));
            y[i] = (int) (centerY + r * Math.sin(a));
        }

        g.drawPolyline(x, y, n);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spiral Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Spiral());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
