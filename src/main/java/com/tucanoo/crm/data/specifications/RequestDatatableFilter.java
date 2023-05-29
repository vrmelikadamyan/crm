package com.tucanoo.crm.data.specifications;

import com.tucanoo.crm.data.entities.Customer;
import com.tucanoo.crm.data.entities.Request;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestDatatableFilter implements org.springframework.data.jpa.domain.Specification<Request> {

    String userQuery;
    String statusFilter;

    @Override
    public Predicate toPredicate(Root<Request> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        ArrayList<Predicate> predicates = new ArrayList<>();
        Join<Request, Customer> join = root.join("customer", JoinType.LEFT);

        if (statusFilter.equals("REGISTERED")) {
            predicates.add(criteriaBuilder.like(root.get("status"), '%' + "Зарегистрирована" + '%'));
        }

        if (statusFilter.equals("IN_PROGRESS")) {
            predicates.add(criteriaBuilder.like(root.get("status"), '%' + "В обработке" + '%'));
        }

        if (statusFilter.equals("COMPLETED")) {
            predicates.add(criteriaBuilder.like(root.get("status"), '%' + "Выполнена" + '%'));
        }

        if (userQuery != null && userQuery != "") {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), '%' + userQuery + '%'));
//            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("phoneNumber")), '%' + userQuery + '%'));
//            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(join.get("firstName")), '%' + userQuery + '%'));
//            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(join.get("lastName")), '%' + userQuery + '%'));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), '%' + userQuery + '%'));
//            predicates.add(criteriaBuilder.like(root.get("startDate"), '%' + userQuery + '%'));
//            predicates.add(criteriaBuilder.like(root.get("endDate"), '%' + userQuery + '%'));
//            predicates.add(criteriaBuilder.like(root.get("grade"), '%' + userQuery + '%'));
        }

        return (! predicates.isEmpty() ? criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])) : null);
    }
}