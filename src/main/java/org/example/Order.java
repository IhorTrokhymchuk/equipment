package org.example;

public class Order {
    private final String Name;
    private final Equipment TypesEquipment;
    private final int Duration;
    private final double PriceHour;
    private final boolean RegularCustomer;

    public Order(String Name, Equipment TypesEquipment, int Duration, double PriceHour, boolean RegularCustomer) {
        this.Name = Name;
        this.TypesEquipment = TypesEquipment;
        this.Duration = Duration;
        this.PriceHour = PriceHour;
        this.RegularCustomer = RegularCustomer;
    }

    public double TotalPrice() {
        double Price = PriceHour * Duration;
        if (RegularCustomer) {
            Price *= 0.9; // Знижка 10% для постійних клієнтів
        }
        return Price;
    }

    @Override
    public String toString() {
        String TypeRent = (Duration == 24) ? "Подобова" : "Довгострокова";
        return "Замовлення: " +
                "Ім'я: " + Name +
                ", Вид техніки: " + TypesEquipment +
                ", Тип оренди: " + TypeRent +
                ", Тривалість: " + Duration + " год" +
                ", Вартість: " + TotalPrice() + " грн";
    }
}
