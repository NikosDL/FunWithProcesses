package nec.FunWithProcesses;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainView {

    private AnchorPane root;
    private Button startButton;
    private Button stopButton;
    
    private Map<String, Integer[]> regionMapping;

// ~~~~~~~~~~~~~~~ Base GUI SetUp ~~~~~~~~~~~~~~~ //
    
    public MainView() {
        this.root = new AnchorPane();
        this.root.setPrefSize(900, 800);
        this.root.setShape(this.returnRootShape(900, 800));
        this.root.getChildren().add(this.setUpTilePane());
        
        this.startButton = new Button("Start");
        this.startButton.setPrefSize(100, 50);
//        this.startButton.setOnAction(e -> this.startMonitor());
        this.root.getChildren().add(this.startButton);
        this.startButton.relocate(0, 0);
        
        this.stopButton = new Button("Stop");
        this.stopButton.setPrefSize(100, 50);
//        this.stopButton.setOnAction(e -> this.stopMonitor());
        this.root.getChildren().add(this.stopButton);
        this.stopButton.relocate(0, 100);
        System.out.println(Thread.currentThread().getName());
        
        this.repaintView();
        
    }

    private Rectangle returnRootShape(double width, double height) {
        Rectangle rect = new Rectangle(width, height);
        return rect;
    }

    private TilePane setUpTilePane() {
        TilePane grid = new TilePane();
        
        grid.relocate(100, 0);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setBackground(Background.fill(Color.BLACK));
        grid.setPadding(Insets.EMPTY);
        grid.setPrefSize(800, 800);
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                StackPane tile = this.createTile();
                tile.setId(String.valueOf(i) + String.valueOf(j));
                grid.getChildren().add(tile);
            }
        }
        
        return grid;
    }

    private StackPane createTile() {
        StackPane tile = new StackPane();
        tile.setBackground(Background.EMPTY);
        tile.setShape(new Rectangle(4, 4));
        tile.setPrefSize(4, 4);
        return tile;
    }

    
    
// ~~~~~~~~~~~~~~~ Scheduler Logic ~~~~~~~~~~~~~~~ //
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
// ~~~~~~~~~~~~~~~ Process Recognition Logic ~~~~~~~~~~~~~~~ //
    
    
    
    
    
    
    
    
    
    
// ~~~~~~~~~~~~~~~ Repaint Logic ~~~~~~~~~~~~~~~ //    
    
    private void paintSpecificTile(int coordX, int coordY, Color color) {
        List<Node> tileList = ((TilePane)this.root.getChildren().get(0))
                .getChildren()
                .stream()
                .filter(tile -> tile.getId().equals(String.valueOf(coordX) + String.valueOf(coordY)))
                .collect(Collectors.toList());
        StackPane tile = (StackPane) tileList.get(0);
        tile.setBackground(Background.fill(color));
    }

    private void paintRandomTiles() {
        Random rand = new Random();
        for (int i = 0; i < 250; i++) {
            int coordX = rand.nextInt(200);
            int coordY = rand.nextInt(200);
            Color color = Color.WHEAT;
            this.paintSpecificTile(coordX, coordY, color);
        }
    }
    
    private void gatherNewInformation() {
//        getActiveProcesses();
//        getProcessesMemory();
//        getProcessesInteraction();
    }
    
    private TilePane setUpViewAccordingToNewInformation() {
        TilePane pane = new TilePane();
        
        return pane;
    }

    private void replaceView() {
        
    }
    
    public void repaintView() {
        System.out.println("I have been called!");
        ((TilePane)this.root.getChildren().get(0))
                .getChildren()
                .stream()
                .forEach(tile -> {
                    StackPane tileAsPane = (StackPane) tile;
                    tileAsPane.setBackground(Background.EMPTY);
                });
        this.paintRandomTiles();
    }

    

    
// ~~~~~~~~~~~~~~~ General Utility Methods ~~~~~~~~~~~~~~~ //    
    
    public Parent asParent() {
        return this.root;
    }
}
