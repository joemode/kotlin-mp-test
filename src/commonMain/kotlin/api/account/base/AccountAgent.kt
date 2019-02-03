package api.account.base

import api.account.BackendAccountAgent
import api.account.MerchantAccountAgent
import api.account.UserAccountAgent
import api.base.BaseAgent
import api.base.OnInitialized

abstract class AccountAgent<T: AccountAgentListener>: BaseAgent<T>() {
    interface OnAccountAgentInitialized: OnInitialized<UserAccountAgent,
            MerchantAccountAgent,
            BackendAccountAgent>
}