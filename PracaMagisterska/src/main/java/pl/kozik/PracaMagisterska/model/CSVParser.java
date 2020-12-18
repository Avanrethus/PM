/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kozik.PracaMagisterska.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kozik.PracaMagisterska.commons.FileResponse;

/**
 *
 * @author Avanrethus
 */
public class CSVParser {
    public List<List<String>> readCSVFileAllLines(FileResponse fileData){
        List<List<String>> allData = new ArrayList<List<String>>();
        try(CSVReader csvR = new CSVReader(new FileReader(fileData.getName()))){
            String[] values = null;
            while((values = csvR.readNext()) != null){
                allData.add(Arrays.asList(values));
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        return allData;
    }
    
    public String readCSVFileSingleLine(FileResponse fileData){
        String line = "";
        try { 
            
        FileReader filereader = new FileReader(fileData.getName()); 
  
        CSVReader csvReader = new CSVReader(filereader); 
        String[] nextRecord; 
        
        while ((nextRecord = csvReader.readNext()) != null) { 
            for (String cell : nextRecord) { 
                line = cell +"\t";
            } 
        }
      
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
    } 
        return line;
        
    }
    
    public static int countLines(FileResponse fileData){
       int count = 0;
       FileReader filereader = null; 
        try {
            filereader = new FileReader(fileData.getName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CSVReader csvReader = new CSVReader(filereader);
        try {
            while(csvReader.readNext() != null){
                count++;
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
            return count;

   }
}
