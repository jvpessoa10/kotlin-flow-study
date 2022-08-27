package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        getFlow()
            .onCompletion { println("Done") }
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

private fun getFlowWithException(): Flow<Int> = flow {
    println("Flow launched")
    repeat(2)  {
        emit(it)
    }
    throw java.lang.RuntimeException()
}
