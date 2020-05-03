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
public class FighterDAOclass implements FighterDAO {

    Session session;
    Transaction transaction;

    public FighterDAOclass() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void close() {
        session.close();
        System.out.println("DAO is closed.");
    }

    public void saveFighter(Fighter f) {
        try {
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteFighter(Fighter f) {
        try {
            transaction = session.beginTransaction();
            session.remove(f);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void updateFighter(Fighter f) {
        try {
            transaction = session.beginTransaction();
            session.update(f);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Fighter> getFighters() {
        String hql = "FROM hu.unideb.inf.model.Fighter";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
