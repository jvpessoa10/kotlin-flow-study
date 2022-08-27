package com.jvpass.flow

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val flow = getFlow().collect {
            println(it)
            if (it > 1) cancel()
        }

        nonCancellableFlow().cancellable().collect {
            if (it == 2) cancel()

            print(it)
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

private fun nonCancellableFlow() = (1..5).asFlow()

