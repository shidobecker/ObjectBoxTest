package br.com.objectboxtest.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class User(
    @Id
    var boxId: Long = 0L,
    var id: String = UUID.randomUUID().toString(),
    var username: String = "",
    var password: String = ""
)