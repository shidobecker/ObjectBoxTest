package br.com.objectboxtest.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import java.util.*

@Entity
data class UserAuthority(

    @Id
    var boxId: Long = 0,

    var id: String = UUID.randomUUID().toString(),

    var username: String = "",

    var password: String = "",

    var personId: String = "",

    var useTermsAccepted: Boolean = true,

    var useTermsAcceptanceDate: String? = "",

    var createdDate: Date = Date()
) {
    lateinit var authorities: ToMany<Authority>

    lateinit var roles: ToMany<Role>

    lateinit var dogs: ToMany<Dog>
}