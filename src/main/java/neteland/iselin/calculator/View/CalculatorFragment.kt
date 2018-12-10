package neteland.iselin.calculator.View

import android.support.v4.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.cal_buttons.*
import kotlinx.android.synthetic.main.calc_result.*
import neteland.iselin.calculator.MainActivity
import neteland.iselin.calculator.R
import neteland.iselin.calculator.dependencyinjection.Injector

class CalculatorFragment : Fragment(), IViewContract.View, View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_Equal -> presenter.onEvaluateClick(tv_userInput.text.toString())
            R.id.btn_Backspace -> presenter.onBackspaceClick()
            R.id.btn_Clear -> presenter.onDeleteClick()
            else -> {
                if (v is Button) {
                    presenter.onInputButtonClick(v.text.toString())
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.bind()
    }

    override fun onStop() {
        super.onStop()
        presenter.clear()
    }


    lateinit var presenter: IViewContract.Presenter

    companion object {
        fun newInstance(injector: Injector) = CalculatorFragment().setPresenter(injector)
    }

    private fun setPresenter(injector:Injector):Fragment{
        presenter = injector.providePresenter(this)
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_Backspace.setOnClickListener(this)
        btn_Clear.setOnClickListener (this)

        btn_One.setOnClickListener  (this)
        btn_Two.setOnClickListener  (this)
        btn_Three.setOnClickListener  (this)
        btn_Four.setOnClickListener  (this)
        btn_Five.setOnClickListener  (this)
        btn_Six.setOnClickListener  (this)
        btn_Seven.setOnClickListener  (this)
        btn_Eight.setOnClickListener  (this)
        btn_Nine.setOnClickListener  (this)
        btn_Zero.setOnClickListener  (this)
        btn_Point.setOnClickListener  (this)

        btn_left_paranthesis.setOnClickListener  (this)
        btn_right_paranthesis.setOnClickListener  (this)

        btn_Plus.setOnClickListener  (this)
        btn_Minus.setOnClickListener  (this)
        btn_Multiply.setOnClickListener (this) //"\u00D7"
        btn_Divide.setOnClickListener (this) //"\u00F7"

        btn_Equal.setOnClickListener (this)
    }

    /*---------------- Interface ----------------*/
    override fun getCurrentExpression(): String {
        return tv_userInput.text.toString()
    }

    override fun setDisplay(value: String) {
        tv_userResult.text = value
    }

    override fun showError(value: String) {
        tv_userResult.text = value
    }

    override fun restartFeature() {
        val i = Intent(this.activity, MainActivity::class.java)
        this.activity!!.finish()
        startActivity(i)
    }


}