package pl.borawski.lab2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sortbutton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner: Spinner = findViewById(R.id.chooseBox)
        ArrayAdapter.createFromResource(
            this,
            R.array.algorithms_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


    }

    fun sortData(view: View) {
        val spinner: Spinner = findViewById(R.id.chooseBox)
        val chosenOption = spinner.selectedItem.toString()
        val sorter = AlgorithmsImplementation()
        var result = mutableListOf(1, 2, 3) //default
        val sequence: EditText = findViewById(R.id.editTextText)
        val sequenceText = sequence.text.toString()
        val list = sequenceText.split(",").map { it.toInt() }.toMutableList()
        val beforeText = findViewById<TextView>(R.id.before)
        val descriptionText = findViewById<TextView>(R.id.description)

        beforeText.text = "Przed posortowaniem: \n" + list.toString()
        beforeText.visibility = View.VISIBLE
        when (chosenOption) {
            "Sortowanie przez wybieranie" -> {
                result = sorter.selectionSort(list)
                descriptionText.text = getText(R.string.insert_description)
            }

            "Sortowanie bąbelkowe" -> {
                result = sorter.bubbleSort(list)
                descriptionText.text = getString(R.string.bubble_description)
            }
        }

        descriptionText.visibility = View.VISIBLE
        var resultText = findViewById<TextView>(R.id.result)
        resultText.text = "Po posortowaniu: \n" + result.toString()
        resultText.visibility = View.VISIBLE
    }
}