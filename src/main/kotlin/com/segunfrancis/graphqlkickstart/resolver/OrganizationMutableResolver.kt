package com.segunfrancis.graphqlkickstart.resolver

import com.segunfrancis.graphqlkickstart.domain.Organization
import com.segunfrancis.graphqlkickstart.domain.OrganizationInput
import com.segunfrancis.graphqlkickstart.repository.OrganizationRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class OrganizationMutableResolver(private val repository: OrganizationRepository) :
    GraphQLMutationResolver {

    fun newOrganization(organizationInput: OrganizationInput): Organization {
        return repository.save(
            Organization(
                id = null,
                name = organizationInput.name,
                departments = null,
                employees = null
            )
        )
    }
}
