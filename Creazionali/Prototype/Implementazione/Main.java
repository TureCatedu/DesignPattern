
import ConcretePrototype.*;
import Prototype.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Client: popola una lista di forme e le clona senza conoscere le loro classi concrete.
 */
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(20);
        circle.setRadius(15);
        circle.setColor("Red");
        shapes.add(circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(10);
        rectangle.setY(20);
        rectangle.setWidth(40);
        rectangle.setHeight(50);
        rectangle.setColor("Blue");
        shapes.add(rectangle);

        // Clona le forme in modo trasparente
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        // Verifica i risultati
        System.out.println("--- Dettagli Forme Originali ---");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println("\n--- Dettagli Forme Clonate ---");
        for (int i = 0; i < shapesCopy.size(); i++) {
            Shape original = shapes.get(i);
            Shape clone = shapesCopy.get(i);
            System.out.println(clone);
            System.out.println("Original != Clone (riferimenti in memoria): " + (original != clone));
            System.out.println("Original.equals(Clone) (valori uguali): " + original.equals(clone));
        }
    }
}