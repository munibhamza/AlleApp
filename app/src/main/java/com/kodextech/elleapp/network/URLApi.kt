package com.dev.project.ruizpronos.network

import com.kodextech.elleapp.network.NetworkMethod
import org.json.JSONObject

object URLApi {
    private val TAG = URLApi::class.java.toString()


    private const val BaseUrl =
        "http://kloz.kodextech.com/public/" //URL here
    private var path: String = ""
    private var params: JSONObject = JSONObject()
    var method: NetworkMethod = NetworkMethod.GET
    final fun link(): String {
        return BaseUrl + path
    }

    final fun param(): JSONObject {
        return params
    }

    fun login(email: String, password: String): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/auth/login"
        this.params = JSONObject()
        this.params.put("phone", email)
        this.params.put("password", password)
        return this
    }


    fun signup(
        phone: String, password: String,
        first_name: String, last_name: String,
        street: String, postal_code: String,
        city: String, bank_account: String, user_type: String
    ): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/auth/signup"
        this.params = JSONObject()
        this.params.put("phone", phone)
        this.params.put("password", password)
        this.params.put("first_name", first_name)
        this.params.put("last_name", last_name)
        this.params.put("street", street)
        this.params.put("postal_code", postal_code)
        this.params.put("city", city)
        this.params.put("bank_account", bank_account)
        this.params.put("user_type", user_type)
        return this

    }

    fun updateProfile(
        first_name: String, last_name: String,
        street: String, postal_code: String,
        city: String, bank_account: String,
    ): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/update_profile"
        this.params = JSONObject()
        this.params.put("first_name", first_name)
        this.params.put("last_name", last_name)
        this.params.put("street", street)
        this.params.put("postal_code", postal_code)
        this.params.put("city", city)
        this.params.put("bank_account", bank_account)
        return this

    }

    fun updatePassword(old_password: String, password: String): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/update_password"
        this.params = JSONObject()
        this.params.put("old_password", old_password)
        this.params.put("password", password)
        return this
    }

    fun getUsers(): URLApi {
        this.method = NetworkMethod.GET
        this.path = "api/auth/user"
        return this
    }

    fun updateMineral(
        type_id: String,
        quality_id: String,
        quantity: String,
        price: String,
        start_date: String,
        end_date: String
    ): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/update_mineral"
        this.params = JSONObject()
        this.params.put("type_id", type_id)
        this.params.put("quality_id", quality_id)
        this.params.put("quantity", quantity)
        this.params.put("total_quantity", quantity)
        this.params.put("price", price)
        this.params.put("unit_price", price)
        this.params.put("start_date", start_date)
        this.params.put("end_date", end_date)
        return this
    }

    fun getMineralsType(): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/get_mineral_types"
        return this
    }
    fun getMineralsQualities(): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/get_mineral_qualities"
        return this
    }

    fun getMinerals(page:Int = 1): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/get_minerals?page=${page}"
        this.params = JSONObject()
        return this
    }

    fun getMineralByID(mineral_id: String): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/get_mineral_by_id"
        this.params = JSONObject()
        this.params.put("mineral_id", mineral_id)
        return this
    }

    fun submitOrder(mineral_id: String, quantity: String): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/submit_order"
        this.params = JSONObject()
        this.params.put("mineral_id", mineral_id)
        this.params.put("quantity", quantity)
        return this
    }

    fun acceptOrder(order_id: String): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/accept_order"
        this.params = JSONObject()
        this.params.put("order_id", order_id)
        return this
    }

    fun orderCompleted(order_id: String): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/complete_order"
        this.params = JSONObject()
        this.params.put("order_id", order_id)
        return this
    }

    fun cancelOrder(order_id: String): URLApi {

        this.method = NetworkMethod.POST
//        this.path = "api/cancel_order"
        this.path = "api/cancel_order"
        this.params = JSONObject()
        this.params.put("order_id", order_id)
        return this
    }

    fun rejectOrder(order_id: String): URLApi {

        this.method = NetworkMethod.POST
        this.path = "api/reject_order"
        this.params = JSONObject()
        this.params.put("order_id", order_id)
        return this
    }

    fun getPendingOrders(): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/get_pending_orders"
        this.params = JSONObject()
        return this
    }

    fun getMyOrders(): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/get_my_orders"
        this.params = JSONObject()
        return this
    }
    fun getNotifications(): URLApi {
        this.method = NetworkMethod.POST
        this.path = "api/get_notifications"

        this.params = JSONObject()
        return this
    }



}

object Randomized {
    fun generate(min: Int, max: Int): Int {
        return min + (Math.random() * (max - min + 1)).toInt()
    }
}
