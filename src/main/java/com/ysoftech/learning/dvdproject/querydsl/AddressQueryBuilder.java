package com.ysoftech.learning.dvdproject.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import com.ysoftech.learning.dvdproject.entity.Address;
import com.ysoftech.learning.dvdproject.entity.QAddress;
import com.ysoftech.learning.dvdproject.entity.QCity;
import com.ysoftech.learning.dvdproject.entity.QCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AddressQueryBuilder {

    @PersistenceContext
    private EntityManager em;

    // Step 1: Entity QType ke instance ko declare kare.

    // Step 2: Query Object ko create karein.

    // Step 3: Query ke select and from clause add karein.

    // Step 4: query ke predicates add karein.

    // Step 5: query execute karein using fetch() or fetchOne().


    public JPAQuery<Address> buildAddressQuery() {
        // Step 1: QType entity declaration
        QAddress qAddress = QAddress.address1;
        QCity qCity = QCity.city1;
        QCountry qCountry = QCountry.country1;

        // Step 2: Query Object
        JPAQuery<Address> jPAQuery = new JPAQuery<>(em);

        // Step 3: Query clause
        jPAQuery.select(qAddress)
                .from(qAddress)
                .join(qAddress.city, qCity).fetchJoin()
                .join(qCity.country, qCountry).fetchJoin();

        // Step 4: Predicates

        // Step 5: Fetch
        return jPAQuery;
    }

}