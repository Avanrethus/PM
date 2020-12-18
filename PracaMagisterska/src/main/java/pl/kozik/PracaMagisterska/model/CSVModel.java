/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kozik.PracaMagisterska.model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kozik.PracaMagisterska.Data.Att;
import pl.kozik.PracaMagisterska.Data.Row;
import pl.kozik.PracaMagisterska.Data.Table;
import pl.kozik.PracaMagisterska.commons.FileResponse;

/**
 *
 * @author Avanrethus
 */
public class CSVModel {
    public FileResponse fr = new FileResponse();
    public CSVParser csvp;
    public String filename = fr.getName();
    public String sep = ",";
    public String[] names;
    public int numOfAtt;
    static List<Att> allAtt = new ArrayList<Att>();
    static List<Att[]> listOfAtt;
    static List<Table> subTables;
    static int numOfRows;
    List<Table> allTables;
    
   public Att addAttribute(String name, String value){
       for(Att a1: allAtt){
           if(a1.name == name && a1.value == value){
               return a1;
           }
       }
       Att a2 = new Att();
       a2.name = name;
       a2.value = value;
       allAtt.add(a2);
       return a2;
   }
   
   
   
   public List<Table> uploadData(String fileName, String sep) throws IOException, CsvValidationException{
       List<Table> tables = new ArrayList<Table>();
       List<Row> rows = new ArrayList<Row>();
       numOfRows = CSVParser.countLines(fr);
       Att[][] table = new Att[numOfRows][];
       int i = 0;
       
       try {
            CSVReader csvR = new CSVReader(new FileReader(this.filename));
            var line = csvR.readNext();
            names = line.toString().split(sep);
            while(csvR.readNext() != null){
                line = csvR.readNext();
                var values = line.toString().split(sep);
                numOfAtt = names.length;
                table[i] = new Att[names.length];
                for(int j = 0; j<names.length; j++){
                    table[i][j] = addAttribute(names[j],values[j]);
                }
                i++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        for( i = 0; i<table[0].length;i++){
            listOfAtt = new ArrayList<Att[]>();
            if(tables.size() != table[0].length){
                Table tab = new Table();
                tab.rows = new Row[table.length];
                tab.deg = false;
                tables.add(tab);
            }
        }    
        for(int j = 0; j<table.length;j++){
            Row row = new Row();
            Att[] atts = new Att[table[0].length-1];
            Att dec = new Att();
            int pos = 0;
            for(int k = 0; k<table[j].length;k++){
                if(i != k){
                    atts[pos] = table[j][k];
                    pos++;
                }
                if(i == k){
                    dec = table[j][k];
                }
            }
            row.attributes = addAttributes(atts);
            row.decision = dec;
            tables.get(i).createTable(row);
            tables.get(i).subTableAtt = new ArrayList<Att>();
            
        }

       return tables;
   }
   
   public Table generateSubtables(Table t, Att a, int subNr){
       Table subTab = new Table();
       subTab.rows = new Row[t.pos];
       List<Att> attOfSubTab = new ArrayList<Att>(t.subTableAtt);
       attOfSubTab.add(a);
       if(subTables.get(subNr) == null){
            subTables = new ArrayList<Table>();
       }
       for(Table tab : subTables){
           if(tab.subTableAtt.size() == attOfSubTab.size()){
               int i = 0;
               for(Att at: attOfSubTab){
                   if(tab.subTableAtt.contains(at)){
                       i++;
                   }
                   else{
                       break;
                   }
               }
               if(i == tab.subTableAtt.size()){
                   return tab;
               }
           }
       }
       
       for(int i = 0; i < t.pos; i++){
           boolean add = false;
           attOfSubTab = new ArrayList<Att>(t.subTableAtt);
           for(Att att : t.rows[i].attributes){
               if(att == a){
                   add = true;
                   attOfSubTab.add(a);
                   break;
               }
           }
           if(add){
               subTab.createTable(t.rows[i]);
               subTab.subTableAtt = attOfSubTab;
           }
       }
       subTables.set(subNr, subTab);
       return subTab;
   }
   public Att[] addAttributes(Att[] atts){
       boolean exists = false;
       for(Att[] a : listOfAtt){
           exists = true;
           for(int i = 0; i < a.length; i++){
               if(a[i] != atts[i]){
                   exists = false;
                   break;
               }
           }
           if(exists){
               return a;
           }
       }
       listOfAtt.add(atts);
       return atts;
   }
}
