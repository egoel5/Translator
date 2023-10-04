package com.example.c323_project5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var engSrc : RadioButton
    lateinit var spnSrc : RadioButton
    lateinit var gerSrc : RadioButton
    lateinit var engTrn : RadioButton
    lateinit var spnTrn : RadioButton
    lateinit var gerTrn : RadioButton
    lateinit var tvTranslation : TextView
    lateinit var textToTranslate : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        engSrc = findViewById(R.id.eng_src_but)
        spnSrc = findViewById(R.id.spn_src_but)
        gerSrc = findViewById(R.id.ger_src_but)
        engTrn = findViewById(R.id.eng_trn_but)
        spnTrn = findViewById(R.id.spn_trn_but)
        gerTrn = findViewById(R.id.ger_trn_but)
        tvTranslation = findViewById(R.id.tvTranslation)
        textToTranslate = findViewById(R.id.textToTranslate)

        textToTranslate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (engSrc.isChecked && engTrn.isChecked) {
                    tvTranslation.text = textToTranslate.text
                }
                else if (engSrc.isChecked && spnTrn.isChecked) {
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.SPANISH)
                        .build()
                    val englishSpanishTranslator = Translation.getClient(options)
                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    englishSpanishTranslator.downloadModelIfNeeded(conditions)
                    englishSpanishTranslator.translate(textToTranslate.text.toString())
                        .addOnSuccessListener { translatedText ->
                        tvTranslation.text = translatedText
                    }
                }
                else if (engSrc.isChecked && gerTrn.isChecked) {
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.ENGLISH)
                        .setTargetLanguage(TranslateLanguage.GERMAN)
                        .build()
                    val englishGermanTranslator = Translation.getClient(options)
                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    englishGermanTranslator.downloadModelIfNeeded(conditions)
                    englishGermanTranslator.translate(textToTranslate.text.toString())
                        .addOnSuccessListener { translatedText ->
                            tvTranslation.text = translatedText
                        }
                }
                else if (spnSrc.isChecked && engTrn.isChecked) {
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.SPANISH)
                        .setTargetLanguage(TranslateLanguage.ENGLISH)
                        .build()
                    val spanishEnglishTranslator = Translation.getClient(options)
                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    spanishEnglishTranslator.downloadModelIfNeeded(conditions)
                    spanishEnglishTranslator.translate(textToTranslate.text.toString())
                        .addOnSuccessListener { translatedText ->
                            tvTranslation.text = translatedText
                        }
                }
                else if (spnSrc.isChecked && spnTrn.isChecked) {
                    tvTranslation.text = textToTranslate.text
                }
                else if (spnSrc.isChecked && gerTrn.isChecked) {
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.SPANISH)
                        .setTargetLanguage(TranslateLanguage.GERMAN)
                        .build()
                    val spanishGermanTranslator = Translation.getClient(options)
                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    spanishGermanTranslator.downloadModelIfNeeded(conditions)
                    spanishGermanTranslator.translate(textToTranslate.text.toString())
                        .addOnSuccessListener { translatedText ->
                            tvTranslation.text = translatedText
                        }
                }
                else if (gerSrc.isChecked && engTrn.isChecked) {
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.GERMAN)
                        .setTargetLanguage(TranslateLanguage.ENGLISH)
                        .build()
                    val spanishEnglishTranslator = Translation.getClient(options)
                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    spanishEnglishTranslator.downloadModelIfNeeded(conditions)
                    spanishEnglishTranslator.translate(textToTranslate.text.toString())
                        .addOnSuccessListener { translatedText ->
                            tvTranslation.text = translatedText
                        }
                }
                else if (gerSrc.isChecked && spnTrn.isChecked) {
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(TranslateLanguage.GERMAN)
                        .setTargetLanguage(TranslateLanguage.SPANISH)
                        .build()
                    val germanSpanishTranslator = Translation.getClient(options)
                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    germanSpanishTranslator.downloadModelIfNeeded(conditions)
                    germanSpanishTranslator.translate(textToTranslate.text.toString())
                        .addOnSuccessListener { translatedText ->
                            tvTranslation.text = translatedText
                        }
                }
                else if (gerSrc.isChecked && gerTrn.isChecked) {
                    tvTranslation.text = textToTranslate.text
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}