package models;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Col> cols;

    public Row(int totalCol){
        this.cols = new ArrayList<>();
        for(int i=0; i<totalCol; i++){
            cols.add(new Col(true, false));
        }
    }

    public List<Col> getCols() {
        return cols;
    }

    public Col getCol(int index){
        return this.cols.get(index);
    }
}
