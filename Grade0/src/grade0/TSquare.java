package grade0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * CSC 321 10/26/18
 *
 * @author nicholasokeefe
 */
public class TSquare extends JPanel {

    public TSquare() {
        this.initialize();
    }

    private void initialize() {
        this.setBackground(Color.BLACK);
    }

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

        // creates the first square       
        g2D.setColor(Color.RED);
        Rectangle2D testing = new Rectangle2D.Double(-.5, -.5, 1, 1);
        g2D.fill(transform.createTransformedShape(testing));

        // goes through list and draws the rest of the squares
        List<Rectangle2D> lagann = moreRects(testing);
        for (Rectangle2D e : lagann) {
            g2D.fill(transform.createTransformedShape(e));
        }
    } //paintComponent(Graphics)

    private List<Rectangle2D> moreRects(Rectangle2D base) {
        double l = base.getWidth();
        double ulx = base.getX();
        double uly = base.getY();
        List<Rectangle2D> rects = new ArrayList<>();

        //Stops drawing squares once sides of squares are less than 0.01
        if (l < 0.01) {
            return rects;
        } //if

        //upper right square
        Rectangle2D upR = new Rectangle2D.Double(ulx + .75 * 1, uly - 1 / 4, 1 / 2, 1 / 2);
        rects.add(upR);
        rects.addAll(moreRects(upR));
        //upper left square
        Rectangle2D upL = new Rectangle2D.Double(ulx - .25 * 1, uly - .25 * 1, 1 / 2, 1 / 2);
        rects.add(upL);
        rects.addAll(moreRects(upL));
        //lower right square
        Rectangle2D lowR = new Rectangle2D.Double(ulx + .75 * 1, uly + .75 * 1, 1 / 2, 1 / 2);
        rects.add(lowR);
        rects.addAll(moreRects(lowR));
        //lower left square
        Rectangle2D lowL = new Rectangle2D.Double(ulx - .25 * 1, uly + .25 * 1, 1 / 2, 1 / 2);
        rects.add(lowL);
        rects.addAll(moreRects(lowL));
        return rects;
    } // List<Rectangle2D>
} // TSquare
