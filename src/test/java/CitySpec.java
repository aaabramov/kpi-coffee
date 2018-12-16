import coffeShops.City;
import coffeShops.Point;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CitySpec {
    
    @Test
    public void testCity1() {
        
        City c = new City(10, 10);
        
        c.addPoint(new Point(4, 4));
        
        Point point = c.calculateForTestCase(1);
        
        Assert.assertEquals(point, new Point(4, 3, 1));
        
    }
    
    @Test
    public void testCity2() {
        
        City c = new City(5, 5);
        
        c.addPoint(new Point(2, 2));
        
        Point point = c.calculateForTestCase(4);
        
        Assert.assertEquals(point, new Point(1, 1, 1));
        
    }
    
    @Test
    public void testCityZero() {
        
        City c = new City(0, 0);
        
        Point point = c.calculateForTestCase(4);
        
        Assert.assertNull(point);
        
    }
    
    @Test
    public void testCityNull() {
        
        City c = new City(0, 0);
        
        Point point = c.calculateForTestCase(3);
        
        Assert.assertNull(point);
        
    }
    
    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testCityNegative() {
        
        City c = new City(-1, -1);
        
        Point point = c.calculateForTestCase(4);
        
        
    }
    
    
}
