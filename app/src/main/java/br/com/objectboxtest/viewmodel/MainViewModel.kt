package br.com.objectboxtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.objectboxtest.model.*
import br.com.objectboxtest.repository.NotesBox
import io.objectbox.BoxStore
import io.objectbox.relation.ToMany
import java.util.*
import java.util.concurrent.ThreadLocalRandom

fun randomInt(): Int = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

class MainViewModel : ViewModel() {

    val repository = NotesBox()

    var notes = MutableLiveData<List<Note>>()
    var users = MutableLiveData<List<User>>()
    var authorities = MutableLiveData<List<UserAuthority>>()

    fun getAllNotes() {
        notes.postValue(repository.getNotes())
        users.postValue(repository.getUser())
        authorities.postValue(repository.getUserAuthorities())
    }

    fun saveNote() {
        val note = Note(text = "Note ${randomInt()}")
        repository.saveNote(note)

        val saveUser = User(username = "Username ${randomInt()}", password = "${randomInt()}")

        repository.saveUser(saveUser)


        val userAuthority = UserAuthority(
            username = "Username ${randomInt()}",
            password = "password", useTermsAcceptanceDate = "Date",
            useTermsAccepted = true,
            createdDate = Date()
        )

        userAuthority.authorities.add(Authority(authority = "ROLE_1"))
        userAuthority.authorities.add(Authority(authority = "ROLE_2"))

        userAuthority.roles.add(Role(role = "ROLE_1"))
        userAuthority.roles.add(Role(role = "ROLE_2"))

        userAuthority.dogs.add(Dog(dogName = "Dog Number ${randomInt()}"))

        repository.saveUserAuthority(userAuthority)
    }


    fun updateNote() {
        val note = repository.getNotes().random()
        note.text = "lllllll"
        repository.saveNote(note)

        val userAuthority = repository.getUserAuthorities().random()
        userAuthority.authorities.clear()
        userAuthority.authorities.add(Authority(authority = "ROLE_3"))
        userAuthority.username = "Let's Try Box"

        repository.saveUserAuthority(userAuthority)

    }

}