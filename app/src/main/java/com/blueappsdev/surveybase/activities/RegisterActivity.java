package com.blueappsdev.surveybase.activities;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blueappsdev.surveybase.R;
import com.blueappsdev.surveybase.models.CreateUser;
import com.blueappsdev.surveybase.utils.Constants;
import com.blueappsdev.surveybase.utils.MakeRequest;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Response;
import st.lowlevel.storo.Storo;

/**
 * Created by douglas_nunes on 1/7/17.
 */


@EActivity(R.layout.activity_register)
public class RegisterActivity extends DefaultActivity {

    @ViewById
    TextView neighborhoodSelection;

    @ViewById
    TextInputEditText nameEditText, emailEditText;

    ArrayList<String> neighborhoodsArray = new ArrayList<>();

    String selectedNeighborhood = "";

    Gson gson = new Gson();

    @AfterViews
    void afterViews(){

        populateArray();

        GradientDrawable gradientDrawable = new GradientDrawable();

        gradientDrawable.setStroke(2, Color.WHITE);

        gradientDrawable.setColor(Color.TRANSPARENT);

        neighborhoodSelection.setBackground(gradientDrawable);

        nameEditText.clearFocus();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    @Click(R.id.neighborhoodSelection)
    void neighborhoodClicked(){

        new MaterialDialog.Builder(this)
                .title("Selecione seu bairo")
                .items(neighborhoodsArray)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {

                        selectedNeighborhood = text.toString();

                        neighborhoodSelection.setText(selectedNeighborhood);

                        return true;
                    }
                })
                .positiveText("Ok")
                .show();

    }

    @Click(R.id.continueButton)
    void continueClicked(){

        if (!nameEditText.getText().toString().equalsIgnoreCase("") &&
                !emailEditText.getText().toString().equalsIgnoreCase("") &&
                !selectedNeighborhood.equalsIgnoreCase("")){

            this.showLoading();

            saveUser();

        }else{

            QuestionsActivity_.intent(this).start();

        }

    }

    @Background
    void saveUser(){

        try{

            HashMap<String, Object> params = new HashMap<>();

            params.put("name", nameEditText.getText().toString());
            params.put("email", emailEditText.getText().toString());
            params.put("neighborhood", selectedNeighborhood);

            Response response = MakeRequest.post(Constants.url("createUser/"), params);

            CreateUser createUser = gson.fromJson(response.body().string(), CreateUser.class);

            Storo.put(Constants.USER_KEY, createUser);

            this.dismissLoading();

            QuestionsActivity_.intent(this).start();

        }catch (Exception e){

            QuestionsActivity_.intent(this).start();

        }

    }

    void populateArray(){

        neighborhoodsArray.add("Aerolândia");
        neighborhoodsArray.add("Aeroporto");
        neighborhoodsArray.add("Aldeota");
        neighborhoodsArray.add("Alto da Balança");
        neighborhoodsArray.add("Amadeu Furtado");
        neighborhoodsArray.add("Ancuri");
        neighborhoodsArray.add("Antônio Bezerra");
        neighborhoodsArray.add("Autran Nunes");
        neighborhoodsArray.add("Álvaro Weyne");
        neighborhoodsArray.add("Barra do Ceará");
        neighborhoodsArray.add("Barroso");
        neighborhoodsArray.add("Bela Vista");
        neighborhoodsArray.add("Benfica");
        neighborhoodsArray.add("Boa Vista");
        neighborhoodsArray.add("Bom Futuro");
        neighborhoodsArray.add("Bom Jardim");
        neighborhoodsArray.add("Bonsucesso");
        neighborhoodsArray.add("Cais do Porto");
        neighborhoodsArray.add("Cajazeiras");
        neighborhoodsArray.add("Cambeba");
        neighborhoodsArray.add("Canindezinho");
        neighborhoodsArray.add("Carlito Pamplona");
        neighborhoodsArray.add("Centro");
        neighborhoodsArray.add("Cidade 2000");
        neighborhoodsArray.add("Cidade dos Funcionários");
        neighborhoodsArray.add("Coaçu");
        neighborhoodsArray.add("Cocó");
        neighborhoodsArray.add("Conjunto Ceará I");
        neighborhoodsArray.add("Conjunto Ceará II");
        neighborhoodsArray.add("Conjunto Esperança");
        neighborhoodsArray.add("Conjunto Palmeiras");
        neighborhoodsArray.add("Couto Fernandes");
        neighborhoodsArray.add("Cristo Redentor");
        neighborhoodsArray.add("Curió");
        neighborhoodsArray.add("Damas");
        neighborhoodsArray.add("De Lourdes");
        neighborhoodsArray.add("Demócrito Rocha");
        neighborhoodsArray.add("Dendê");
        neighborhoodsArray.add("Dias Macedo");
        neighborhoodsArray.add("Dionísio Torres");
        neighborhoodsArray.add("Dom Lustosa");
        neighborhoodsArray.add("Edson Queiroz");
        neighborhoodsArray.add("Engenheiro Luciano Cavalcante");
        neighborhoodsArray.add("Farias Brito");
        neighborhoodsArray.add("Floresta");
        neighborhoodsArray.add("Fátima");
        neighborhoodsArray.add("Genibaú");
        neighborhoodsArray.add("Granja Lisboa");
        neighborhoodsArray.add("Granja Portugal");
        neighborhoodsArray.add("Guajeru");
        neighborhoodsArray.add("Guararapes");
        neighborhoodsArray.add("Henrique Jorge");
        neighborhoodsArray.add("Itaoca");
        neighborhoodsArray.add("Itaperi");
        neighborhoodsArray.add("Jacarecanga");
        neighborhoodsArray.add("Jangurussu");
        neighborhoodsArray.add("Jardim América");
        neighborhoodsArray.add("Jardim Cearense");
        neighborhoodsArray.add("Jardim das Oliveiras");
        neighborhoodsArray.add("Jardim Guanabara");
        neighborhoodsArray.add("Jardim Iracema");
        neighborhoodsArray.add("Joaquim Távora");
        neighborhoodsArray.add("José Bonifácio");
        neighborhoodsArray.add("José de Alencar");
        neighborhoodsArray.add("João XXIII");
        neighborhoodsArray.add("Jóquei Clube");
        neighborhoodsArray.add("Lagoa Redonda");
        neighborhoodsArray.add("Manoel Sátiro");
        neighborhoodsArray.add("Manuel Dias Branco");
        neighborhoodsArray.add("Maraponga");
        neighborhoodsArray.add("Meireles");
        neighborhoodsArray.add("Messejana");
        neighborhoodsArray.add("Mondubim");
        neighborhoodsArray.add("Monte Castelo");
        neighborhoodsArray.add("Montese");
        neighborhoodsArray.add("Moura Brasil");
        neighborhoodsArray.add("Mucuripe");
        neighborhoodsArray.add("Olavo Oliveira");
        neighborhoodsArray.add("Padre Andrade");
        neighborhoodsArray.add("Panamericano");
        neighborhoodsArray.add("Papicu");
        neighborhoodsArray.add("Parangaba");
        neighborhoodsArray.add("Parque Araxá");
        neighborhoodsArray.add("Parque Dois Irmãos");
        neighborhoodsArray.add("Parque Iracema");
        neighborhoodsArray.add("Parque Manibura");
        neighborhoodsArray.add("Parquelândia");
        neighborhoodsArray.add("Parreão");
        neighborhoodsArray.add("Passaré");
        neighborhoodsArray.add("Paupina");
        neighborhoodsArray.add("Pedras");
        neighborhoodsArray.add("Pici");
        neighborhoodsArray.add("Pirambú");
        neighborhoodsArray.add("Planalto Ayrton Senna");
        neighborhoodsArray.add("Praia de Iracema");
        neighborhoodsArray.add("Praia do Futuro I");
        neighborhoodsArray.add("Praia do Futuro II");
        neighborhoodsArray.add("Prefeito José Walter");
        neighborhoodsArray.add("Presidente Kennedy");
        neighborhoodsArray.add("Presidente Vargas");
        neighborhoodsArray.add("Quintino Cunha");
        neighborhoodsArray.add("Rodolfo Teófilo");
        neighborhoodsArray.add("Sabiaguaba");
        neighborhoodsArray.add("Salinas");
        neighborhoodsArray.add("Santa Maria");
        neighborhoodsArray.add("Santa Rosa");
        neighborhoodsArray.add("Sapiranga / Coité");
        neighborhoodsArray.add("Serrinha");
        neighborhoodsArray.add("Siqueira");
        neighborhoodsArray.add("São Bento");
        neighborhoodsArray.add("São Gerardo");
        neighborhoodsArray.add("São José");
        neighborhoodsArray.add("São João do Tauape");
        neighborhoodsArray.add("Varjota");
        neighborhoodsArray.add("Vicente Pinzon");
        neighborhoodsArray.add("Vila Ellery");
        neighborhoodsArray.add("Vila Peri");
        neighborhoodsArray.add("Vila União");
        neighborhoodsArray.add("Vila Velha");

    }

}
