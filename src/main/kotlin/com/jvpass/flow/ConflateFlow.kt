package com.jvpass.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.math.log

fun main() = runBlocking {
    println("${Thread.currentThread()},Collecting flow")
    getFlow()
        .conflate()
        .collect {
            delay(1000)
            println("value: $it")
    }
}

private fun getFlow(): Flow<Int> = flow {
    println("Flow started")
    println("${Thread.currentThread()}")
    repeat(3) {
        emit(it)
    }
}