package br.com.objectboxtest.repository

import br.com.objectboxtest.model.Note
import br.com.objectboxtest.model.Note_
import br.com.objectboxtest.model.User
import br.com.objectboxtest.model.UserAuthority
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import io.objectbox.query.OrderFlags

class NotesBox {

    fun getNotes(): List<Note> {
        val notes: Box<Note> = BoxStore.getDefault().boxFor()
        notes.query {
            order(Note_.id, OrderFlags.DESCENDING)
        }
        return notes.all
    }

    fun saveNote(note: Note) {
        val notes: Box<Note> = BoxStore.getDefault().boxFor()
        notes.put(note)
    }

    fun getUser(): List<User>{
        return BoxStore.getDefault().boxFor(User::class.java).all
    }

    fun saveUser(user: User) {
        BoxStore.getDefault().boxFor(User::class.java).put(user)
    }


    fun saveUserAuthority(user: UserAuthority) {
        BoxStore.getDefault().boxFor(UserAuthority::class.java).put(user)
    }

    fun getUserAuthorities() = BoxStore.getDefault().boxFor(UserAuthority::class.java).all


}