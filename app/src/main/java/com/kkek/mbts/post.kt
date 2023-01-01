package com.kkek.mbts

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Post(
    var FirstName: String? = "",
    var LastName: String? = "",
    var DateOfBirth: String? = "",
    var Dipartment: String? = "",
    var Password: String? = "",
) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "FirstName" to FirstName,
            "LastName" to LastName,
            "DateOfBirth" to DateOfBirth,
            "Dipartment" to Dipartment,
            "Password" to Password,

        )
    }
}
