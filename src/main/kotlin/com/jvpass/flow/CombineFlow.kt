package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        getFlow()
            .zip(getOtherFlow()) {a, b -> a + b}
            .collect {
            println(it)
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

private fun getOtherFlow(): Flow<Int> = flow {
    println("Flow launched")
    repeat(2) {
        delay(1000) // Intense request
        println("Emitting value")
        emit(it)
    }
}

