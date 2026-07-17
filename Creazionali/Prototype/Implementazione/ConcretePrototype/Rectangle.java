package ConcretePrototype;

import Prototype.Shape;

/**
 * Prototype Concreto: aggiunge attributi specifici e implementa la clonazione.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
    }

    // Il costruttore di copia richiama quello della superclasse
    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }

    @Override
    public String toString() {
        return "Rectangle [x=" + getX() + ", y=" + getY() + ", color=" + getColor() + ", width=" + width + ", height=" + height + "]";
    }
}