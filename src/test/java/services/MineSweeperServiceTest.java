package services;

import models.Field;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MineSweeperServiceTest {
    private MineSweeperService mineSweeperService;

    private GenerateField generateField;

    private Field field;

    @Before
    public void setup(){
        generateField = new GenerateField(3, 3, 9);
        field = generateField.createField();
        mineSweeperService = new MineSweeperService(field);
    }


    @Test
    public void calculateMineNumber_should_return_mine_count_around_selected_cell(){
        int mineCount = mineSweeperService.calculateMineNumber(0,0);

        assertEquals(3, mineCount);
    }
}