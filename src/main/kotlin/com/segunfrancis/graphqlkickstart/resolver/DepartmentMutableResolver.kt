package com.segunfrancis.graphqlkickstart.resolver

import com.segunfrancis.graphqlkickstart.domain.Department
import com.segunfrancis.graphqlkickstart.domain.DepartmentInput
import com.segunfrancis.graphqlkickstart.repository.OrganizationRepository
import com.segunfrancis.graphqlkickstart.repository.DepartmentRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class DepartmentMutableResolver (
    var departmentRepository: DepartmentRepository,
    var organizationRepository: OrganizationRepository
) : GraphQLMutationResolver {

    fun newDepartment(departmentInput: DepartmentInput): Department {
        val organization =
            organizationRepository.findById(departmentInput.organizationId).get()
        return departmentRepository.save(
            Department(
                null,
                departmentInput.name,
                null,
                organization
            )
        )
    }
}