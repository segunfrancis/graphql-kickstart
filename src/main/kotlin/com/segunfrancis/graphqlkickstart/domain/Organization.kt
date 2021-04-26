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
    val id: Int?,
    val name: String,

    @OneToMany(mappedBy = "organization")
    val employees: Set<Employee>? = null,

    @OneToMany(mappedBy = "organization")
    val departments: Set<Department>? = null
)
