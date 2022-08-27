package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        getFlow()
            .filter {
                println("Filtering $it")
                it % 2 == 0
            }
            .map {
                println("Mapping $it")
                "String:$it"
            }.collect {
                println("Collecting $it")
                println(it)
            }
    }
}

private fun getFlow(): Flow<Int> = flow {
    println("Flow launched")
    repeat(16) {
        delay(1000) // Intense request
        println("Emitting value")
        emit(it)
    }
}

