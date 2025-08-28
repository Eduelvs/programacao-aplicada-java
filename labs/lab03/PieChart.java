import javax.swing.*;
import java.awt.*;

public class PieChart extends JPanel {
    private int[] values = {30, 10, 20, 25, 15};
    private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int total = 0;
        for (int v : values) total += v;

        int startAngle = 0;
        for (int i = 0; i < values.length; i++) {
            int arcAngle = (int) Math.round(360.0 * values[i] / total);
            g.setColor(colors[i]);
            g.fillArc(50, 50, 200, 200, startAngle, arcAngle);

            
            int legendX = 270;
            int legendY = 60 + i * 25;
            g.setColor(colors[i]);
            g.fillRect(legendX, legendY, 15, 15);

            g.setColor(Color.BLACK);
            g.drawRect(legendX, legendY, 15, 15);
            g.drawString(values[i] * 100 / total + "%", legendX + 25, legendY + 12);
            startAngle += arcAngle;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pie Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PieChart());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
