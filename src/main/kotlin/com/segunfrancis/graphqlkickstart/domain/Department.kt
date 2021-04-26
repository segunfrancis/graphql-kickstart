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
    val id: Int?,
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    val organization: Organization? = null,

    @OneToMany(mappedBy = "department")
    val employees: Set<Employee>? = null
)
