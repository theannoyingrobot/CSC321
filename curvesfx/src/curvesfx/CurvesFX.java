package curvesfx;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class CurvesFX extends Application {

    private static final int SCENE_WIDTH = 512;
    private static final int SCENE_HEIGHT = 512;
    private static final String SCENE_TITLE = "Curves";
    private static final int NUMBER_OF_SEGMENTS = 64;

    private final List<Point2D> points = new ArrayList<>();

    {
        points.add(new Point2D(-1.0, 0.0));
        points.add(new Point2D(-0.4, 0.8));
        points.add(new Point2D(0.4, -0.8));
        points.add(new Point2D(1.0, 0.0));
    } // initialization block

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scale scale = new Scale(SCENE_WIDTH / 2, SCENE_HEIGHT / 2);
        Translate translate = new Translate(1.0, 1.0);
        root.getTransforms().addAll(scale, translate);

        Scene scene
                = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        scene.setFill(Color.LEMONCHIFFON);

        Path curve = new Path();
        Point2D p = getPoint( 0.0 );
        double x = p.getX();
        double y = p.getY();
        MoveTo moveTo = new MoveTo( x, y );
        curve.getElements().add(moveTo);
        for (int i = 1; i < NUMBER_OF_SEGMENTS; i++) {
            double t = ((double) i) / NUMBER_OF_SEGMENTS;
            p = getPoint( t );
            x = p.getX();
            y = p.getY();
            LineTo lineTo = new LineTo(x, y);
            curve.getElements().add(lineTo);
        } // for
        p = getPoint( 1.0 );
        x = p.getX();
        y = p.getY();
        LineTo lineTo = new LineTo( x, y );
        curve.getElements().add( lineTo );
        
        curve.setStroke(Color.SEAGREEN);
        curve.setStrokeWidth(0.02);

        root.getChildren().add(curve);

        primaryStage.setTitle(SCENE_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // start( Stage )

    private double weightedAvg(double a, double b, double t) {
        return (1 - t) * a + t * b;
    } // weightedAvg( double, double, double )

    private Point2D weightedAvg(Point2D p0, Point2D p1, double t) {
        double x = weightedAvg(p0.getX(), p1.getX(), t);
        double y = weightedAvg(p0.getY(), p1.getY(), t);
        return new Point2D(x, y);
    } // weightedAvg( Point2D, Point2D, double )
    
    private Point2D weightedAvg( Point2D p0, Point2D p1, Point2D p2,
            double t ) {
        Point2D p01 = weightedAvg( p0, p1, t );
        Point2D p12 = weightedAvg( p1, p2, t );
        return weightedAvg( p01, p12, t );
    } // weightedAvg( Point2D, Point2D, Point2D, double )

    private Point2D weightedAvg( Point2D p0, Point2D p1,
            Point2D p2, Point2D p3, double t ) {
        Point2D p02 = weightedAvg( p0, p1, p2, t);
        Point2D p13 = weightedAvg( p1, p2, p3, t);
        return weightedAvg( p02, p13, t);
    } // weightedAvg( Point2D, Point2D, Point2D, Point2D, double )
    
    private Point2D getPoint( double t ) {
        Point2D p0 = points.get(0);
        Point2D p1 = points.get(1);
        Point2D p2 = points.get(2);
        Point2D p3 = points.get(3);
        return weightedAvg( p0, p1, p2, p3, t );
    } // getPoint( double )
    
    public static void main(String[] args) {
        launch(args);
    } // main( String [] )

} // CurvesFX
