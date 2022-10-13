package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.customexception.DatabaseNotFound;
import com.ideas2it.model.Trainer;
import com.ideas2it.model.Trainee;

/**
 * EmployeeDao manage insert, retrieve, delete and update operation
 *
 * @version 1.0 01-09-2022
 *
 * @author Rohit A P
 */
public class EmployeeDao {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private Session session = null;
    /**
     * 
     * add trainer details to database
     * 
     * @param trainer
     * @return void
     */
    public int insertTrainer(Trainer trainer) throws DatabaseNotFound {
        int id;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (int) session.save(trainer);
            transaction.commit();
        } catch(HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * 
     * add trainee details to database
     * 
     * @param Trainee trainee
     * @return void
     */
    public int insertTrainee(Trainee trainee) throws DatabaseNotFound {
        int id;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (int) session.save(trainee);
            transaction.commit();
        } catch(HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }  
        return id;
    }

    /**
     * 
     * shows every trainer detail
     * 
     * @param
     * @return trainers
     */
    public List<Trainer> viewAllTrainer() throws DatabaseNotFound {
        List<Trainer> trainers = new ArrayList<Trainer>();
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
            Query<Trainer> query = session.createQuery("from Trainer");
            trainers = query.list();
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return trainers;
    }

    /**
     * 
     * shows every trainee detail
     * 
     * @param
     * @return trainees
     */
    public List<Trainee> viewAllTrainee() throws DatabaseNotFound {
        List<Trainee> trainees = new ArrayList<Trainee>();
        Transaction transaction = null; 
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
            Query<Trainee> query = session.createQuery("from Trainee");
            trainees = query.list();
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return trainees;
    }

    /**
     * 
     * shows every trainee detail with given name
     * 
     * @param name
     * @return trainees
     */
    @SuppressWarnings("unchecked")
    public List<Trainee> SearchTraineeByName(String name) throws DatabaseNotFound {
        List<Trainee> trainees = new ArrayList<Trainee>();
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "from Trainee where name like :name";
            Query<Trainee> query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            trainees = query.list();
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return trainees;
    }

    /**
     * 
     * delete trainer detail
     * 
     * @param id
     * @return isIdExist
     */
    public boolean deleteTrainerById(int id) throws DatabaseNotFound {
        Transaction transaction = null;
        boolean isIdExist = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Trainer trainer = session.get(Trainer.class, id);
            session.delete(trainer);
            trainer = session.get(Trainer.class, id);
            if(trainer == null) {
                isIdExist = true;
            }
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return isIdExist;
    }

    /**
     * 
     * delete trainee detail
     * 
     * @param id
     * @return isIdExist
     */
    public boolean deleteTraineeById(int id) throws DatabaseNotFound {
        Transaction transaction = null;
        boolean isIdExist = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Trainee trainee = session.get(Trainee.class, id);
            session.delete(trainee);
            trainee = session.get(Trainee.class, id);
            if(trainee == null) {
                isIdExist = true; 
            }
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return isIdExist;
    }

    /**
     * 
     * update Employee
     * 
     * @param employee
     * @return void
     */
    public void updateTrainerById(Trainer trainer) throws DatabaseNotFound {
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(trainer);
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
    }

    /**
     * 
     * update Trainee
     * 
     * @param trainee
     * @return void
     */
    public void updateTraineeById(Trainee trainee) throws DatabaseNotFound {
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(trainee);
            transaction.commit();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
    }

    /**
     * 
     * gets trainer profile by getting trainer id
     * 
     * @param id
     * @return trainer
     */
    public Trainer getTrainerById(int id) throws DatabaseNotFound {
        Trainer trainer = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            trainer = session.get(Trainer.class, id);
            transaction.commit();
            session.close();
        } catch (HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return trainer;
    }

    /**
     * 
     * gets trainee profile by getting trainee id
     * 
     * @param id
     * @return trainee
     */
    public Trainee getTraineeById(int id) throws DatabaseNotFound {
        Trainee trainee = null;
        Transaction transaction = null;
        try { 
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            trainee = session.get(Trainee.class, id);
            transaction.commit();
        } catch(HibernateException exception) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DatabaseNotFound("Server under maintenance");
        } finally {
            session.close();
        }
        return trainee;
    }

}