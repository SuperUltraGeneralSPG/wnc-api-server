package com.spg.wnc.infra.persistence

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.json.JsonMapper
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class StringListConverter(
    private val jsonMapper: JsonMapper
) : AttributeConverter<List<String>?, String?> {
    private val map = object : TypeReference<List<String>>() {}

    override fun convertToDatabaseColumn(attribute: List<String>?): String? {
        if (attribute == null) {
            return null
        }

        return jsonMapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<String>? {
        if (dbData == null) {
            return null
        }

        return jsonMapper.readValue(dbData, map)
    }

}