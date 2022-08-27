package com.jvpass.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        getFlow().collect {
            println(it)
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
private fun getFlow(): Flow<Int> = flow {
    println("Flow launched")
    repeat(4) {
        delay(1000) // Intense request
        println("Emitting value")
        emit(it)
    }
}.transform {
    println("Transforming")
    emit(it + 1)
}

