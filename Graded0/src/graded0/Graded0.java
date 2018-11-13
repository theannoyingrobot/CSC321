package graded0;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author nokeefe21
 */
public class Graded0 extends JFrame {

    private final int SCENE_WIDTH = 512;
    private final int SCENE_HEIGHT = 512;
    private final String SCENE_TITLE = "Graded Exercise 0";

    public Graded0() {
        this.initailize();
    }

    private void initailize() {
        this.setSize(SCENE_WIDTH, SCENE_HEIGHT);
        this.setTitle(SCENE_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TSquare panel = new TSquare();
        Container pane = this.getContentPane();
        pane.add(panel);

        this.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graded0 john = new Graded0();
    }

}
