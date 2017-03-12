package com.pedromoreirareisgmail.capitaisdomundo;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.pedromoreirareisgmail.capitaisdomundo.R.id.emiradosArabes_RadioGroup;

public class MainActivity extends AppCompatActivity {

    private int mCerto = 0;
    private int mErrado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void butaoConferir(View view) {
        confereEdits();
        confereRadios();

        Toast.makeText(MainActivity.this, "Respostas Certas: " + String.valueOf(mCerto) + "    " +
                "Respostas Erradas: " + String.valueOf(mErrado), Toast.LENGTH_SHORT).show();

        zerarRespostas();
    }

    private void zerarRespostas() {
        mCerto = 0;
        mErrado = 0;
    }

    private void confereEdits() {
        String respCerta = "";
        String respUser = "";

        EditText texto_noruega = (EditText) findViewById(R.id.noruega_Resp);

        respUser = texto_noruega.getText().toString().toUpperCase().trim();
        if (respUser != null && !respUser.equals("")) {
            respCerta = getResources().getString(R.string.noruegaRespCerta).toUpperCase();

            if (respUser.equals(respCerta)) {
                mCerto++;
            } else {
                mErrado++;
            }
        }

        EditText texto_suecia = (EditText) findViewById(R.id.suecia_Resp);

        respUser = texto_suecia.getText().toString().toUpperCase().trim();
        if (respUser != null && !respUser.equals("")) {
            respCerta = getResources().getString(R.string.sueciaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals("SUECIA")) {
                mCerto++;
            } else {
                mErrado++;
            }
        }

        EditText texto_islandia = (EditText) findViewById(R.id.islandia_Resp);

        respUser = texto_islandia.getText().toString().toUpperCase().trim();
        if (respUser != null && !respUser.equals("")) {
            respCerta = getResources().getString(R.string.islandiaRespCerta).toUpperCase();

            if (respUser.equals(respCerta) || respUser.equals("ISLANDIA")) {
                mCerto++;
            } else {
                mErrado++;
            }
        }
    }

    private void confereRadios() {

        RadioGroup mEmiradoArabes = (RadioGroup) findViewById(R.id.emiradosArabes_RadioGroup);
        switch (mEmiradoArabes.getCheckedRadioButtonId()) {
            case R.id.emiradosArabes_RespA:
                mErrado++;
                break;
            case R.id.emiradosArabes_RespB:
                mErrado++;
                break;
            case R.id.emiradosArabes_RespC:
                mCerto++;
                break;
            case R.id.emiradosArabes_RespD:
                mErrado++;
                break;
            case R.id.emiradosArabes_RespE:
                mErrado++;
                break;
        }

        RadioGroup mAustralia = (RadioGroup) findViewById(R.id.australia_RadioGroup);
        switch (mAustralia.getCheckedRadioButtonId()) {
            case R.id.australia_RespA:
                mErrado++;
                break;
            case R.id.australia_RespB:
                mErrado++;
                break;
            case R.id.australia_RespC:
                mErrado++;
                break;
            case R.id.australia_RespD:
                mErrado++;
                break;
            case R.id.australia_RespE:
                mCerto++;
                break;
        }

        RadioGroup mTurquia = (RadioGroup) findViewById(R.id.turquia_RadioGroup);
        switch (mTurquia.getCheckedRadioButtonId()) {
            case R.id.turquia_RespA:
                mErrado++;
                break;
            case R.id.turquia_RespB:
                mCerto++;
                break;
            case R.id.turquia_RespC:
                mErrado++;
                break;
            case R.id.turquia_RespD:
                mErrado++;
                break;
            case R.id.turquia_RespE:
                mErrado++;
                break;
        }

        RadioGroup mBangladesh = (RadioGroup) findViewById(R.id.bangladesh_RadioGroup);
        switch (mBangladesh.getCheckedRadioButtonId()) {
            case R.id.bangladesh_RespA:
                mErrado++;
                break;
            case R.id.bangladesh_RespB:
                mErrado++;
                break;
            case R.id.bangladesh_RespC:
                mErrado++;
                break;
            case R.id.bangladesh_RespD:
                mCerto++;
                break;
            case R.id.bangladesh_RespE:
                mErrado++;
                break;
        }

        RadioGroup mCanada = (RadioGroup) findViewById(R.id.canada_RadioGroup);
        switch (mCanada.getCheckedRadioButtonId()) {
            case R.id.canada_RespA:
                mErrado++;
                break;
            case R.id.canada_RespB:
                mCerto++;
                break;
            case R.id.canada_RespC:
                mErrado++;
                break;
            case R.id.canada_RespD:
                mErrado++;
                break;
            case R.id.canada_RespE:
                mErrado++;
                break;
        }

        RadioGroup mCuba = (RadioGroup) findViewById(R.id.cuba_RadioGroup);
        switch (mCuba.getCheckedRadioButtonId()) {
            case R.id.cuba_RespA:
                mErrado++;
                break;
            case R.id.cuba_RespB:
                mErrado++;
                break;
            case R.id.cuba_RespC:
                mCerto++;
                break;
            case R.id.cuba_RespD:
                mErrado++;
                break;
            case R.id.cuba_RespE:
                mErrado++;
                break;
        }

        RadioGroup mBelgica = (RadioGroup) findViewById(R.id.belgica_RadioGroup);
        switch (mBelgica.getCheckedRadioButtonId()) {
            case R.id.belgica_RespA:
                mCerto++;
                break;
            case R.id.belgica_RespB:
                mErrado++;
                break;
            case R.id.belgica_RespC:
                mErrado++;
                break;
            case R.id.belgica_RespD:
                mErrado++;
                break;
            case R.id.belgica_RespE:
                mErrado++;
                break;
        }

        RadioGroup mBrasil = (RadioGroup) findViewById(R.id.brasil_RadioGroup);
        switch (mBrasil.getCheckedRadioButtonId()) {
            case R.id.brasil_RespA:
                mErrado++;
                break;
            case R.id.brasil_RespB:
                mCerto++;
                break;
            case R.id.brasil_RespC:
                mErrado++;
                break;
            case R.id.brasil_RespD:
                mErrado++;
                break;
            case R.id.brasil_RespE:
                mErrado++;
                break;
        }

        RadioGroup mfranca = (RadioGroup) findViewById(R.id.franca_RadioGroup);
        switch (mfranca.getCheckedRadioButtonId()) {
            case R.id.franca_RespA:
                mErrado++;
                break;
            case R.id.franca_RespB:
                mErrado++;
                break;
            case R.id.franca_RespC:
                mErrado++;
                break;
            case R.id.franca_RespD:
                mCerto++;
                break;
            case R.id.franca_RespE:
                mErrado++;
                break;
        }


    }


}
