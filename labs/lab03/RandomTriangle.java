import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class RandomTriangle extends JPanel {
    private Random rand = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 10; i++) {
            int x1 = rand.nextInt(getWidth());
            int y1 = rand.nextInt(getHeight());
            int x2 = rand.nextInt(getWidth());
            int y2 = rand.nextInt(getHeight());
            int x3 = rand.nextInt(getWidth());
            int y3 = rand.nextInt(getHeight());

            GeneralPath triangle = new GeneralPath();
            triangle.moveTo(x1, y1);
            triangle.lineTo(x2, y2);
            triangle.lineTo(x3, y3);
            triangle.closePath();

            g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            g2d.fill(triangle);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RandomTriangle());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
