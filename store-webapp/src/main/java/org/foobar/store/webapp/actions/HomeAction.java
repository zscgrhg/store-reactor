/*
 *   PALO IT source code:
 *   ======================
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *  
        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   Links:
 *   ======
 *   Git      : https://github.com/Palo-IT/Devoxx2014Raspberry
 */
package org.foobar.store.webapp.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.foobar.store.commons.exceptions.DaoException;
import org.foobar.store.model.entities.Category;
import org.foobar.store.model.entities.Product;
import org.foobar.store.services.catergory.CategoryService;
import org.foobar.store.services.product.ProductService;

/**
 * HomeAction
 * 
 * @author pguillerm
 * @since 1 févr. 2015
 */
@RequestScoped
@Named
public class HomeAction implements Serializable {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = 1245407110480864441L;

    @Inject
    private CategoryService   categoryService;

    @Inject
    private ProductService    productService;

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public List<Category> getCategories() throws DaoException {
        return categoryService.findAll(Category.class);
    }
    
    public List<Product> getSelectedProducts(){
        return productService.getSelectedProducts();
    }
    
    public List<Product> getBestSellerProducts(){
        return productService.getBestSellerProducts();
    }
}
