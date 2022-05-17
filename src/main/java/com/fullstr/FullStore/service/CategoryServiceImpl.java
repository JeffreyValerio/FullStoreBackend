package com.fullstr.FullStore.service;

import java.util.List;

import com.fullstr.FullStore.dao.iCategoryRepository;
import com.fullstr.FullStore.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public iCategoryRepository iCategoryRepository;

    public List<Category> getCategories() {
        return iCategoryRepository.findAll();
    }
}
