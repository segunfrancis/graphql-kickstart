package com.segunfrancis.graphqlkickstart.resolver

import com.segunfrancis.graphqlkickstart.repository.EmployeeRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import com.segunfrancis.graphqlkickstart.domain.Employee
import org.springframework.data.jpa.domain.Specification
import com.segunfrancis.graphqlkickstart.filter.EmployeeFilter
import com.segunfrancis.graphqlkickstart.filter.FilterField
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Component
class EmployeeQueryResolver(private val repository: EmployeeRepository) :
    GraphQLQueryResolver {

    fun employees(): Iterable<Employee?>? {
        return repository.findAll()
    }

    fun employeesWithFilter(filter: EmployeeFilter): Iterable<Employee?>? {
        var spec: Specification<Employee?>? = null
        if (filter.salary != null) spec = bySalary(filter.salary)
        if (filter.age != null) spec =
            spec?.and(byAge(filter.age)) ?: byAge(filter.age)
        if (filter.position != null) spec =
            spec?.and(byPosition(filter.position))
                ?: byPosition(filter.position)
        return if (spec != null) repository.findAll(spec) else repository.findAll()
    }

    fun employee(id: Int): Employee {
        return repository.findById(id).get()
    }

    private fun bySalary(filterField: FilterField): Specification<Employee?> {
        return Specification { root: Root<Employee?>, _: CriteriaQuery<*>?, builder: CriteriaBuilder? ->
            filterField.generateCriteria(builder!!, root.get("salary"))
        }
    }

    private fun byAge(filterField: FilterField): Specification<Employee?> {
        return Specification { root: Root<Employee?>, _: CriteriaQuery<*>?, builder: CriteriaBuilder? ->
            filterField.generateCriteria(builder!!, root.get("age"))
        }
    }

    private fun byPosition(filterField: FilterField): Specification<Employee?> {
        return Specification { root: Root<Employee?>, _: CriteriaQuery<*>?, builder: CriteriaBuilder? ->
            filterField.generateCriteria(builder!!, root.get("position"))
        }
    }
}
