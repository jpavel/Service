/*
 * Copyright 2015 KPMG N.V. (unless otherwise stated).
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package nl.kpmg.af.service.request;

import nl.kpmg.af.datamodel.dao.query.MongoQuery;
import nl.kpmg.af.service.exception.InvalidRequestException;
import nl.kpmg.af.service.request.filter.EdgeFilter;
import nl.kpmg.af.service.request.filter.location.Location;

import com.mongodb.DBObject;

/**
 * Top level request object for the edge service.
 *
 * @author Hoekstra.Maarten
 */
public final class EdgeRequest {
    /**
     * The maximum amount of objects to be returned.
     */
    private Integer limit = null;
    /**
     * The more complex filter parameters used to fetch only a subset of all objects.
     */
    private EdgeFilter filter = null;

    /**
     * Transforms this EdgeRequest object in its corresponding DBObject.
     *
     * @return EdgeRequest as a mongo query
     * @throws InvalidRequestException thrown if the request parameters aren't correctly interpretable.
     */
    public MongoQuery createMongoQuery() throws InvalidRequestException {
        MongoQuery query = new MongoQuery();
        DBObject queryComponents = query.getDBObj();
        if (filter != null) {
            Location location = filter.getLocation();
            if (location != null) {
                DBObject locationfilter = location.getMongoCondition();
                queryComponents.putAll(locationfilter);
            }
        }
        return query;
    }

    /**
     * @return The maximum amount of objects to be returned.
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit The maximum amount of objects to be returned.
     */
    public void setLimit(final Integer limit) {
        this.limit = limit;
    }

    /**
     * @return The more complex filter parameters used to fetch only a subset of all objects.
     */
    public EdgeFilter getFilter() {
        return filter;
    }

    /**
     * @param filter The more complex filter parameters used to fetch only a subset of all objects.
     */
    public void setFilter(final EdgeFilter filter) {
        this.filter = filter;
    }
}
