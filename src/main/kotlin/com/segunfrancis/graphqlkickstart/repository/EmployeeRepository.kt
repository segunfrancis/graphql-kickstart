package com.segunfrancis.graphqlkickstart.repository

import com.segunfrancis.graphqlkickstart.domain.Employee
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<Employee, Int>, JpaSpecificationExecutor<Employee> {
}
