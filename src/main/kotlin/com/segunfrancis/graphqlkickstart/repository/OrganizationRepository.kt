package com.segunfrancis.graphqlkickstart.repository

import com.segunfrancis.graphqlkickstart.domain.Organization
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

interface OrganizationRepository : CrudRepository<Organization, Int>,
    JpaSpecificationExecutor<Organization> {

}