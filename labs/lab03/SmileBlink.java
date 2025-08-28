import javax.swing.*;
import java.awt.*;

public class SmileBlink extends JPanel {
    private boolean eyeOpen = true; // controla o piscar

    public SmileBlink() {
        Timer timer = new Timer(500, e -> { // pisca a cada 0.5s
            eyeOpen = !eyeOpen;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 200, 200); // rosto

        g.setColor(Color.BLACK);
        g.drawArc(100, 150, 100, 50, 0, -180); // boca

        g.fillOval(100, 100, 20, 20); // olho esquerdo sempre visível
        if (eyeOpen) {
            g.fillOval(180, 100, 20, 20); // olho direito aberto
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smile Blink");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SmileBlink());
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
