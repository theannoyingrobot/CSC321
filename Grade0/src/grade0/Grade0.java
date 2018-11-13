package grade0;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author nicholasokeefe
 */
public class Grade0 extends JFrame {

    private final int SCENE_WIDTH = 512;
    private final int SCENE_HEIGHT = 512;
    private final String SCENE_TITLE = "Graded Exercise 0";

    public Grade0() {
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

    public static void main(String[] args) {
        Grade0 grade0 = new Grade0();
    }
}
