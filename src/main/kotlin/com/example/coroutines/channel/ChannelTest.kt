package com.example.coroutines.channel

import com.example.coroutines.event.Event
import kotlinx.coroutines.channels.Channel

interface ChannelTest {

    fun getChannel(): Channel<Event>;

}