package com.example.coroutines.channel

import com.example.coroutines.event.Event
import kotlinx.coroutines.channels.Channel
import org.springframework.stereotype.Service

@Service
class SpeedometrChannel: ChannelTest {

    private val channel = Channel<Event>()

    override fun getChannel() = channel


}