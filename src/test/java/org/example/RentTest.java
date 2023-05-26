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
}
