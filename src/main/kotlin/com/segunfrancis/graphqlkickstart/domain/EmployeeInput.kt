package com.segunfrancis.graphqlkickstart.domain

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class EmployeeInput(
    val firstName: String,
    val lastName: String,
    val position: String,
    val salary: Int,
    val age: Int,
    val departmentId: Int,
    val organizationId: Int
)
