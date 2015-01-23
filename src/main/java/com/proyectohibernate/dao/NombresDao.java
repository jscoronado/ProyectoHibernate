/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.dao;

import java.util.ArrayList;
import java.util.List;
import com.proyectohibernate.bean.Nombres;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rafa
 */
public class NombresDao extends GenericDaoImplementation<Nombres> {

//    public ArrayList<String> getColumnsNames() {
//        ArrayList<String> vector = new ArrayList<>();
//        vector.add("id");
//        vector.add("nombre");
//        vector.add("ape1");
//        vector.add("ape2");
//        vector.add("email");
//        return vector;
//    }

    public Nombres getFromLogin(String nombre,String apellido) { //public TIPO_ENTIDAD read(TIPO_ENTIDAD entity) {
        Nombres oNombres;

        Session sesion = null;
        //Class<Usuario> tipo = (Class<Usuario>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = sesion.createCriteria(Nombres.class);

            criteria.add(Restrictions.eq("nombre", nombre));
            criteria.add(Restrictions.eq("apellido", apellido));

            criteria.setMaxResults(1);
            List<Nombres> results = criteria.list();
            if (results.size() > 0) {
                return results.get(0);
            } else {
                return new Nombres();
            }
        } catch (HibernateException he) {
            throw new HibernateException("Error en read DAO", he);
        } finally {
            sesion.close();
        }

    }
}
