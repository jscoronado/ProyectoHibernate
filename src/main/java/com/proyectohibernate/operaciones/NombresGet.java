/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.operaciones;

/**
 *
 * @author rafa
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.proyectohibernate.bean.Nombres;
import com.proyectohibernate.dao.NombresDao;

public class NombresGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                NombresDao oNombresDAO = new NombresDao();                             
                Nombres oNombres=oNombresDAO.get(Integer.parseInt(request.getParameter("id")));
                data = new Gson().toJson(oNombres);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("NombresGetJson: View Error: " + e.getMessage());
        }
    }
}