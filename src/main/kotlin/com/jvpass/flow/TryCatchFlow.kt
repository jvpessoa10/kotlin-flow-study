package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        getFlow()
            .map { it.toString() }
            .onEach {
                check(it.toInt() < 2) {"Should not be bigger than two"}
                print(it)
            }
            .catch { e -> emit("Caught $e") }
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