/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;


/**
 *
 * @author Dani
 */
public class Model {

    private Fighter fighter;
    private Fighter fighter2;

    public Fighter getFighter() {
        return fighter;
    }
    
    public Fighter getFighter2() {
        return fighter2;
    }

    public Model() {
        fighter = new Fighter("DOM", 11, 25, 1);
        fighter2 = new Fighter("ÁKOS",30,10, 1);
    }
    
   
    
}
