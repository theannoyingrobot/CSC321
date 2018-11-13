package intro2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Intro2DPanel extends JPanel implements ActionListener {

    private static final int NUMBER_OF_CIRCLES = 48;
    private static final Color BG_COLOR
            = new Color(144, 192, 248);

    private int angle;
    private double xOffset;
    private double yOffset;
    private double rOffset;

    public Intro2DPanel() {
        this.initialize();

        this.angle = 0;
        this.rOffset = 0.09;
        
        this.updateCenter();
    } // Intro2DPanel()

    private void initialize() {
        this.setBackground(BG_COLOR);
    } // initialize()

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1.0, 1.0);

        AffineTransform transform = new AffineTransform();
        transform.concatenate(scale);
        transform.concatenate(translate);

        Stroke stroke = new BasicStroke(2);
        g2D.setStroke(stroke);

        g2D.setColor(Color.RED);

        List<Ellipse2D> circles
                = makeConcentricCircles(0.0, 0.0, NUMBER_OF_CIRCLES);

        for (Ellipse2D e : circles) {
            g2D.draw(transform.createTransformedShape(e));
        } // for

        circles
                = makeConcentricCircles(this.xOffset, this.yOffset,
                        NUMBER_OF_CIRCLES);

        for (Ellipse2D e : circles) {
            g2D.draw(transform.createTransformedShape(e));
        } // for
    } // paintComponent( Graphics )

    private void updateCenter() {
        double phi = Math.toRadians(this.angle);

        this.xOffset = rOffset * Math.cos(phi);
        this.yOffset = rOffset * Math.sin(phi);
    } // updateCenter()

    private Ellipse2D makeCircle(double cx, double cy, double r) {
        double ulx = cx - r;
        double uly = cy - r;
        double d = 2 * r;
        return new Ellipse2D.Double(ulx, uly, d, d);
    } // makeCircle( double, double, double )

    private List<Ellipse2D> makeConcentricCircles(double xCenter,
            double yCenter, int numberOfCircles) {

        List<Ellipse2D> circles = new ArrayList<>();
        for (int i = 1; i <= numberOfCircles; i++) {
            double r = ((double) i) / numberOfCircles;
            circles.add(makeCircle(xCenter, yCenter, r));
        } // for

        return circles;
    } // makeConcentricCircles( double, double, int )

    @Override
    public void actionPerformed(ActionEvent e) {
        this.angle = (this.angle + 1) % 360;
        this.updateCenter();
        this.repaint();
    } // actionPerformed( ActionEvent )

} // Intro2DPanel
