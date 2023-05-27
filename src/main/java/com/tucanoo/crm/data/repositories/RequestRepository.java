package com.tucanoo.crm.data.repositories;

import com.tucanoo.crm.data.entities.Customer;
import com.tucanoo.crm.data.entities.Request;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends PagingAndSortingRepository<Request, Long>, JpaSpecificationExecutor<Request> {
}
