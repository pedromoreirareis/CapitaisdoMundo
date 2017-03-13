package com.pedromoreirareisgmail.capitaisdomundo;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();
    private static final double QUANT_PERGUNTAS = 10;
    private int mCerto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void butaoConferir(View view) {
        String mTotalDisplay;

        confereEdits();
        confereRadios();
        confereCheck();

        mTotalDisplay = "Respostas corretas:  " + String.valueOf(mCerto) + "/" + QUANT_PERGUNTAS +
                "\n" + PERCENT_FORMAT.format(mCerto / QUANT_PERGUNTAS) + " do total.";

        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle("RESULTADO");
        mensagem.setMessage(mTotalDisplay);
        mensagem.setCancelable(false);
        mensagem.setPositiveButton("REINICIAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                zerarRespostas();
            }
        });
        mensagem.create().show();
    }

    private void zerarRespostas() {
        mCerto = 0;

        LinearLayout componentes = (LinearLayout) findViewById(R.id.linear_componentes);
        desmarcarRadioGroup(componentes);
        desmarcarEdiText(componentes);
        desmarcarCheckBox(componentes);
    }

    private void confereEdits() {
        String respCerta;
        String respUser;

        EditText texto_noruega = (EditText) findViewById(R.id.noruega_Resp);

        texto_noruega.requestFocus();

        respUser = texto_noruega.getText().toString().toUpperCase().trim();
        if (!respUser.equals("")) {
            respCerta = getResources().getString(R.string.noruegaRespCerta).toUpperCase();

            if (respUser.equals(respCerta)) {
                mCerto++;
            }
        }

        EditText texto_suecia = (EditText) findViewById(R.id.suecia_Resp);

        respUser = texto_suecia.getText().toString().toUpperCase().trim();
        if (!respUser.equals("")) {
            respCerta = getResources().getString(R.string.sueciaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals("SUECIA")) {
                mCerto++;
            }
        }
    }

    private void confereRadios() {

        RadioGroup mEmiradoArabes = (RadioGroup) findViewById(R.id.emiradosArabes_RadioGroup);
        switch (mEmiradoArabes.getCheckedRadioButtonId()) {
            case R.id.emiradosArabes_RespC:
                mCerto++;
                break;
        }

        RadioGroup mAustralia = (RadioGroup) findViewById(R.id.australia_RadioGroup);
        switch (mAustralia.getCheckedRadioButtonId()) {
            case R.id.australia_RespE:
                mCerto++;
                break;
        }

        RadioGroup mTurquia = (RadioGroup) findViewById(R.id.turquia_RadioGroup);
        switch (mTurquia.getCheckedRadioButtonId()) {
            case R.id.turquia_RespB:
                mCerto++;
                break;
        }

        RadioGroup mCanada = (RadioGroup) findViewById(R.id.canada_RadioGroup);
        switch (mCanada.getCheckedRadioButtonId()) {
            case R.id.canada_RespB:
                mCerto++;
                break;
        }

        RadioGroup mBelgica = (RadioGroup) findViewById(R.id.belgica_RadioGroup);
        switch (mBelgica.getCheckedRadioButtonId()) {
            case R.id.belgica_RespA:
                mCerto++;
                break;
        }

        RadioGroup mfranca = (RadioGroup) findViewById(R.id.franca_RadioGroup);
        switch (mfranca.getCheckedRadioButtonId()) {
            case R.id.franca_RespD:
                mCerto++;
                break;
        }
    }

    private void confereCheck() {
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
                africaDoSulD.isChecked()) {
            mCerto++;
        }

        if (georgiaC.isChecked() && georgiaE.isChecked() &&
                !georgiaA.isChecked() && !georgiaB.isChecked() &&
                !georgiaD.isChecked()) {
            mCerto++;
        }
    }

    private void desmarcarCheckBox(ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
            }
        }
    }

    private void desmarcarRadioGroup(ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if (v instanceof RadioGroup) {
                ((RadioGroup) v).clearCheck();
            }
        }
    }

    private void desmarcarEdiText(ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if (v instanceof EditText) {
                ((EditText) v).setText("");
            }
        }
    }
}
