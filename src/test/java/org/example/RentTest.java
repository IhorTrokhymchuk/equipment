package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class RentTest {
    private Rent rent;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        rent = new Rent();
        System.setOut(new PrintStream(output));
    }
    @Test
    public void testCreateOrder() {
        // Simulate user input
        String input = "John\n2\n1\nНі\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        rent.CreateOrder();
        Assertions.assertEquals(1, rent.orderList.size());
        Assertions.assertEquals("Введіть ім'я:\nВиберіть вид техніки:\n1. Кран\n2. Бульдозер\n3. Екскаватор\nВиберіть тип оренди:\n1. Подобова\n2. Довгострокова\nЧи є постійний клієнт? (Так/Ні)\nЗамовлення створено успішно!\n", output.toString());
    }
    @Test
    public void testViewOrderWithNoOrders() {
        rent.ViewOrder();
        Assertions.assertEquals("У вас немає жодного замовлення.\n", output.toString());
    }

    @Test
    public void testViewOrderWithOrders() {
        rent.orderList.add(new Order("John", Equipment.Екскаватор, 24, 90.0, false));
        rent.orderList.add(new Order("Jane", Equipment.Бульдозер, 48, 80.0, true));

        rent.ViewOrder();
        String expectedOutput = "Список замовлень:\n";
        expectedOutput += "Замовлення: Ім'я: John, Вид техніки: Екскаватор, Тип оренди: Подобова, Тривалість: 24 год, Вартість: 2160.0 грн\n";
        expectedOutput += "Замовлення: Ім'я: Jane, Вид техніки: Бульдозер, Тип оренди: Довгострокова, Тривалість: 48 год, Вартість: 3456.0 грн\n";

        Assertions.assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testGetPriceHour() {
        double priceHour1 = rent.GetPriceHour(Equipment.Кран);
        double priceHour2 = rent.GetPriceHour(Equipment.Бульдозер);
        double priceHour3 = rent.GetPriceHour(Equipment.Екскаватор);

        Assertions.assertEquals(100.0, priceHour1);
        Assertions.assertEquals(80.0, priceHour2);
        Assertions.assertEquals(90.0, priceHour3);
    }
}
