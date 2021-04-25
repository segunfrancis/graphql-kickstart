package com.segunfrancis.graphqlkickstart.domain

import lombok.EqualsAndHashCode
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
data class Employee(
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    val id: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val position: String? = null,
    val salary: Int = 0,
    val age: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    val department: Department? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val organization: Organization? = null
)
