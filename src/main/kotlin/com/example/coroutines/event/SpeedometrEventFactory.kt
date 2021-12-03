package com.example.coroutines.event

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class SpeedometrEventFactory : EventFactory {

    override fun build() = SpeedometrEvent(Random.nextDouble())

}