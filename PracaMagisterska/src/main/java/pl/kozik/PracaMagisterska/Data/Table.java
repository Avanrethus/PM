/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kozik.PracaMagisterska.Data;
import java.util.List;

/**
 *
 * @author Avanrethus
 */
public class Table {
    public Row[] rows;
    public int p = -1;
    public int pos = 0;
    public boolean deg;
    public List<Att> subTableAtt;
    
    public void createTable(Row r){
        rows[pos] = r;
        pos++;
    }
}
