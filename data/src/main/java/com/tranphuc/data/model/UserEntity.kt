package com.tranphuc.data.model


import com.google.gson.annotations.SerializedName

class UserEntity{
    @SerializedName("user_id")
    val userID: String? = ""

    @SerializedName("display_name")
    val displayName: String? = ""

    @SerializedName("profile_image")
    val userAvatar: String? = ""

    @SerializedName("reputation")
    val reputation: Long? = 0

    @SerializedName("location")
    val location: String? = ""

    @SerializedName("last_access_date")
    val lastAccessDate: Long? = 0
}
