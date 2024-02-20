package com.example.da_test.controller;


import com.example.da_test.entities.Categories;
import com.example.da_test.entities.User;
import com.example.da_test.service.CategoriesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public abstract class BaseController {


    private CategoriesService categoriesService;

    @ModelAttribute("isLogined")
    public boolean isLogined() {
        boolean isLogined = false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            isLogined = true;
        }
        return isLogined;
    }

    @ModelAttribute("userLogined")
    public User getUserLogined() {
        Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogined != null && userLogined instanceof UserDetails)
            return (User) userLogined;

        return null;
    }

    @ModelAttribute("categories")
    public List<Categories> getAllCategories() {
        return categoriesService.findAll();
    }

    @ModelAttribute("menus")
    public String getCategories() {
        return this.buildMenu();
    }

    private String buildMenu() {
        StringBuilder menu = new StringBuilder();
        return menu.toString();

    }


    public int getCurrentPage(HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            return 1;
        }
    }


    public Integer getInteger(HttpServletRequest request, String paramName) {
        try {
            return Integer.parseInt(request.getParameter(paramName));
        } catch (Exception e) {
            return null;
        }
    }


}
