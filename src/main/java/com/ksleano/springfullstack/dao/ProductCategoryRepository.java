package com.ksleano.springfullstack.dao;

import com.ksleano.springfullstack.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

// without the annotation, spring will configure the path to "productCategories"
// If you want to specify the path, use the annotation @RepositoryRestResource
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
