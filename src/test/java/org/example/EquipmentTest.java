package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquipmentTest {
    @Test
    public void testEquipmentValues() {
        Equipment[] equipment = Equipment.values();
        Assertions.assertEquals(3, equipment.length);
        Assertions.assertEquals(Equipment.Кран, equipment[0]);
        Assertions.assertEquals(Equipment.Бульдозер, equipment[1]);
        Assertions.assertEquals(Equipment.Екскаватор, equipment[2]);
    }
}