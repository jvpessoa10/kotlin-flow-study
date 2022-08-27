package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        withTimeoutOrNull(2100) {
            getFlow().collect {
                println(it)
            }
        }
        println("Continuing execution after cancellation")
    }
}

private fun getFlow(): Flow<Int> = flow {
    repeat(3) {
        delay(1000)
        emit(it)
    }
}

