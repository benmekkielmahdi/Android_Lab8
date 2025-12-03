package com.example.projetws;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetws.beans.Etudiant;

import org.json.JSONException;
import org.json.JSONObject;

public class AddEtudiant extends AppCompatActivity implements View.OnClickListener {

    private EditText nom, prenom;
    private Spinner ville;
    private RadioButton m, f;
    private Button add;
    private RequestQueue requestQueue;

    private static final String INSERT_URL = "http://10.0.2.2:8085/api/etudiants";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        // Initialisation des vues
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        ville = findViewById(R.id.ville);
        m = findViewById(R.id.m);
        f = findViewById(R.id.f);
        add = findViewById(R.id.add);

        requestQueue = Volley.newRequestQueue(this);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == add) {
            envoyerEtudiant();
        }
    }

    private void envoyerEtudiant() {
        String sexe = m.isChecked() ? "homme" : "femme";

        // Création de l'objet JSON
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nom", nom.getText().toString());
            jsonObject.put("prenom", prenom.getText().toString());
            jsonObject.put("ville", ville.getSelectedItem().toString());
            jsonObject.put("sexe", sexe);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erreur création JSON", Toast.LENGTH_SHORT).show();
            return;
        }

        // Création de la requête JSON
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                INSERT_URL,
                jsonObject,
                response -> {
                    // Succès
                    Toast.makeText(AddEtudiant.this, "Etudiant ajouté avec succès", Toast.LENGTH_SHORT).show();
                    Log.d("VOLLEY", "Réponse : " + response.toString());
                },
                error -> {
                    // Erreur
                    Toast.makeText(AddEtudiant.this, "Erreur : " + error.toString(), Toast.LENGTH_LONG).show();
                    Log.e("VOLLEY", "Erreur : " + error.toString());
                }
        );

        // Ajouter la requête à la queue
        requestQueue.add(jsonRequest);
    }
}
