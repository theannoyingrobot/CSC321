package intro2d;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Intro2D extends JFrame {
    
    private static final int FRAME_WIDTH = 512;
    private static final int FRAME_HEIGHT = 512;
    private static final String FRAME_TITLE = "Introduction";
    
    public Intro2D(){
        this.initialize();
    }//Intro2D()
    
    private void initialize(){
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Intro2DPanel panel = new Intro2DPanel();
        Container pane=this.getContentPane();
        pane.add(panel);
        Timer timer = new Timer(20,panel);
        // Do not turn on time r when we are writing
        // an image file (we do not want hundreds offiles!).
        //time r.start();
        this.setVisible(true);
    }//initialize()
    
    public static void main(String[]args){
        Intro2D intro2D = new Intro2D();
    }//main(String[])
}//Intro2D