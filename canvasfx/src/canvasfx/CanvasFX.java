package canvasfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasFX extends Application {

    private static final int SW = 512;
    private static final int SH = 512;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bitmap graphics");
        Group root = new Group();
        Canvas canvas = new Canvas(SW, SH);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        PixelWriter pw = gc.getPixelWriter();
        for( int i = 0; i < SW; i++ ) {
            for( int j = 0; j < SH; j++ ) {
               pw.setColor( i, j, computeColor(i,j));
            } // for
        } // for
        
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    } // start( Stage )

    private Color computeColor( int i, int j ) {
        // TO-DO: replace the body of this method
        // with code that will produce a different
        // image
        
        // suggestions:
        //   0) try drawing interfering waves
        //   1) try drawing the Mandelbrot set
        //   2) try drawing a Julia set
        if( i < j ) {
            return Color.PURPLE;
        } // if
        else {
            return Color.WHITE;
        } // else
    } // computeColor( int, int )
    
    public static void main(String[] args) {
        launch(args);
    } // main( String [] )

} // CanvasFX
