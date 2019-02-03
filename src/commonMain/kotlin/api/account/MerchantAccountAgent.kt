package api.account

import api.account.base.AccountAgent
import api.base.MerchantAgent

class MerchantAccountAgent: AccountAgent<MerchantAccountListener>(), MerchantAgent {
}