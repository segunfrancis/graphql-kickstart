package com.segunfrancis.graphqlkickstart.domain

import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import lombok.AllArgsConstructor
import lombok.Data
import javax.persistence.GeneratedValue
import javax.persistence.FetchType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
data class Department(
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private val id: Int? = null,
    private val name: String? = null,

    @OneToMany(mappedBy = "department")
    private val employees: Set<Employee>? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    private val organization: Organization? = null
)
