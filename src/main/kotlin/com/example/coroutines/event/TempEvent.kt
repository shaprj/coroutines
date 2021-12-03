package com.example.coroutines.event

class TempEvent(val tempValue: Int) : Event {
    override fun printEvent() {
        println("New temp value: ${tempValue}")
    }
}