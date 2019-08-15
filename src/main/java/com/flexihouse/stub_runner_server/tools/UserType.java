package com.flexihouse.stub_runner_server.tools;

import wiremock.com.google.common.collect.Sets;

import java.util.Set;

public enum UserType {
    ADMIN, SECURITY_ADMIN, HOUSING_OFFICE_ADMIN, HOUSING_OFFICE_DISPATCHER, HOUSING_OFFICE_PLUMBER, SECURITY_OPERATOR, SECURITY_GUARD, FLAT_USER, INTERCOM;

    public static final Set<UserType> HO_TYPES = Sets.newHashSet(
            HOUSING_OFFICE_ADMIN,
            HOUSING_OFFICE_DISPATCHER,
            HOUSING_OFFICE_PLUMBER);

    public static final Set<UserType> SECURITY_COMPANY_TYPES = Sets.newHashSet(
            SECURITY_OPERATOR,
            SECURITY_GUARD,
            SECURITY_ADMIN);
}
