package simple2d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Simple2D extends Application {
    
    private static final int SCENE_WIDTH = 512;
    private static final int SCENE_HEIGHT = 512;
    private static final String SCENE_TITLE = "Introduction to JavaFX";
    
    @Override
    public void start (Stage primaryStage) {
        Group root = new Group();
        
        Scene scene = new Scene(root,SCENE_WIDTH,SCENE_HEIGHT);
        scene.setFill(Color.DARKSALMON);
        Scale scale = new Scale(SCENE_WIDTH/2,SCENE_HEIGHT/2);
        Translate translate = new Translate(1.0,1.0);
        root.getTransforms().addAll(scale, translate);
        
        Circle circle = new Circle(0.0, 0.0, 0.8);
        circle.setFill(Color.BISQUE);
        circle.setStroke(Color.BLUEVIOLET);
        circle.setStrokeWidth(0.04);
        
        root.getChildren().add(circle);
        
        primaryStage.setTitle(SCENE_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // start ( stage )
    
    public static void main(String[] args) {
        launch(args);
    }// main(String[])
}// Simple2D