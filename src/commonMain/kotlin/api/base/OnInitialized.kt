package api.base

interface OnInitialized<U: UserAgent, M: MerchantAgent, B: BackendAgent> {
    fun agentInitialized(agent: BaseAgent<*>)
    fun userAgentInitialized(agent: U)
    fun merchantAgentInitialized(agent: M)
    fun backendAgentInitialized(agent: B)
    fun initializationError(message: String)
}

