package com.basis.colatina.taskmanager.service.filter;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class TaskFilter extends DefaultFilter implements BaseFilter, Serializable {
    @Override
    public BoolQueryBuilder getFilter() {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        addMustTermQuery(queryBuilder, query, "expectedStartDate");
        addMustTermQuery(queryBuilder, query, "expectedEndDate");
        addMustTermQuery(queryBuilder, query, "startDate");
        addMustTermQuery(queryBuilder, query, "endDate");
        ad

        filterFields(new ArrayList<>(), query, );

        return queryBuilder;
    }
}
