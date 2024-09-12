package com.example.myapplication

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Define o layout da atividade principal

        // Inicializa o WebView
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.webViewClient = WebViewClient()

        // Configura o WebView para permitir JavaScript
        val webSettings: WebSettings = myWebView.settings
        webSettings.javaScriptEnabled = true

        // Carrega o endereço do servidor Laravel
        myWebView.loadUrl("http://192.168.0.11:8000") // Substitua <seu-ip-local> pelo IP do seu computador
    }

    override fun onBackPressed() {
        val myWebView: WebView = findViewById(R.id.webview)
        if (myWebView.canGoBack()) {
            myWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
