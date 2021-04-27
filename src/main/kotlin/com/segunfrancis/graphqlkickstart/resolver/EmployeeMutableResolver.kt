package com.segunfrancis.graphqlkickstart.resolver

import com.segunfrancis.graphqlkickstart.repository.DepartmentRepository
import com.segunfrancis.graphqlkickstart.repository.EmployeeRepository
import com.segunfrancis.graphqlkickstart.repository.OrganizationRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import com.segunfrancis.graphqlkickstart.domain.Employee
import com.segunfrancis.graphqlkickstart.domain.EmployeeInput
import org.springframework.stereotype.Component

@Component
class EmployeeMutableResolver(
    private val departmentRepository: DepartmentRepository,
    private val employeeRepository: EmployeeRepository,
    private val organizationRepository: OrganizationRepository
) : GraphQLMutationResolver {

    fun newEmployee(employeeInput: EmployeeInput): Employee {
        val department =
            departmentRepository.findById(employeeInput.departmentId).get()
        val organization =
            organizationRepository.findById(employeeInput.organizationId).get()
        return employeeRepository.save(
            Employee(
                null,
                employeeInput.firstName,
                employeeInput.lastName,
                employeeInput.position,
                employeeInput.age,
                employeeInput.salary,
                department,
                organization
            )
        )
    }
}
