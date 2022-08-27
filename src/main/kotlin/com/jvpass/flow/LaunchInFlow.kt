package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        getFlow()
            .onEach { println("${Thread.currentThread()}, $it") }
            .launchIn(this)
        println("Launches collection at another coroutine scope, this line will print first")
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
