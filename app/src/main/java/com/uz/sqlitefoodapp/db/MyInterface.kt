package com.uz.sqlitefoodapp.db

import com.uz.sqlitefoodapp.model.User

interface MyInterface {

    fun addUser(user: User)

    fun getAllTaom():List<User>

    fun deleteUser(user: User)

    fun update(user: User)

}