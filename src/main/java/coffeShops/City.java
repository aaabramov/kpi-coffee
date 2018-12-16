package coffeShops;

import java.util.LinkedList;
import java.util.List;

public class City {
    private int dimensionX;
    private int dimensionY;
    private int[][] field;
    private List<Point> keyPoints = new LinkedList<>();
    
    public City(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.field = new int[dimensionY + 1][dimensionX + 1];
    }
    
    public void addPoint(Point point) {
        keyPoints.add(point);
    }
    
    private void clearMap() {
        for (int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {
                field[i][j] = 0;
            }
        }
    }
    
    public Point calculateForTestCase(int distance) {
        clearMap();
        prepareMap(distance);
        return findBestPoint();
    }
    
    private void prepareMap(int distance) {
        for (int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {
                for (Point point : keyPoints) {
                    if (Math.abs(point.getX() - j) + Math.abs(point.getY() - i) <= distance) {
                        field[i][j]++;
                    }
                }
            }
        }
    }
    
    private Point findBestPoint() {
        int max = 0;
        int maxX = 0;
        int maxY = 0;
        for (int i = 1; i <= dimensionX; i++) {
            for (int j = 1; j <= dimensionY; j++) {
                if (field[i][j] > max) {
                    maxX = j;
                    maxY = i;
                    max = field[i][j];
                }
            }
        }
        if (field[maxY][maxX] > 0) {
            return new Point(maxX, maxY, field[maxY][maxX]);
        } else return null;
    }
    
}
