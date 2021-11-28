package com.naya.cafeDessert

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.naya.cafeDessert.adapter.ListUserAdapter
import com.naya.cafedessert.R
import com.naya.cafedessert.databinding.ActivityMainBinding
import model.User

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        list.addAll(getDataUser())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        mainBinding.rvUser.layoutManager = LinearLayoutManager(this)
        var listUserAdapter = ListUserAdapter(list)
        mainBinding.rvUser.setHasFixedSize(true)
        mainBinding.rvUser.adapter = listUserAdapter
    }

    private fun getDataUser(): ArrayList<User>{
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataPhoto  = resources.obtainTypedArray(R.array.avatar)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataCompany = resources.getStringArray(R.array.location)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val listUsers = ArrayList<User>()
        for (position in dataName.indices){
            val user = User(
                dataName[position],
                dataUsername[position],
                dataPhoto.getResourceId(position,-1),
                dataFollowing[position].toInt(),
                dataFollowers[position].toInt(),
                dataCompany[position],
                dataRepository[position].toInt(),
                dataLocation[position],
            )
            listUsers.add(user)
        }
        return listUsers

    }
}