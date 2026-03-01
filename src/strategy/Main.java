package strategy;

public class Main {

    public static void main(String[] args) {
        TravelBookingContext context = new TravelBookingContext();

        context.setStrategy(new AirplaneStrategy());
        System.out.println("Самолёт (эконом, 2 пасс., 1000 км, скидка 10%): " +
                context.calculateCost(1000, 2, "economy", 10) + " руб.");

        context.setStrategy(new AirplaneStrategy());
        System.out.println("Самолёт (бизнес, 1 пасс., 1000 км, скидка 0%): " +
                context.calculateCost(1000, 1, "business", 0) + " руб.");

        context.setStrategy(new TrainStrategy());
        System.out.println("Поезд (эконом, 3 пасс., 500 км, скидка пенсионер 20%): " +
                context.calculateCost(500, 3, "economy", 20) + " руб.");

        context.setStrategy(new TrainStrategy());
        System.out.println("Поезд (бизнес, 2 пасс., 500 км, скидка 0%): " +
                context.calculateCost(500, 2, "business", 0) + " руб.");

        context.setStrategy(new BusStrategy());
        System.out.println("Автобус (4 пасс., 200 км, скидка детская 15%): " +
                context.calculateCost(200, 4, "economy", 15) + " руб.");

        try {
            context.setStrategy(null);
            context.calculateCost(100, 1, "economy", 0);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            context.setStrategy(new BusStrategy());
            context.calculateCost(-100, 1, "economy", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}