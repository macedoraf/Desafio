package br.com.rafael.desafio.model

import com.google.gson.annotations.SerializedName

data class Joke(val category: String,
                @SerializedName("icon_url") val iconUrl: String,
                val id: Int,
                val url: String,
                val value: String) {

}
