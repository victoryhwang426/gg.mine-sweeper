package services;

import models.Col;
import models.Field;
import models.Row;

public class MineSweeperService {
    private Field field;
    private int totalSafetySpot;
    private int totalUsedSpot;

    public MineSweeperService(Field field){
        this.field = field;
        this.totalSafetySpot = this.field.getTotalRow() * this.field.getTotalCol() - this.field.getMineCount();
        this.totalUsedSpot = 0;
    }

    public boolean isCheckSpot(int requestRow, int requestCol){
        int rowIndex = requestRow - 1;
        int colIndex = requestCol - 1;
        this.totalUsedSpot += 1;

        Col col = this.field
                .getRow(rowIndex)
                .getCol(colIndex);
        col.setUsed(true);

        if(col.isMineZone() || isUsedAll()){
            return false;
        }

        int quantityMine = calculateMineNumber(rowIndex, colIndex);
        col.setMessage(" " + quantityMine + " ");

        return true;
    }

    private boolean isUsedAll(){
        return this.totalSafetySpot == this.totalUsedSpot;
    }

    public int calculateMineNumber(int rowIndex, int colIndex){
        int mineCnt = 0;
        int[][] checkMatrices = {
                {rowIndex-1, colIndex-1},
                {rowIndex-1, colIndex},
                {rowIndex-1, colIndex+1},
                {rowIndex, colIndex-1},
                {rowIndex, colIndex+1},
                {rowIndex+1, colIndex-1},
                {rowIndex+1, colIndex},
                {rowIndex+1, colIndex+1}
        };

        for(int metrics[] : checkMatrices){
            try {
                Col col = this.field.getRow(metrics[0]).getCol(metrics[1]);
                if(col.isMineZone()){
                    mineCnt += 1;
                }
            } catch (Exception e){
                mineCnt += 0;
            }
        }

        return mineCnt;
    }

    private void determineMessage(Col col,
                                  boolean isPlaying,
                                  int rowIndex,
                                  int colIndex){
        if(isPlaying){
            if(col.isUsed()){
                System.out.print(col.getMessage());
            } else {
                System.out.print(" - ");
            }
        } else {
            if(col.isMineZone()){
                System.out.print(" B ");
            } else {
                System.out.print(" " + calculateMineNumber(rowIndex, colIndex) + " ");
            }
        }
    }

    public void print(boolean isPlaying){
        int rowIndex = 0;
        for(Row row : this.field.getRows()){
            int colIndex = 0;
            for(Col col : row.getCols()){
                determineMessage(col, isPlaying, rowIndex, colIndex);
                colIndex += 1;
            }

            rowIndex += 1;
            System.out.println();
        }
    }
}
