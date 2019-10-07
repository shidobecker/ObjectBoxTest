package br.com.objectboxtest.model


open class UserAuthentication(

     // Used to authenticate the user on every backend request
    var accessToken: String = "",

     //The offline login token verification, it is formed by SHA256 from username + password
    var offlineLoginToken: String = "",

    var expiresIn: Long = 0,

    var scope: String = "",

    var timeReceived: Long = 0L
)
