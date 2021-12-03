package com.example.coroutines.event

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class TempEventFactory : EventFactory {

    override fun build() = TempEvent(Random.nextInt())
}