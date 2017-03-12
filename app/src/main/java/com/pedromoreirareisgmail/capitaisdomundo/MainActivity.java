package com.pedromoreirareisgmail.capitaisdomundo;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import android.widget.RadioGroup;
import android.widget.Toast;


import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    private static final double QUANT_PERGUNTAS = 15;
    private static final int QUANT_PERGUNTAS_INT = 15;
    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();
    private double mTotal = 0.00;
    private String mTotalDisplay;
    private int mCerto = 0;
    private int mErrado = 0;

    private EditText mTexto_noruega;
    private EditText mTexto_suecia;
    private EditText mTexto_islandia;

    private RadioGroup mEmiradoArabes;
    private RadioGroup mAustralia;
    private RadioGroup mTurquia;
    private RadioGroup mBangladesh;
    private RadioGroup mCanada;
    private RadioGroup mCuba;
    private RadioGroup mBelgica;
    private RadioGroup mBrasil;
    private RadioGroup mfranca;

    private CheckBox mAfricaDoSulA;
    private CheckBox mAfricaDoSulB;
    private CheckBox mAfricaDoSulE;
    private CheckBox mGeorgiaC;
    private CheckBox mGeorgiaE;
    private CheckBox mBoliviaB;
    private CheckBox mBoliviaD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void butaoConferir(View view) {
        confereEdits();
        confereRadios();
        confereCheck();

        mErrado = QUANT_PERGUNTAS_INT - mCerto;
        mTotal = (mCerto / QUANT_PERGUNTAS);
        mTotalDisplay = PERCENT_FORMAT.format(mTotal);
        mTotalDisplay = "Respostas corretas: " + String.valueOf(mCerto) + " - " + mTotalDisplay +
                "\n" +
                "\nRespostas erradas: " + (mErrado) + " - " + PERCENT_FORMAT.format(1 - mTotal);

        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle("RESULTADO");
        mensagem.setMessage(mTotalDisplay);
        mensagem.create().show();

        zerarRespostas();
    }

    private void zerarRespostas() {
        mCerto = 0;
        mErrado = 0;

        mTexto_noruega.setText("");
        mTexto_suecia.setText("");
        mTexto_islandia.setText("");

        mEmiradoArabes.clearCheck();
        mAustralia.clearCheck();
        mTurquia.clearCheck();
        mBangladesh.clearCheck();
        mCanada.clearCheck();
        mCuba.clearCheck();
        mBelgica.clearCheck();
        mBrasil.clearCheck();
        mfranca.clearCheck();
    }

    private void confereEdits() {
        String respCerta = "";
        String respUser = "";

        mTexto_noruega = (EditText) findViewById(R.id.noruega_Resp);

        respUser = mTexto_noruega.getText().toString().toUpperCase().trim();
        if (respUser != null && !respUser.equals("")) {
            respCerta = getResources().getString(R.string.noruegaRespCerta).toUpperCase();

            if (respUser.equals(respCerta)) {
                mCerto++;
            }
        }

        mTexto_suecia = (EditText) findViewById(R.id.suecia_Resp);

        respUser = mTexto_suecia.getText().toString().toUpperCase().trim();
        if (respUser != null && !respUser.equals("")) {
            respCerta = getResources().getString(R.string.sueciaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals("SUECIA")) {
                mCerto++;
            }
        }

        mTexto_islandia = (EditText) findViewById(R.id.islandia_Resp);

        respUser = mTexto_islandia.getText().toString().toUpperCase().trim();
        if (respUser != null && !respUser.equals("")) {
            respCerta = getResources().getString(R.string.islandiaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals("ISLANDIA")) {
                mCerto++;
            }
        }
    }

    private void confereRadios() {

        mEmiradoArabes = (RadioGroup) findViewById(R.id.emiradosArabes_RadioGroup);
        switch (mEmiradoArabes.getCheckedRadioButtonId()) {
            case R.id.emiradosArabes_RespC:
                mCerto++;
                break;
        }

        mAustralia = (RadioGroup) findViewById(R.id.australia_RadioGroup);
        switch (mAustralia.getCheckedRadioButtonId()) {
            case R.id.australia_RespE:
                mCerto++;
                break;
        }

        mTurquia = (RadioGroup) findViewById(R.id.turquia_RadioGroup);
        switch (mTurquia.getCheckedRadioButtonId()) {
            case R.id.turquia_RespB:
                mCerto++;
                break;
        }

        mBangladesh = (RadioGroup) findViewById(R.id.bangladesh_RadioGroup);
        switch (mBangladesh.getCheckedRadioButtonId()) {
            case R.id.bangladesh_RespD:
                mCerto++;
                break;
        }


        mCanada = (RadioGroup) findViewById(R.id.canada_RadioGroup);
        switch (mCanada.getCheckedRadioButtonId()) {
            case R.id.canada_RespB:
                mCerto++;
                break;
        }

        mCuba = (RadioGroup) findViewById(R.id.cuba_RadioGroup);
        switch (mCuba.getCheckedRadioButtonId()) {
            case R.id.cuba_RespC:
                mCerto++;
                break;
        }

        mBelgica = (RadioGroup) findViewById(R.id.belgica_RadioGroup);
        switch (mBelgica.getCheckedRadioButtonId()) {
            case R.id.belgica_RespA:
                mCerto++;
                break;
        }

        mBrasil = (RadioGroup) findViewById(R.id.brasil_RadioGroup);
        switch (mBrasil.getCheckedRadioButtonId()) {
            case R.id.brasil_RespB:
                mCerto++;
                break;
        }

        mfranca = (RadioGroup) findViewById(R.id.franca_RadioGroup);
        switch (mfranca.getCheckedRadioButtonId()) {
            case R.id.franca_RespD:
                mCerto++;
                break;
        }
    }

    private void confereCheck() {
        CheckBox mAfricaDoSulA = (CheckBox) findViewById(R.id.africaDoSul_RespA);
        CheckBox mAfricaDoSulB = (CheckBox) findViewById(R.id.africaDoSul_RespB);
        CheckBox mAfricaDoSulE = (CheckBox) findViewById(R.id.africaDoSul_RespE);

        CheckBox mGeorgiaC = (CheckBox) findViewById(R.id.georgia_RespC);
        CheckBox mGeorgiaE = (CheckBox) findViewById(R.id.georgia_RespE);

        CheckBox mBoliviaB = (CheckBox) findViewById(R.id.bolivia_RespB);
        CheckBox mBoliviaD = (CheckBox) findViewById(R.id.bolivia_RespD);

        if (mAfricaDoSulA.isChecked() && mAfricaDoSulB.isChecked() && mAfricaDoSulE.isChecked()) {
            mCerto++;
        }

        if (mGeorgiaC.isChecked() && mGeorgiaE.isChecked()) {
            mCerto++;
        }

        if (mBoliviaB.isChecked() && mBoliviaD.isChecked()) {
            mCerto++;
        }
    }
}
