package julia;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Julia extends Application {

    // TO-DO:
    // Define scene width, height, and title.
    // Change the values according to taste.
    private static final int SW = 512;
    private static final int SH = 512;
    private static final String ST = "Julia Set";

    // TO-DO:
    // More iterations gives a more accurate
    // result but also slows the speed at 
    // which the program draws the picture.
    // Experiment with different values.
    private static final int MAX_ITERATIONS = 64;

    // TO-DO:
    // Define components of a complex constant.
    // These values will determine which Julia
    // set the computer draws.
    // Experiment with different values.
    private static final double C_REAL = -0.2;
    private static final double C_IMAG =  0.1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(ST);
        Group root = new Group();
        Canvas canvas = new Canvas(SW, SH);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        PixelWriter pw = gc.getPixelWriter();
        for (int i = 0; i < SW; i++) {
            for (int j = 0; j < SH; j++) {
                pw.setColor(i, j, computeColor(i, j));
            } // for
        } // for

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Color computeColor(int i, int j) {

        double real = (2.0 * (i - SW / 2)) / SW;
        double imag = (2.0 * (j - SH / 2)) / SH;

        Complex z = new Complex(real, imag);
        Complex c = new Complex(C_REAL, C_IMAG);
        int count = 0;
        while (z.magnitudeSquared() < 4 && count < MAX_ITERATIONS) {
            z = z.multiply(z).add(c);
            count++;
        } // while

        if (count == MAX_ITERATIONS) {
            // TO-DO:
            // Specify a background color.
            // Change this color according
            // to taste.
            return Color.AQUAMARINE;
        } // if
        else {
            // TO-DO:
            // Make this color a function
            // of count to get a fancier 
            // picture.
            return Color.DARKRED;
        }
    } // computeColor( int, int )


    public static void main(String[] args) {
        launch(args);
    } // main( String [] )

} // Julia
