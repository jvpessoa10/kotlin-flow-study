package com.jvpass.flow

fun main() {
    loadSequence().forEach {
        println(it)
    }
}

private fun loadSequence(): Sequence<Int> {
    return sequence {
        for (i in 1..3) {
            Thread.sleep(100)
            yield(i)
        }
    }
}