package com.segunfrancis.graphqlkickstart.resolver

import com.segunfrancis.graphqlkickstart.domain.Department
import com.segunfrancis.graphqlkickstart.repository.DepartmentRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import com.segunfrancis.graphqlkickstart.domain.Organization
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Fetch
import javax.persistence.criteria.Join
import javax.persistence.criteria.JoinType
import javax.persistence.criteria.Root
import com.segunfrancis.graphqlkickstart.domain.Employee
import java.util.NoSuchElementException

@Component
class DepartmentQueryResolver(private val repository: DepartmentRepository) :
    GraphQLQueryResolver {

    fun departments(environment: DataFetchingEnvironment): Iterable<Department> {
        val s = environment.selectionSet
        return if (s.contains("employees") && !s.contains("organization"))
            repository.findAll(fetchEmployees())
        else if (!s.contains("employees") && s.contains("organization"))
            repository.findAll(fetchOrganization())
        else if (s.contains("employees") && s.contains("organization"))
            repository.findAll(fetchEmployees().and(fetchOrganization()))
        else
            repository.findAll()
    }

    fun department(id: Int, environment: DataFetchingEnvironment): Department {
        var spec = byId(id)
        val selectionSet = environment.selectionSet
        if (selectionSet.contains("employees")) spec = spec.and(fetchEmployees())
        if (selectionSet.contains("organization")) spec = spec.and(fetchOrganization())
        return repository.findOne(spec).orElseThrow { NoSuchElementException() }
    }

    @Suppress("UNCHECKED_CAST")
    private fun fetchOrganization(): Specification<Department?> {
        return Specification { root: Root<Department?>, _: CriteriaQuery<*>?, _: CriteriaBuilder? ->
            val f: Fetch<Department, Organization> =
                root.fetch("organization", JoinType.LEFT)
            val join: Join<Department, Organization> = f as Join<Department, Organization>
            join.on
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun fetchEmployees(): Specification<Department?> {
        return Specification { root: Root<Department?>, _: CriteriaQuery<*>?, _: CriteriaBuilder? ->
            val f = root.fetch<Department, Employee>("employees", JoinType.LEFT)
            val join = f as Join<Department, Employee>
            join.on
        }
    }

    private fun byId(id: Int): Specification<Department?> {
        return Specification { root: Root<Department?>, _: CriteriaQuery<*>?, builder: CriteriaBuilder ->
            builder.equal(root.get<Any>("id"), id)
        }
    }
}
