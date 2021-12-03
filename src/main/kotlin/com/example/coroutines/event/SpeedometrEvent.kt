package com.example.coroutines.event

class SpeedometrEvent(val nextDouble: Double) : Event {

    override fun printEvent() {
        println("New speed value: ${nextDouble}")
    }
}