package com.tranphuc.domain.model


data class User(
    var userID: String = "",
    var name: String,
    var avatar: String = "",
    var reputation: Long = 0,
    var location: String = "",
    var lastAccessDate: Long = 0,
    var isBookMarked: Boolean = false
) {
}