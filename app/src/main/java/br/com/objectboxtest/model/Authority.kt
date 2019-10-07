package br.com.objectboxtest.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class Authority (
    @Id
    var boxId: Long = 0,
    var authority: String = "")