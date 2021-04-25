package com.segunfrancis.graphqlkickstart.filter

import lombok.Data
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Path
import javax.persistence.criteria.Predicate

@Data
class FilterField {
    private val operator: String? = null
    private val value: String? = null
    fun generateCriteria(builder: CriteriaBuilder, field: Path<Int>?): Predicate? {
        try {
            val v = value!!.toInt()
            when (operator) {
                "lt" -> return builder.lt(field, v)
                "le" -> return builder.le(field, v)
                "gt" -> return builder.gt(field, v)
                "ge" -> return builder.ge(field, v)
                "eq" -> return builder.equal(field, v)
            }
        } catch (e: NumberFormatException) {
            when (operator) {
                /*"endsWith" -> return builder.like(field, "%$value")
                "startsWith" -> return builder.like(field, "$value%")
                "contains" -> return builder.like(field, "%$value%")*/
                "eq" -> return builder.equal(field, value)
            }
        }
        return null
    }
}
