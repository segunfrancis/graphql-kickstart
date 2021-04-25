package com.segunfrancis.graphqlkickstart.domain

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class EmployeeInput(
    private val firstName: String? = null,
    private val lastName: String? = null,
    private val position: String? = null,
    private val salary: Int? = null,
    private val age: Int? = null,
    private val departmentId: Int? = null,
    private val organizationId: Int? = null
)
