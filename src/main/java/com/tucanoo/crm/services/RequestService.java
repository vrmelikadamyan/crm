package com.tucanoo.crm.services;

import com.tucanoo.crm.data.entities.Request;
import com.tucanoo.crm.data.repositories.RequestRepository;
import com.tucanoo.crm.data.specifications.CustomerDatatableFilter;
import com.tucanoo.crm.data.specifications.RequestDatatableFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public Page<Request> getRequestsForDatatable(String queryString, String statusFilter, Pageable pageable) {

        RequestDatatableFilter requestDatatableFilter = new RequestDatatableFilter(queryString.toLowerCase(), statusFilter);

        return requestRepository.findAll(requestDatatableFilter, pageable);
    }
}
