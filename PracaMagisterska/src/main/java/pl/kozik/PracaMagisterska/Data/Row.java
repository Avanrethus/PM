/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kozik.PracaMagisterska.Data;

/**
 *
 * @author Avanrethus
 */
public class Row {
    public Att[] attributes;
    public Att decision;

    public Att[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Att[] attributes) {
        this.attributes = attributes;
    }

    public Att getDecision() {
        return decision;
    }

    public void setDecision(Att decision) {
        this.decision = decision;
    }
    
    
}
