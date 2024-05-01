package com.ksofttech.cheezycodedemo.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ksofttech.cheezycodedemo.R

class QuotesVActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnNext: Button
    lateinit var btnPreVious: Button
    lateinit var tvQuotes: TextView

    lateinit var quotesViewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        quotesViewModel =
            ViewModelProvider(this, QuotesFactory(application))[QuotesViewModel::class.java]

        initUI()

        setQuotes(quotesViewModel.getQuotes())
    }

    private fun initUI() {
        tvQuotes = findViewById(R.id.tvQuotes)
        btnNext = findViewById(R.id.btnNext)
        btnPreVious = findViewById(R.id.btnPreVious)

        btnNext.setOnClickListener(this)
        btnPreVious.setOnClickListener(this)
    }

    fun setQuotes(quotes: Quotes) {
        tvQuotes.text = quotes.text + "\n" + quotes.author
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnNext -> {
                quotesViewModel.getNextQuotes()
                setQuotes(quotesViewModel.getQuotes())
            }

            R.id.btnPreVious -> {
                quotesViewModel.getPreviousQuotes()
                setQuotes(quotesViewModel.getQuotes())
            }

            else -> {

            }
        }
    }
}