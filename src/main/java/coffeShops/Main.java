package coffeShops;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter writer = new PrintWriter(new File("output.txt"));
        while (true) {
            int dimensionX = Integer.parseInt(scanner.next());
            int dimensionY = Integer.parseInt(scanner.next());
            int points = Integer.parseInt(scanner.next());
            int tests = Integer.parseInt(scanner.next());
            if (dimensionX == 0 && dimensionY == 0 && points == 0 && tests == 0) break;
            City city = new City(dimensionX, dimensionY);
            for (int i = 0; i < points; i++) {
                int x = Integer.parseInt(scanner.next());
                int y = Integer.parseInt(scanner.next());
                Point point = new Point(x, y);
                city.addPoint(point);
            }
            for (int i = 0; i < tests; i++) {
                Point point = city.calculateForTestCase(Integer.parseInt(scanner.next()));
                if (point != null) {
                    writer.println(point.getAccessiblePoints() + "(" + point.getX() + ";" + point.getY() + ")");
                } else {
                    writer.println("No points found!");
                }
            }
        }
        writer.close();
    }
}
