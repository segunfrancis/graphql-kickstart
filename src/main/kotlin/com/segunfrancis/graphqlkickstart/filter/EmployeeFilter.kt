package com.segunfrancis.graphqlkickstart.filter

import lombok.Data

@Data
data class EmployeeFilter(
    val salary: FilterField? = null,
    val age: FilterField? = null,
    val position: FilterField? = null
)
