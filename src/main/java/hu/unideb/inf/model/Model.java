/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dani
 */
public class Model {

    private Fighter fighter;
    private Fighter fighter2;
    private Fighter fighter3;
    
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }
    
    private List<Fighter> list;

    public List<Fighter> getList() {
        return list;
    }

    public void setList(List<Fighter> list) {
        this.list = list;
    }

    public Model() {
       fighter = new Fighter("Mucsi", 20, 30, 1);
       fighter2 = new Fighter("Bödőcs",40,10, 1);
       fighter3 = new Fighter("Brendon",30,20, 1);
       list = new ArrayList<>();
       list.add(fighter);
       list.add(fighter2);
       list.add(fighter3);
       
        
    }
    
    
  
    
}
