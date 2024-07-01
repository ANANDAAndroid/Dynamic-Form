package com.clone.dynamicform.model

class Form{
    data class FormModel(
        val pages: List<Page>
    )

    data class Page(
        val color: String,
        val id: String,
        val order: Int,
        val section: List<Section>,
        val title: String
    )

    data class Section(
        val fields: List<Field>,
        val id: String,
        val isDeletable: Boolean,
        val isDuplicable: Boolean,
        val order: Int,
        val title: String
    )

    data class Field(
        val fieldType: String,
        val folder: String,
        val hint: String,
        val id: String,
        val instructions: String,
        val isOptional: Boolean,
        val options: List<String>,
        val order: Int,
        val title: String,
        val value: String
    )
}