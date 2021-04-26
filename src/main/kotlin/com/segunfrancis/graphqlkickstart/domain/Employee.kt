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
    val id: Int?,
    val firstName: String,
    val lastName: String,
    val position: String,
    val salary: Int,
    val age: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    val department: Department? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val organization: Organization? = null
)
