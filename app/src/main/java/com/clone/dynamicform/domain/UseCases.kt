package com.clone.dynamicform.domain

import android.content.Context
import com.clone.dynamicform.model.Form
import com.google.gson.Gson
import java.io.IOException

class UseCases(private val fileName: String="form_base.json") {

    operator fun get(context: Context): Form.FormModel? {
        val formInJson = try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            return null
        }
        return Gson().fromJson(formInJson, Form.FormModel::class.java)
    }
}