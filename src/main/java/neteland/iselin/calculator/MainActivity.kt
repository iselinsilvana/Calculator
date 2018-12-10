package neteland.iselin.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.calc_result.*
import net.objecthunter.exp4j.ExpressionBuilder
import neteland.iselin.calculator.View.CalculatorFragment
import neteland.iselin.calculator.dependencyinjection.Injector
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object {
        val VIEW: String = "VIEW"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager: FragmentManager = this.supportFragmentManager
        val view = manager.findFragmentByTag(VIEW) as CalculatorFragment?
            ?: CalculatorFragment.newInstance(Injector(this))

        manager.beginTransaction().replace(R.id.root_activity_calculator, view).commit()
/*
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

        buttonPlus.setOnClickListener { addInput("+") }
        buttonMinus.setOnClickListener { addInput("-") }
        buttonMultiply.setOnClickListener { addInput("\u00D7") }
        buttonDivide.setOnClickListener { addInput( "\u00F7") }

        buttonEqual.setOnClickListener { equal() }

*/
    }


/*
// Adding to the input, and checking that nothing invalid is being added
    fun addInput (v: String) {
    if (tv_userResult.text.isNotEmpty()){
        tv_userInput.text = tv_userResult.text
    }
        val exsisting_input = tv_userInput.text
        val additional_input = v
        var resulting_input = ""
        when(v) {
            in "0", "+", "-", "÷", "×", ".", ")" ->{
                if (exsisting_input.isNotEmpty()){
                    resulting_input = "$exsisting_input$additional_input"
                    tv_userInput.text = resulting_input}
            }
            in "+", "-", "÷", "×" -> {
                val last_char = exsisting_input.takeLast(1)
                when (last_char) {
                     in "+", "-", "÷", "×" -> {
                        resulting_input = exsisting_input.substring(0, exsisting_input.length - 1)
                        resulting_input = "$exsisting_input$additional_input"
                        tv_userInput.text = resulting_input
                    }
                }
            }
            in "." -> {
                if (exsisting_input.contains( ".", true)) {
                    resulting_input = "$exsisting_input$additional_input"
                    tv_userInput.text = resulting_input
                    }
            }
            in "(" -> {
                resulting_input = "$exsisting_input$additional_input"
                tv_userInput.text = resulting_input
            }
            else -> {
                if (tv_userResult.text.isNotEmpty()){
                resulting_input = additional_input
                tv_userInput.text = resulting_input}
                else {resulting_input = "$exsisting_input$additional_input"
                    tv_userInput.text = resulting_input}
            }
        }

    tv_userResult.text = ""
    }

    //Is using a 3rd party library to convert strings so that we can evaluate it.
    fun equal () {
        tv_userResult.text = ""
        try{
            val fix_operators = tv_userInput.text.toString().replace("\u00F7", "/").replace("\u00D7", "*")
            val expression = ExpressionBuilder (fix_operators).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                 tv_userResult.append(longResult.toString())
            else tv_userResult.append(result.toString())

        }catch (e:Exception){
            Log.d( "Exception", "message : " + e.message )
        }
    }

    fun backspace () {
        val exsisting_input = tv_userInput.text.toString()
        if (exsisting_input.isNotEmpty()){
            tv_userInput.text = exsisting_input.substring(0,exsisting_input.length-1)
        }
        else {tv_userInput.text = " "}
        tv_userResult.text = " "
    }

    fun clearAll () {
        tv_userInput.text = " "
        tv_userResult.text = " "
    }
*/
}
