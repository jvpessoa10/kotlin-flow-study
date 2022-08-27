package com.jvpass.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // Converting to flow
        (1..5).asFlow().collect {
            println(it)
        }

        getFlow().collect {
            println(it)
        }
    }
}

private fun getFlow(): Flow<Int> = flowOf(10, 12, 12)

