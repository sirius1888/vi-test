abstract class TrafficLightState {
    abstract fun next(): TrafficLightState
    abstract fun signal(): String
}

// Cостояние "Красный"
class RedState : TrafficLightState() {
    override fun next(): TrafficLightState {
        return GreenState() // Переход к "Зеленый"
    }

    override fun signal(): String {
        return "Красный свет"
    }
}

// Cостояние "Зеленый"
class GreenState : TrafficLightState() {
    override fun next(): TrafficLightState {
        return YellowState() // Переход к "Желтый"
    }

    override fun signal(): String {
        return "Зеленый свет"
    }
}

// Cостояние "Желтый"
class YellowState : TrafficLightState() {
    override fun next(): TrafficLightState {
        return RedState() // Переход к "Красный"
    }

    override fun signal(): String {
        return "Желтый свет"
    }
}

class TrafficLight {
    private var state: TrafficLightState = RedState()

    fun change() {
        state = state.next() // Динамическая диспетчеризация
    }

    fun currentSignal(): String {
        return state.signal()
    }
}

fun main() {
    val trafficLight = TrafficLight()
    
    repeat(6) {
        println(trafficLight.currentSignal())
        trafficLight.change()
    }
}
