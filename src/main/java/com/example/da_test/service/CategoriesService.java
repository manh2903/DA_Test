package com.example.da_test.service;

import com.example.da_test.entities.Categories;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService extends BaseService<Categories>{

    @Override
    protected Class<Categories> clazz() {
        // TODO Auto-generated method stub
        return Categories.class;
    }



}
