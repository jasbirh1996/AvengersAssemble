package com.jasbir.repository.remote.response

import com.google.gson.annotations.SerializedName

data class MarvelCharacters(
    val code: Int,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
) {
    data class Data(
        val count: Int,
        val limit: Int,
        val offset: Int,
        @SerializedName("results")
        val charactersList: List<CharacterResult>,
        val total: Int
    ) {
        data class CharacterResult(
            val description: String,
            val id: Int,
            val modified: String,
            val name: String,
            val thumbnail: Thumbnail,

            ) {
            data class Thumbnail(
                val extension: String,
                val path: String
            )
        }
    }
}