package com.tranphuc.data.remote.response

import com.google.gson.annotations.SerializedName
import com.tranphuc.data.model.UserEntity

class GetListUserResponse {
    @SerializedName("items")
    val listUserApiEntity: MutableList<UserEntity> = ArrayList()

    @SerializedName("has_more")
    val isHasLoadMore: Boolean = false
}