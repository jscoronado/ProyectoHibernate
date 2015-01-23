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

import com.proyectohibernate.dao.NombresDao;

/**
 *
 * @author rafa
 */
public class NombresRemove implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            NombresDao oNombresDAO = new NombresDao();
            Nombres oNombres = new Nombres();
            oNombres.setId(Integer.parseInt(request.getParameter("id")));
            Map<String, String> data = new HashMap<>();
            oNombresDAO.remove(oNombres);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id=" + oNombres.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("NombresRemoveJson: View Error: " + e.getMessage());
        }
    }
}
