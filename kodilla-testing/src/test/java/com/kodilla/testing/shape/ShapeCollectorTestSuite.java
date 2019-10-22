package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Test #" + testCounter);
    }

    //Test 1: sprawdzający, czy figura została dodana.
    @Test
    public void testAddFigure() {
        //Given
        Shape shape = new Triangle(5.0, 7.0);

        //When
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);
        Shape actualShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(shape, actualShape);

        System.out.println("Figure addition test");
    }

    //Test 2: sprawdzający, czy figura została usunięta.
    @Test
    public void testRemoveFigure() {
        //Given
        Shape shape = new Triangle(5.0, 7.0);
        Shape shape2 = new Square(6.0);

        //When
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);
        shapeCollector.addFigure(shape2);
        shapeCollector.removeFigure(shape);
        List<Shape> actualShapes = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(1, actualShapes.size());
        Assert.assertEquals(shape2, actualShapes.get(0));

        System.out.println("Figure removal test");

    }

    //Test 3: sprawdzający, czy metoda pobiera figurę
    @Test
    public void testGetFigure() {
        //Given
        Shape shape = new Triangle(5.0, 7.0);

        //When
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);


        Shape actualShape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(shape, actualShape);

        System.out.println("Figure get test");

    }

    //Test 4: sprawdzający czy metoda pokazuje liste figur
    @Test
    public void testShowFigures(){
        //Given
        Shape shape = new Triangle(5.0, 7.0);
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(shape);

        //When
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);
        List<Shape> actualShapes = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(shapes, actualShapes);

        System.out.println("Figure list display test");
    }
}
