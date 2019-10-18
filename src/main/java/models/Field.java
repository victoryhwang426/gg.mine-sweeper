package models;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int totalRow;
    private int totalCol;
    private int mineCount;
    private List<Row> rows;

    public Field(int totalRow, int totalCol, int mineCount){
        this.totalRow = totalRow;
        this.totalCol = totalCol;
        this.mineCount = mineCount;

        this.rows = new ArrayList<>();
        for(int i=0; i<totalCol; i++){
            this.rows.add(new Row(totalCol));
        }
    }

    public int getTotalRow() {
        return totalRow;
    }

    public int getTotalCol() {
        return totalCol;
    }

    public int getMineCount() {
        return mineCount;
    }

    public List<Row> getRows() {
        return rows;
    }

    public Row getRow(int index){
        return this.rows.get(index);
    }
}
