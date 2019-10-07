package br.com.objectboxtest.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class Note(
    @Id
    var id: Long = 0,
    var uuid: String = UUID.randomUUID().toString(),
    var text: String = "",
    var createdAt: Date = Date()
)