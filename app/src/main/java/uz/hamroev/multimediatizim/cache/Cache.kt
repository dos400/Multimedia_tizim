package uz.hamroev.multimediatizim.cache

import android.content.Context
import android.content.SharedPreferences

object Cache {

    private const val NAME = "multimediatizim"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var language: String?
        get() = sharedPreferences.getString("til1", "ru")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("til1", value)
            }
        }

    var path: String?
        get() = sharedPreferences.getString("joy", "0")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("joy", value)
            }
        }


}
