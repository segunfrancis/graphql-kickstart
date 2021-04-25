package com.segunfrancis.graphqlkickstart.repository

import com.segunfrancis.graphqlkickstart.domain.Department
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

interface DepartmentRepository : CrudRepository<Department, Int>, JpaSpecificationExecutor<Department> {
}
