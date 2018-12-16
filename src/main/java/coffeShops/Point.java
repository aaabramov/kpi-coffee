package coffeShops;

import java.util.Objects;
import java.util.StringJoiner;

public class Point {
    private int x;
    private int y;
    private int accessiblePoints;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int accessiblePoints) {
        this.x = x;
        this.y = y;
        this.accessiblePoints = accessiblePoints;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAccessiblePoints() {
        return accessiblePoints;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .add("accessiblePoints=" + accessiblePoints)
                .toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y &&
                accessiblePoints == point.accessiblePoints;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y, accessiblePoints);
    }
}
