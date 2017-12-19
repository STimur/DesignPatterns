package patterns.behavioral.visitor;

interface Restaurant {
    void accept(Visitor v);
    String getMenu();
}

class ItalyRestaurant implements Restaurant {
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getMenu() {
        return "Italy Menu";
    }
}

class JapanRestaurant implements Restaurant {
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getMenu() {
        return "Japan Menu";
    }
}

class RussianRestaurant implements Restaurant {
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getMenu() {
        return "Russian Menu";
    }
}

interface Visitor {
    void visit(Restaurant restaurant);
}

class Vegetarian implements Visitor {
    public void visit(Restaurant italyRestaurant) {
        System.out.println("Vegetarian " + italyRestaurant.getMenu());
    }
}

class MeatEater implements Visitor {
    public void visit(Restaurant italyRestaurant) {
        System.out.println("Meat " + italyRestaurant.getMenu());
    }
}

public class VisitorDemo {
    public static void main(String[] args) {
        Restaurant[] restaurants = {
                new ItalyRestaurant(),
                new JapanRestaurant(),
                new RussianRestaurant()
        };
        Vegetarian vegetarian = new Vegetarian();
        MeatEater meatEater = new MeatEater();

        for (Restaurant restaurant : restaurants)
            restaurant.accept(vegetarian);

        for (Restaurant restaurant : restaurants)
            restaurant.accept(meatEater);
    }
}
