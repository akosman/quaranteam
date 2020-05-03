/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.util.List;
import hu.unideb.inf.model.Fighter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author mandi
 */
public interface FighterDAO extends AutoCloseable{
    public void saveFighter(Fighter f);
    public void deleteFighter(Fighter f);
    public void updateFighter(Fighter f);    
    public List<Fighter> getFighters();
    
    @Override
    default public void close(){
    }
}
