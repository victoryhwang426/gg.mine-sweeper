package services;

import models.Col;
import models.Field;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateFieldTest {
    private GenerateField generateField;

    @Test
    public void createField_should_inject_mine_same_size_with_total_mine_count(){
        this.generateField = new GenerateField(10, 10, 10);
        Field field = this.generateField.createField();

        int actualMineCount = field.getMineCount();
        long expectedMineCount = field
                .getRows()
                .stream()
                .map(r -> r.getCols().stream().filter(Col::isMineZone).count())
                .count();

        assertEquals(actualMineCount, expectedMineCount);
    }
}