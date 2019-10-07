package br.com.objectboxtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.objectboxtest.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        save_note.setOnClickListener {
            viewModel.saveNote()
            viewModel.getAllNotes()
        }


        viewModel.notes.observe(this, Observer { notes ->
            Log.w("TAG", "-----------------------------------------")
            notes?.forEach {
                Log.w("TAG", "Notes: ${it.text} || ${it.createdAt}")
            }
        })

        viewModel.users.observe(this, Observer { notes ->
            Log.w("TAG", "-----------------------------------------")
            notes?.forEach {
                Log.w("TAG", "User: ${it.username} || ${it.password}")
            }
        })


        update_note.setOnClickListener {
            viewModel.updateNote()
            viewModel.getAllNotes()
        }


        viewModel.authorities.observe(this, Observer { authorities ->
            Log.w("TAG", "-----------------------------------------")

            authorities?.forEach { userAuthority ->
                Log.w("TAG", "User Authority ${userAuthority.username} ${userAuthority.password}")
                userAuthority.authorities.forEach {
                    Log.w("TAG", "Auth: ${it.authority} || ${it.boxId}")
                }
                userAuthority.dogs.forEach {
                    Log.w("TAG", "Auth: ${it.dogName} || ${it.boxId}")
                }
            }
        })
    }
}
