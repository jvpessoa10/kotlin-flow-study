package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    val startTime = System.currentTimeMillis()
    runBlocking {
        getFlow()
            .flatMapConcat { requestSomethingTwice(it) }
            .collect {
            println("$it at ${System.currentTimeMillis() - startTime}")
        }
    }
}

private fun getFlow(): Flow<Int> = flow {
    println("Flow launched")
    repeat(4) {
        delay(1000) // Intense request
        println("Emitting value")
        emit(it)
    }
}

private fun requestSomethingTwice(number: Int): Flow<String> = flow {
    emit("First: $number")
    delay(1000)
    emit("Second: $number")
}


