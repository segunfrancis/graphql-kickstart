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
    private val id: Int? = null,
    private val firstName: String? = null,
    private val lastName: String? = null,
    private val position: String? = null,
    private val salary: Int = 0,
    private val age: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    private val department: Department? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    private val organization: Organization? = null
)
