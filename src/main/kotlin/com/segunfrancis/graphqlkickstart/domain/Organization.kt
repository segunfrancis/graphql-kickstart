package com.segunfrancis.graphqlkickstart.domain

import lombok.AllArgsConstructor
import lombok.Data
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import javax.persistence.Entity

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
data class Organization(
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private val id: Int? = null,
    private val name: String? = null,

    @OneToMany(mappedBy = "organization")
    private val departments: Set<Department>? = null,

    @OneToMany(mappedBy = "organization")
    private val employees: Set<Employee>? = null
)
