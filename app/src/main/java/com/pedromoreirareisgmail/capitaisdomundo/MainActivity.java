package com.pedromoreirareisgmail.capitaisdomundo;


import android.app.Activity;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.pedromoreirareisgmail.capitaisdomundo.databinding.ActivityMainBinding;

import java.text.NumberFormat;


public class MainActivity extends Activity {

    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();
    private static final int QUANT_PERGUNTAS = 10;
    private ActivityMainBinding binding;
    private int mCerto = 0;
    private final Button.OnClickListener clickButConferir = new Button.OnClickListener() {
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
        //SetContentView para Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.butConferir.setOnClickListener(clickButConferir);
    }

    private String gerarMensagemResposta() {
        String totalDisplay;

        totalDisplay = getResources().getString(R.string.msgRespostas) + "  " + String.valueOf(mCerto)
                + getResources().getString(R.string.msgBarra) + QUANT_PERGUNTAS +
                "\n" +
                "\n" + PERCENT_FORMAT.format(mCerto / Double.valueOf(QUANT_PERGUNTAS)) +
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
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                binding.includedEdit.noruegaResp.requestFocus();
            }
        });
        alerta.create().show();
    }

    private void conferirEdits() {
        String respCerta;
        String respUser;

        respUser = binding.includedEdit.noruegaResp.getText().toString().toUpperCase().trim();
        if (!respUser.equals("")) {
            respCerta = getResources().getString(R.string.noruegaRespCerta).toUpperCase();

            if (respUser.equals(respCerta)) {
                mCerto++;
            }
        }

        respUser = binding.includedEdit.sueciaResp.getText().toString().toUpperCase().trim();
        if (!respUser.equals("")) {
            respCerta = getResources().getString(R.string.sueciaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals(getResources().getString(R.string.respSuecia))) {
                mCerto++;
            }
        }
    }

    private void conferirRadios() {

        if (binding.includedRadio.emiradosArabesRadioGroup.getCheckedRadioButtonId() == R.id.emiradosArabes_RespC) {
            mCerto++;
        }

        if (binding.includedRadio.australiaRadioGroup.getCheckedRadioButtonId() == R.id.australia_RespE) {
            mCerto++;
        }

        if (binding.includedRadio.turquiaRadioGroup.getCheckedRadioButtonId() == R.id.turquia_RespB) {
            mCerto++;
        }

        if (binding.includedRadio.canadaRadioGroup.getCheckedRadioButtonId() == R.id.canada_RespB) {
            mCerto++;
        }

        if (binding.includedRadio.belgicaRadioGroup.getCheckedRadioButtonId() == R.id.belgica_RespA) {
            mCerto++;
        }

        if (binding.includedRadio.francaRadioGroup.getCheckedRadioButtonId() == R.id.franca_RespD) {
            mCerto++;
        }
    }

    private void conferirCheck() {

        if (binding.includedCheck.africaDoSulRespA.isChecked() && binding.includedCheck.africaDoSulRespB.isChecked() &&
                binding.includedCheck.africaDoSulRespE.isChecked() && !binding.includedCheck.africaDoSulRespC.isChecked() &&
                !binding.includedCheck.africaDoSulRespD.isChecked()) {
            mCerto++;
        }

        if (binding.includedCheck.georgiaRespC.isChecked() && binding.includedCheck.georgiaRespE.isChecked() &&
                !binding.includedCheck.georgiaRespA.isChecked() && !binding.includedCheck.georgiaRespB.isChecked() &&
                !binding.includedCheck.georgiaRespD.isChecked()) {
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

        LimparEditsChecksRadios(binding.linearComponentes);
    }
}
