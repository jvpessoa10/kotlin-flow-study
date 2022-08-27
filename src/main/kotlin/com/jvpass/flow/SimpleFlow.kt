package com.jvpass.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    getFlow().collect {
        println(it)
    }
}

private fun getFlow(): Flow<Int> = flow {
    repeat(3) {
        delay(1000)
        emit(it)
    }
}