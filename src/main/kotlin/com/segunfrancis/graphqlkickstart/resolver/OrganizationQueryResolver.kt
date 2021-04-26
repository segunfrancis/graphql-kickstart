package com.segunfrancis.graphqlkickstart.resolver

import com.segunfrancis.graphqlkickstart.domain.Organization
import com.segunfrancis.graphqlkickstart.repository.OrganizationRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class OrganizationQueryResolver(private val repository: OrganizationRepository) :
    GraphQLQueryResolver {

    fun organizations(): Iterable<Organization> {
        return repository.findAll()
    }

    fun organization(id: Int): Organization {
        return repository.findById(id).orElseThrow {
            NoSuchElementException("Organization with id:$id was not found")
        }
    }
}
