package com.pedromoreirareisgmail.capitaisdomundo;


import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();
    private static final int QUANT_PERGUNTAS = 10;
    private int mCerto = 0;

    private Button.OnClickListener clickButConferir = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            conferirEdits();
            conferirRadios();
            conferirCheck();

            mostarMensagemResposta(gerarMensagemResposta());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butConferir = (Button) findViewById(R.id.but_conferir);
        butConferir.setOnClickListener(clickButConferir);
    }

    private String gerarMensagemResposta() {
        String totalDisplay;

        totalDisplay = getResources().getString(R.string.msgRespostas) + "  " + String.valueOf(mCerto)
                + getResources().getString(R.string.msgBarra) + QUANT_PERGUNTAS +
                "\n" +
                "\n" + PERCENT_FORMAT.format(mCerto / QUANT_PERGUNTAS) +
                "  " + getResources().getString(R.string.msgDoTotal);

        return totalDisplay;
    }

    private void mostarMensagemResposta(String mensagem) {

        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setTitle(getResources().getString(R.string.msgResultado));
        alerta.setMessage(mensagem);
        alerta.setCancelable(false);
        alerta.setPositiveButton(getResources().getString(R.string.msgReiniciar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                zerarRespostas();
            }
        });
        alerta.create().show();
    }

    private void conferirEdits() {
        String respCerta;
        String respUser;

        EditText textoNoruega = (EditText) findViewById(R.id.noruega_Resp);
        textoNoruega.requestFocus();

        respUser = textoNoruega.getText().toString().toUpperCase().trim();
        if (!respUser.equals("")) {
            respCerta = getResources().getString(R.string.noruegaRespCerta).toUpperCase();

            if (respUser.equals(respCerta)) {
                mCerto++;
            }
        }

        EditText textoSuecia = (EditText) findViewById(R.id.suecia_Resp);

        respUser = textoSuecia.getText().toString().toUpperCase().trim();
        if (!respUser.equals("")) {
            respCerta = getResources().getString(R.string.sueciaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals(getResources().getString(R.string.respSuecia))) {
                mCerto++;
            }
        }
    }

    private void conferirRadios() {

        RadioGroup emiradoArabes = (RadioGroup) findViewById(R.id.emiradosArabes_RadioGroup);
        if (emiradoArabes.getCheckedRadioButtonId() == R.id.emiradosArabes_RespC) {
            mCerto++;
        }

        RadioGroup australia = (RadioGroup) findViewById(R.id.australia_RadioGroup);
        if (australia.getCheckedRadioButtonId() == R.id.australia_RespE) {
            mCerto++;
        }

        RadioGroup turquia = (RadioGroup) findViewById(R.id.turquia_RadioGroup);
        if (turquia.getCheckedRadioButtonId() == R.id.turquia_RespB) {
            mCerto++;
        }

        RadioGroup canada = (RadioGroup) findViewById(R.id.canada_RadioGroup);
        if (canada.getCheckedRadioButtonId() == R.id.canada_RespB) {
            mCerto++;
        }

        RadioGroup belgica = (RadioGroup) findViewById(R.id.belgica_RadioGroup);
        if (belgica.getCheckedRadioButtonId() == R.id.belgica_RespA) {
            mCerto++;
        }

        RadioGroup franca = (RadioGroup) findViewById(R.id.franca_RadioGroup);
        if (franca.getCheckedRadioButtonId() == R.id.franca_RespD) {
            mCerto++;
        }
    }

    private void conferirCheck() {
        CheckBox africaDoSulA = (CheckBox) findViewById(R.id.africaDoSul_RespA);
        CheckBox africaDoSulB = (CheckBox) findViewById(R.id.africaDoSul_RespB);
        CheckBox africaDoSulC = (CheckBox) findViewById(R.id.africaDoSul_RespC);
        CheckBox africaDoSulD = (CheckBox) findViewById(R.id.africaDoSul_RespD);
        CheckBox africaDoSulE = (CheckBox) findViewById(R.id.africaDoSul_RespE);

        CheckBox georgiaA = (CheckBox) findViewById(R.id.georgia_RespA);
        CheckBox georgiaB = (CheckBox) findViewById(R.id.georgia_RespB);
        CheckBox georgiaC = (CheckBox) findViewById(R.id.georgia_RespC);
        CheckBox georgiaD = (CheckBox) findViewById(R.id.georgia_RespD);
        CheckBox georgiaE = (CheckBox) findViewById(R.id.georgia_RespE);

        if (africaDoSulA.isChecked() && africaDoSulB.isChecked() &&
                africaDoSulE.isChecked() && !africaDoSulC.isChecked() &&
                !africaDoSulD.isChecked()) {
            mCerto++;
        }

        if (georgiaC.isChecked() && georgiaE.isChecked() &&
                !georgiaA.isChecked() && !georgiaB.isChecked() &&
                !georgiaD.isChecked()) {
            mCerto++;
        }
    }

    private void LimparEditsChecksRadios(ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {

            View v = vg.getChildAt(i);

            if (v instanceof EditText) {
                ((EditText) v).setText("");
            }
            if (v instanceof RadioGroup) {
                ((RadioGroup) v).clearCheck();
            }
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
            }
        }
    }

    private void zerarRespostas() {
        mCerto = 0;

        LinearLayout componentes = (LinearLayout) findViewById(R.id.linear_componentes);
        LimparEditsChecksRadios(componentes);
    }
}
