package br.com.objectboxtest

import br.com.objectboxtest.model.MyObjectBox
import br.com.objectboxtest.model.User
import br.com.objectboxtest.repository.NotesBox
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.File


class UserTest {

    lateinit var repository : NotesBox

    companion object {
        val TEST_DIRECTORY = File("objectboxtest/test-db")

    }

    var store: BoxStore? = null

    @Before
    fun setup() {
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
        store = MyObjectBox.builder()
            .directory(TEST_DIRECTORY)
            .debugFlags(DebugFlags.LOG_QUERIES or DebugFlags.LOG_QUERY_PARAMETERS)
            .buildDefault()

        repository = NotesBox()

    }


    @After
    @Throws(Exception::class)
    fun tearDown() {
        if (store != null) {
            store?.close()
            store = null
        }
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
    }


    @Test
    fun test_save_user_correctly() {
        //Given User Object
        val user = User(username = "A", password = "B")

        //When Saved:
        repository.saveUser(user)

        //User is saved
        val userBox = store?.boxFor(User::class.java)

        assertEquals(1, userBox?.all?.size)

    }

}