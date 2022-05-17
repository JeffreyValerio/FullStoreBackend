package com.fullstr.FullStore.config;

import com.fullstr.FullStore.entity.Address;
import com.fullstr.FullStore.entity.Brand;
import com.fullstr.FullStore.entity.Category;
import com.fullstr.FullStore.entity.Country;
import com.fullstr.FullStore.entity.Customer;
import com.fullstr.FullStore.entity.Email;
import com.fullstr.FullStore.entity.Image;
import com.fullstr.FullStore.entity.Order;
import com.fullstr.FullStore.entity.OrderItem;
import com.fullstr.FullStore.entity.Product;
import com.fullstr.FullStore.entity.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;

    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsoppertedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH };

        // disable HTTP methods for : PUT, POST, DELETE and PATCH
        disableHttpMethods(Address.class, config, theUnsoppertedActions);
        disableHttpMethods(Brand.class, config, theUnsoppertedActions);
        disableHttpMethods(Category.class, config, theUnsoppertedActions);
        disableHttpMethods(Country.class, config, theUnsoppertedActions);
        disableHttpMethods(Customer.class, config, theUnsoppertedActions);
        disableHttpMethods(Email.class, config, theUnsoppertedActions);
        disableHttpMethods(Image.class, config, theUnsoppertedActions);
        disableHttpMethods(Order.class, config, theUnsoppertedActions);
        disableHttpMethods(OrderItem.class, config, theUnsoppertedActions);
        disableHttpMethods(Product.class, config, theUnsoppertedActions);
        disableHttpMethods(State.class, config, theUnsoppertedActions);

        // call an internal helper method
        exposeIds(config);

        // configure cors mapping
        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class<?> theClass, RepositoryRestConfiguration config,
            HttpMethod[] theUnsopportedActions) {
        // disable HTTP methods for State: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsopportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsopportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids
        // get a list of all entity clases from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of the entity types
        List<Class<?>> entityClases = new ArrayList<>();

        // get the entity types for the entities
        for (EntityType<?> tempEntityType : entities) {
            entityClases.add(tempEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class<?>[] domainTypes = entityClases.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

}