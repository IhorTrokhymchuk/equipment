package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class OrderTest {
    @Test
    public void testTotalPriceWithoutDiscount() {
        Order order = new Order("John", Equipment.Кран, 24, 100.0, false);
        double totalPrice = order.TotalPrice();
        Assertions.assertEquals(2400.0, totalPrice);
    }

    @Test
    public void testTotalPriceWithDiscount() {
        Order order = new Order("Jane", Equipment.Екскаватор, 48, 90.0, true);
        double totalPrice = order.TotalPrice();
        Assertions.assertEquals(3888.0, totalPrice);
    }

    @Test
    public void testToString() {
        Order order = new Order("John", Equipment.Бульдозер, 24, 80.0, false);
        String expectedString = "Замовлення: Ім'я: John, Вид техніки: Бульдозер, Тип оренди: Подобова, Тривалість: 24 год, Вартість: 1920.0 грн";
        String orderString = order.toString();
        Assertions.assertEquals(expectedString, orderString);
    }
}