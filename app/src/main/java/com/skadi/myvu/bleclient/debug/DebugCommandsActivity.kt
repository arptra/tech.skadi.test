package com.skadi.myvu.bleclient.debug

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.skadi.myvu.bleclient.R
import com.skadi.myvu.bleclient.ble.BleManager

class DebugCommandsActivity : AppCompatActivity() {
    private lateinit var payloadInput: EditText
    private lateinit var withResponseCheck: CheckBox
    private lateinit var resultView: TextView
    private lateinit var logView: TextView
    private lateinit var logScroll: ScrollView
    private lateinit var commandList: ListView

    private lateinit var bleManager: BleManager
    private lateinit var dispatcher: CommandDispatcher
    private lateinit var loggerListener: (List<String>) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_commands)

        payloadInput = findViewById(R.id.payloadInput)
        withResponseCheck = findViewById(R.id.withResponse)
        resultView = findViewById(R.id.resultView)
        logView = findViewById(R.id.logView)
        logScroll = findViewById(R.id.logScroll)
        commandList = findViewById(R.id.commandList)

        val (manager, logger) = BleSessionHolder.ensure(this)
        bleManager = manager
        dispatcher = CommandDispatcher(manager, logger)

        loggerListener = { lines ->
            runOnUiThread {
                logView.text = lines.joinToString("\n")
                logScroll.post { logScroll.fullScroll(View.FOCUS_DOWN) }
            }
        }
        logger.addListener(loggerListener)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DebugCommandRepository.commands.map { it.name }
        )
        commandList.adapter = adapter
        commandList.setOnItemClickListener { _, _, position, _ ->
            val command = DebugCommandRepository.commands[position]
            payloadInput.setText(command.payloadHex)
            withResponseCheck.isChecked = command.withResponse
            resultView.text = command.description ?: ""
        }

        findViewById<View>(R.id.sendButton).setOnClickListener {
            val editedCommand = Command(
                name = "Custom",
                payloadHex = payloadInput.text.toString(),
                withResponse = withResponseCheck.isChecked,
                description = null
            )
            val result = dispatcher.dispatch(editedCommand)
            resultView.text = result.message
            if (!result.success) {
                Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
            }
        }

        if (DebugCommandRepository.commands.isNotEmpty()) {
            payloadInput.setText(DebugCommandRepository.commands.first().payloadHex)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BleSessionHolder.logger?.removeListener(loggerListener)
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, DebugCommandsActivity::class.java)
    }
}
