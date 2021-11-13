package com.spg.wnc.infra.persistence

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.json.JsonMapper
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class LongListConverter(
    private val jsonMapper: JsonMapper
) : AttributeConverter<List<Long>?, String?> {
    private val map = object : TypeReference<List<Long>>() {}

    override fun convertToDatabaseColumn(attribute: List<Long>?): String? {
        if (attribute == null) {
            return null
        }

        return jsonMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<Long>? {
        if (dbData == null) {
            return null
        }

        return jsonMapper.readValue(dbData, map)
    }

}