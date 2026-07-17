package ConcretePrototype;

import Prototype.Shape;
/**
 * Prototype Concreto: aggiunge attributi specifici e implementa la clonazione.
 */
public class Circle extends Shape {
    private int radius;

    public Circle() {
    }

    // Il costruttore di copia richiama quello della superclasse
    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }

    @Override
    public String toString() {
        return "Circle [x=" + getX() + ", y=" + getY() + ", color=" + getColor() + ", radius=" + radius + "]";
    }
}