/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proyectohibernate.bean.Nombres;

import com.proyectohibernate.helper.Conexion;
import com.proyectohibernate.helper.EncodingUtil;

import com.proyectohibernate.dao.NombresDao;

/**
 *
 * @author rafa
 */
public class NombresSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            NombresDao oNombresDAO = new NombresDao();
            Nombres oNombres = new Nombres();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oNombres = gson.fromJson(jason, oNombres.getClass());
            Map<String, String> data = new HashMap<>();
            if (oNombres.getId() == 0 || oNombres.getId()==null) {
                oNombresDAO.create(oNombres);
            } else {
                oNombresDAO.set(oNombres);
            }
            data.put("status", "200");
            data.put("message", Integer.toString(oNombres.getId()));

            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("NombresSaveJson: View Error: " + e.getMessage());
        }
    }
}
