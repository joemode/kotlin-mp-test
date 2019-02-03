package api

import api.account.BackendAccountAgent
import api.account.MerchantAccountAgent
import api.account.UserAccountAgent
import api.account.UserAccountListener
import api.account.base.AccountAgent
import api.base.BaseAgent
import kotlin.test.*


class InitializationTests {

    @Test
    fun initialize() {
        val success = InitializationAgent.initialize(ClientType.USER)
        assertEquals(ClientType.USER, InitializationAgent.userType)
        assertTrue(success)
        InitializationAgent.deinitialize()
    }

    @Test
    fun initializeRepeat() {
        val success = InitializationAgent.initialize(ClientType.MERCHANT)
        assertEquals(ClientType.MERCHANT, InitializationAgent.userType)
        assertTrue(success)

        val success2 = InitializationAgent.initialize(ClientType.USER)
        assertEquals(ClientType.MERCHANT, InitializationAgent.userType)
        assertFalse(success2)
        InitializationAgent.deinitialize()
    }

    @Test
    fun initializeAccountAgent() {
        InitializationAgent.initialize(ClientType.USER)

        val listener = object: AccountAgent.OnAccountAgentInitialized {
            override fun agentInitialized(agent: BaseAgent<*>) {
                fail("BaseAgent should not be initialized")
            }

            override fun userAgentInitialized(agent: UserAccountAgent) {
                assertNotNull(agent)
            }

            override fun merchantAgentInitialized(agent: MerchantAccountAgent) {
                fail("MerchantAccountAgent should not be initialized")
            }

            override fun backendAgentInitialized(agent: BackendAccountAgent) {
                fail("BackendAccountAgent should not be initialized")
            }

            override fun initializationError(message: String) {
                fail("No error should be thrown")
            }
        }

        InitializationAgent.getAgent(listener)
        InitializationAgent.deinitialize()
    }

}