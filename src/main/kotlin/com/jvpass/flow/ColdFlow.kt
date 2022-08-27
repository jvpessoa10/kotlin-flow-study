package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Collecting flow")
    getFlow().collect {
        println(it)
    }

    println("Collecting flow again")
    getFlow().collect {
        println(it)
    }
}

private fun getFlow(): Flow<Int> = flow {
    println("Flow started")
    repeat(3) {
        delay(1000)
        emit(it)
    }
}