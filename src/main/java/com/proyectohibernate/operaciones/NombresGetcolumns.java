/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.operaciones;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proyectohibernate.dao.NombresDao;

/**
 *
 * @author rafa
 */
public class NombresGetcolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<String> alColumns = null;
        try {
            NombresDao oNombresDAO = new NombresDao();
            alColumns = (ArrayList<String>) oNombresDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            //String data = "{\"data\":" + "[\"id\",\"nombre\",\"ape1\",\"ape2\",\"email\"]" + "}";
             data = "{\"data\":" + data + "}";
            return data;
        } catch (Exception e) {
            throw new ServletException("NombresGetcolumnsJson: View Error: " + e.getMessage());
        }
    }

}
