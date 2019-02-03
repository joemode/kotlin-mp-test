package api.account

import api.account.base.AccountAgent
import api.base.BackendAgent

class BackendAccountAgent: AccountAgent<BackendAccountListener>(), BackendAgent {
}