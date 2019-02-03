package api.account

import api.account.base.AccountAgent
import api.base.UserAgent

class UserAccountAgent: AccountAgent<UserAccountListener>(), UserAgent {
}