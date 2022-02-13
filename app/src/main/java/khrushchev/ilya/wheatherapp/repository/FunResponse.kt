package khrushchev.ilya.wheatherapp.repository

import khrushchev.ilya.wheatherapp.models.WheatherModel

interface FunResponse {
    fun apiModel(callback: (WheatherModel)->Unit)
}