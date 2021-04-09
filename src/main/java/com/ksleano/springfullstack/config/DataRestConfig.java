package com.ksleano.springfullstack.config;

import com.ksleano.springfullstack.entity.Product;
import com.ksleano.springfullstack.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Restrict HTTP methods. Essentially make it READ ONLY
 */
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        //disable unsupported HTTP methods for Product: PUT, POST, DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, a) -> a.disable(unsupportedActions))
                .withCollectionExposure((metdata, b) -> b.disable(unsupportedActions));

        //disable unsupported HTTP methods for ProductCategory: PUT, POST, DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, a) -> a.disable(unsupportedActions))
                .withCollectionExposure((metdata, b) -> b.disable(unsupportedActions));
    }

}
