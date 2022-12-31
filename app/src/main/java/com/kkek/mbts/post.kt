package com.kkek.mbts

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Post(
    var FirstName: String? = "",
    var LastName: String? = "",
    var DateOfBirth: String? = "",
    var Dipartment: String? = "",
) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to FirstName,
            "author" to LastName,
            "title" to DateOfBirth,
            "body" to Dipartment,
        )
    }
}
