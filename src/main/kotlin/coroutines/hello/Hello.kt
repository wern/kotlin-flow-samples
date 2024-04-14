package coroutines.hello

import kotlinx.coroutines.*
import java.rmi.RemoteException

fun main() = helloWithFun()

fun hello() = runBlocking {
    launch {
        delay(1000L)
        println("Campus!")
    }
    println("Willkommen zum")
}

fun helloWithFun() = runBlocking {
    launch {
        try {
            delayedCampusNewJobs()
            println("Tach")
            delay(5000)
        }catch (e :CancellationException) {
            println("Upps2!!!!")
        }
    }
    println("Willkommen zum")
}

suspend fun delayedCampusNewJobs() = coroutineScope {
    launch {
        try {
            delay(2000L)
            println("2024")
        } catch (ex: CancellationException) {
            println("Ups!!!")
        }
    }
    launch {
        delay(1000L)
        throw RemoteException("Bumm!!!")
        println("Campus")
    }
    println("MATHEMA")
}