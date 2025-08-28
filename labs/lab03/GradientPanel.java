import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GradientPanel extends JPanel {
    private Color startColor = Color.RED;
    private Color endColor = Color.YELLOW;

    public void setStartColor(Color c) { startColor = c; repaint(); }
    public void setEndColor(Color c) { endColor = c; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
        g2d.setPaint(gradient);
        g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gradient Colors");
        GradientPanel panel = new GradientPanel();

        JButton btnStart = new JButton("Cor Inicial");
        JButton btnEnd = new JButton("Cor Final");

        btnStart.addActionListener(e -> {
            Color c = JColorChooser.showDialog(frame, "Escolha a cor inicial", panel.startColor);
            if (c != null) panel.setStartColor(c);
        });

        btnEnd.addActionListener(e -> {
            Color c = JColorChooser.showDialog(frame, "Escolha a cor final", panel.endColor);
            if (c != null) panel.setEndColor(c);
        });

        frame.setLayout(new BorderLayout());
        frame.add(btnStart, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(btnEnd, BorderLayout.SOUTH);

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
