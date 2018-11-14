package neteland.iselin.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.cal_buttons.*
import kotlinx.android.synthetic.main.calc_result.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonOne: Button = findViewById<Button>(R.id.btn_One)
        val buttonTwo: Button = findViewById<Button>(R.id.btn_Two)
        val buttonThree: Button = findViewById<Button>(R.id.btn_Three)
        val buttonFour: Button = findViewById<Button>(R.id.btn_Four)
        val buttonFive: Button = findViewById<Button>(R.id.btn_Five)
        val buttonSix: Button = findViewById<Button>(R.id.btn_Six)
        val buttonSeven: Button = findViewById<Button>(R.id.btn_Seven)
        val buttonEight: Button = findViewById<Button>(R.id.btn_Eight)
        val buttonNine: Button = findViewById<Button>(R.id.btn_Nine)
        val buttonZero: Button = findViewById<Button>(R.id.btn_Zero)
        val buttonPoint: Button = findViewById<Button>(R.id.btn_Point)

        val buttonPlus: Button = findViewById<Button>(R.id.btn_Plus)
        val buttonMinus: Button = findViewById<Button>(R.id.btn_Minus)
        val buttonMultiply: Button = findViewById<Button>(R.id.btn_Multiply)
        val buttonDivide: Button = findViewById<Button>(R.id.btn_Divide)
        val buttonLeft: Button = findViewById<Button>(R.id.btn_left_paranthesis)
        val buttonRight: Button = findViewById<Button>(R.id.btn_right_paranthesis)


        val buttonEqual: Button = findViewById<Button>(R.id.btn_Equal)
        val buttonBackspace: ImageButton = findViewById<ImageButton>(R.id.btn_Backspace)
        val buttonClearAll: Button = findViewById<Button>(R.id.btn_Clear)


        buttonBackspace.setOnClickListener { backspace() }
        buttonClearAll.setOnClickListener { clearAll() }

        buttonOne.setOnClickListener { addInput("1") }
        buttonTwo.setOnClickListener { addInput("2") }
        buttonThree.setOnClickListener { addInput("3") }
        buttonFour.setOnClickListener { addInput("4") }
        buttonFive.setOnClickListener { addInput("5") }
        buttonSix.setOnClickListener { addInput("6") }
        buttonSeven.setOnClickListener { addInput("7") }
        buttonEight.setOnClickListener { addInput("8") }
        buttonNine.setOnClickListener { addInput("9") }
        buttonZero.setOnClickListener { addInput("0") }
        buttonPoint.setOnClickListener { addInput(".") }

        buttonLeft.setOnClickListener { addInput("(") }
        buttonRight.setOnClickListener { addInput(")") }

        buttonPlus.setOnClickListener { addInputOperator("+") }
        buttonMinus.setOnClickListener { addInputOperator("-") }
        buttonMultiply.setOnClickListener { addInputOperator("\u00D7") }
        buttonDivide.setOnClickListener { addInputOperator( "\u00F7") }

        buttonEqual.setOnClickListener { equal() }


    }

/*    fun addInput ( v: String, canClear: Boolean ) {
        if (canClear){
            R.string.calc_result = ""
            R.string.calc_input.append(v) = v.padEnd(length = 1)
        } else {
            R.string.calc_input.append(R.string.calc_result)
            R.string.calc_input.append(v) = v.padEnd(length = 1)
            R.string.calc_result.text = ""
        }
    }
    */


    fun addInput (v: String) {
        val exsisting_input = tv_userInput.text
        val additional_input = v
        val resulting_input = "$exsisting_input$additional_input"
        tv_userInput.text = resulting_input
    }

    fun addInputOperator (v: String) {
        val exsisting_input = tv_userInput.text
        val additional_input = v
        val resulting_input = "$exsisting_input$additional_input"
        tv_userInput.text = resulting_input
        // vil sjekke om det er ein operator før, sånn at den blir bytta ut med den nye.
    }
    fun equal () {
        try{
            val expression = ExpressionBuilder (tv_userInput.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                tv_userResult.text = longResult.toString()
            else tv_userResult.text = result.toString()

        }catch (e:Exception){
            Log.d( "Exception", "message : " + e.message )
        }
    }

    fun backspace () {
        val exsisting_input = tv_userInput.text.toString()
        if (exsisting_input.isNotEmpty()){
            tv_userInput.text = exsisting_input.substring(0,exsisting_input.length-1)
        }
    }

    fun clearAll () {
        tv_userInput.text = ""
        tv_userResult.text = ""
    }

}
