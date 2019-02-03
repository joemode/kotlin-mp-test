package api.base

abstract class BaseAgent<T: BaseAgentListener> internal constructor() {

    var listener: T? = null
        private set

    protected open fun init(listener: T) {
        this.listener = listener
    }
}