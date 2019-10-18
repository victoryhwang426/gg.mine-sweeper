package services;

import models.Col;
import models.Field;

import java.util.Random;

public class GenerateField {
    private Field field;

    public GenerateField(int row, int col, int totalMineCount){
        this.field = new Field(
                row,
                col,
                totalMineCount
        );
    }

    private Field injectMine(){
        Random random = new Random();
        int mineCnt = this.field.getMineCount();

        while(mineCnt > 0){
            int rowIndex = random.nextInt(this.field.getTotalRow());
            int colIndex = random.nextInt(this.field.getTotalCol());
            Col col = this.field.getRow(rowIndex).getCol(colIndex);

            if(col.isSafety()){
                col.setSafety(false);
                mineCnt--;
            }
        }

        return this.field;
    }

    public Field createField(){
        return injectMine();
    }
}
