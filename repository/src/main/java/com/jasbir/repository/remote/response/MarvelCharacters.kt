package com.jasbir.repository.remote.response

data class MarvelCharacters(
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)