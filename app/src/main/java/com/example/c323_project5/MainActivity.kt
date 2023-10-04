package com.example.c323_project5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.c323_project5.databinding.ActivityMainBinding
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.languageid.LanguageIdentification
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // lateinit some Views that need to be initialized in onCreate to make sure they are never null
    lateinit var engSrc : RadioButton
    lateinit var spnSrc : RadioButton
    lateinit var gerSrc : RadioButton
    lateinit var detSrc : RadioButton
    lateinit var engTrn : RadioButton
    lateinit var spnTrn : RadioButton
    lateinit var gerTrn : RadioButton
    lateinit var tvTranslation : TextView
    lateinit var textToTranslate : EditText
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // initialize all the ViewModels that needed to be initialized
        engSrc = binding.engSrcBut
        spnSrc = binding.spnSrcBut
        gerSrc = binding.gerSrcBut
        detSrc = binding.detSrcBut
        engTrn = binding.engTrnBut
        spnTrn = binding.spnTrnBut
        gerTrn = binding.gerTrnBut
        tvTranslation = binding.tvTranslation
        textToTranslate = binding.textToTranslate

        /**
         * textChangedListened using TextWatcher to accurately translate text based on user chosen
         * languages
         *
         * For each non-duplicate selection, the TranslatorOptions is built setting sourceLanguage
         * and TargetLanguage to user selection, then the conditions are downloaded, then the text
         * is translated, and if the translation is successful, tvTranslation's text is set to
         * translated text
         */
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
                else if (detSrc.isChecked && engTrn.isChecked) {
                    val languageIdentifier = LanguageIdentification.getClient()
                    languageIdentifier.identifyLanguage(textToTranslate.text.toString())
                        .addOnSuccessListener { languageCode ->
                            if (languageCode == "und") {
                                Log.v("undLang", "Can't identify language.")
                            } else {
                                val options = TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.fromLanguageTag(languageCode).toString())
                                    .setTargetLanguage(TranslateLanguage.ENGLISH)
                                    .build()
                                val detectEnglishTranslator = Translation.getClient(options)
                                var conditions = DownloadConditions.Builder()
                                    .requireWifi()
                                    .build()
                                detectEnglishTranslator.downloadModelIfNeeded(conditions)
                                detectEnglishTranslator.translate(textToTranslate.text.toString())
                                    .addOnSuccessListener { translatedText ->
                                        tvTranslation.text = translatedText
                                    }
                            }
                        }
                        .addOnFailureListener {
                            Log.v("err", "Unidentified error")
                        }
                }
                else if (detSrc.isChecked && spnTrn.isChecked) {
                    val languageIdentifier = LanguageIdentification.getClient()
                    languageIdentifier.identifyLanguage(textToTranslate.text.toString())
                        .addOnSuccessListener { languageCode ->
                            if (languageCode == "und") {
                                Log.v("undLang", "Can't identify language.")
                            } else {
                                val options = TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.fromLanguageTag(languageCode).toString())
                                    .setTargetLanguage(TranslateLanguage.SPANISH)
                                    .build()
                                val detectSpanishTranslator = Translation.getClient(options)
                                var conditions = DownloadConditions.Builder()
                                    .requireWifi()
                                    .build()
                                detectSpanishTranslator.downloadModelIfNeeded(conditions)
                                detectSpanishTranslator.translate(textToTranslate.text.toString())
                                    .addOnSuccessListener { translatedText ->
                                        tvTranslation.text = translatedText
                                    }
                            }
                        }
                        .addOnFailureListener {
                            Log.v("err", "Unidentified error")
                        }
                }
                else if (detSrc.isChecked && gerTrn.isChecked) {
                    val languageIdentifier = LanguageIdentification.getClient()
                    languageIdentifier.identifyLanguage(textToTranslate.text.toString())
                        .addOnSuccessListener { languageCode ->
                            if (languageCode == "und") {
                                Log.v("undLang", "Can't identify language.")
                            } else {
                                val options = TranslatorOptions.Builder()
                                    .setSourceLanguage(TranslateLanguage.fromLanguageTag(languageCode).toString())
                                    .setTargetLanguage(TranslateLanguage.GERMAN)
                                    .build()
                                val detectGermanTranslator = Translation.getClient(options)
                                var conditions = DownloadConditions.Builder()
                                    .requireWifi()
                                    .build()
                                detectGermanTranslator.downloadModelIfNeeded(conditions)
                                detectGermanTranslator.translate(textToTranslate.text.toString())
                                    .addOnSuccessListener { translatedText ->
                                        tvTranslation.text = translatedText
                                    }
                            }
                        }
                        .addOnFailureListener {
                            Log.v("err", "Unidentified error")
                        }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}