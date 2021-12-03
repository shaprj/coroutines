package com.example.coroutines.event

interface EventFactory {

    fun build(): Event;

}