package com.example.coroutines.producer

import com.example.coroutines.channel.SpeedometrChannel
import com.example.coroutines.event.Event
import com.example.coroutines.event.TempEventFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@EnableScheduling
class TempProducer : Producer {

    @Autowired
    private lateinit var factory: TempEventFactory;

    @Autowired
    private lateinit var channel: SpeedometrChannel

    @Scheduled(fixedRate = 100)
    override fun produce() {
        val event = factory.build()
        runBlocking {
            async {
                produceEvent(event)
            }
        }
    }

    private suspend fun produceEvent(e: Event) {
        channel.getChannel().send(e)
        println("Temp producer thread: ${Thread.currentThread()}")
    }
}