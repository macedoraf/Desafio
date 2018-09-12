package br.com.rafael.desafio.model

import com.google.gson.annotations.SerializedName

data class Joke(
        @SerializedName("icon_url") val iconUrl: String,
        val id: String,
        val url: String,
        val value: String,
        @SerializedName(value = "category") val listCategoria: List<String>) {

}
