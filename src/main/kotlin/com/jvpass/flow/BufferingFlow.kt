package com.jvpass.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("${Thread.currentThread()},Collecting flow")
    getFlow()
        .buffer()
        .collect {
            delay(2000)
            println("value: $it")
        }
}

private fun getFlow(): Flow<Int> = flow {
    println("Flow started")
    println("${Thread.currentThread()}")
    repeat(3) {
        delay(1000)
        emit(it)
    }
}