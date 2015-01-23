/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectohibernate.operaciones;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proyectohibernate.dao.NombresDao;

import com.proyectohibernate.helper.Conexion;
import com.proyectohibernate.helper.FilterBean;

/**
 *
 * @author rafa
 */
public class NombresGetregisters implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;
        try {
            ArrayList<FilterBean> alFilter = new ArrayList<>();
            if (request.getParameter("filter") != null) {
                if (request.getParameter("filteroperator") != null) {
                    if (request.getParameter("filtervalue") != null) {
                        FilterBean oFilterBean = new FilterBean();
                        oFilterBean.setFilter(request.getParameter("filter"));
                        oFilterBean.setFilterOperator(request.getParameter("filteroperator"));
                        oFilterBean.setFilterValue(request.getParameter("filtervalue"));
                        oFilterBean.setFilterOrigin("user");
                        alFilter.add(oFilterBean);
                    } 
                } 
            } 
            if (request.getParameter("systemfilter") != null) {
                if (request.getParameter("systemfilteroperator") != null) {
                    if (request.getParameter("systemfiltervalue") != null) {
                        FilterBean oFilterBean = new FilterBean();
                        oFilterBean.setFilter(request.getParameter("systemfilter"));
                        oFilterBean.setFilterOperator(request.getParameter("systemfilteroperator"));
                        oFilterBean.setFilterValue(request.getParameter("systemfiltervalue"));
                        oFilterBean.setFilterOrigin("system");
                        alFilter.add(oFilterBean);
                    }
                }
            }       
            NombresDao oNombresDAO = new NombresDao();
            int pages = oNombresDAO.getCount(alFilter);
            data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
            //data = "{\"data\":\"100\"}";
            return data;
        } catch (Exception e) {
            throw new ServletException("NombresGetregistersJson: View Error: " + e.getMessage());
        }
    }
}
