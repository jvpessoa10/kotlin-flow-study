package com.jvpass.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlin.math.log

fun main() = runBlocking {
    println("${Thread.currentThread()},Collecting flow")
    getFlow().collect {
        delay(6000)
        println("value: $it")

    }
}

@OptIn(ExperimentalCoroutinesApi::class)
private fun getFlow(): Flow<Int> = flow {
    println("Flow started")
    println("${Thread.currentThread()}")
    repeat(3) {
        delay(5000)
        emit(it)
    }
}.flowOn(Dispatchers.IO)