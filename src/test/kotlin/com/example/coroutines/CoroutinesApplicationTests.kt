package com.example.coroutines

import com.example.coroutines.channel.SpeedometrChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CoroutinesApplicationTests {

    @Autowired
    lateinit var channel: SpeedometrChannel

    @Test
    fun test5messages() {

        runBlocking {
            val eventFlow = channel.getChannel().receiveAsFlow().take(5)
            eventFlow.collect {
                it.printEvent()
                println("Consumer thread: ${Thread.currentThread()}")
            }
        }
    }

}
