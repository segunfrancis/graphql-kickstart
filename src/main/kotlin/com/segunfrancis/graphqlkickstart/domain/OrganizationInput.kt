package com.segunfrancis.graphqlkickstart.domain

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class OrganizationInput(
    val name: String
)
