package com.example.fuel.View;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



        import android.view.View;
import android.widget.Toast;

import com.example.fuel.R;

import com.example.fuel.databinding.ActivityAdminLpgBinding;
import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
        import com.google.firebase.firestore.DocumentSnapshot;
        import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Admin_LpgActivity extends AppCompatActivity {


    ActivityAdminLpgBinding binding;


    DocumentReference documentLPGReference  = FirebaseFirestore.getInstance()
            .collection("FuelStation")
            .document("Shell")
            .collection("Sakarya")
            .document("LPG");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        binding = ActivityAdminLpgBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getFirebaseData();


        binding.updateBtn.setOnClickListener(view1 -> {

            FirebaseUpdateMethod();
        });
    }
    private void FirebaseUpdateMethod() {

        HashMap<String, Object> hashMap=new HashMap<>();
        hashMap.put("Adapazarı",binding.LpgAdapazari.getText().toString());
        hashMap.put("Akyazi",binding.LpgAkyazi.getText().toString());
        hashMap.put("Arifiye",binding.LpgArifiye.getText().toString());
        hashMap.put("Erenler",binding.LpgErenler.getText().toString());
        hashMap.put("Ferizli",binding.LpgFerizli.getText().toString());
        hashMap.put("Geyve",binding.LpgGeyve.getText().toString());
        hashMap.put("Hendek",binding.LpgHendek.getText().toString());
        hashMap.put("Karapürçek",binding.LpgKarapurcek.getText().toString());
        hashMap.put("Karasu",binding.LpgKarasu.getText().toString());
        hashMap.put("Kaynarca",binding.LpgKaynarca.getText().toString());
        hashMap.put("Kocaali",binding.LpgKocaali.getText().toString());
        hashMap.put("Pamukova",binding.LpgPamukova.getText().toString());
        hashMap.put("Sapanca",binding.LpgSapanca.getText().toString());
        hashMap.put("Serdivan",binding.LpgSerdivan.getText().toString());
        hashMap.put("Sogutlu",binding.LpgSogutlu.getText().toString());
        hashMap.put("Taraklı",binding.LpgTarakli.getText().toString());


        documentLPGReference.update(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Admin_LpgActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getFirebaseData() {

        //Benzin
        documentLPGReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    binding.LpgAdapazari.setText(task.getResult().get("Adapazarı").toString());
                    binding.LpgAkyazi.setText(task.getResult().get("Akyazı").toString());
                    binding.LpgArifiye.setText(task.getResult().get("Arifiye").toString());
                    binding.LpgErenler.setText(task.getResult().get("Erenler").toString());
                    binding.LpgFerizli.setText(task.getResult().get("Ferizli").toString());
                    binding.LpgGeyve.setText(task.getResult().get("Geyve").toString());
                    binding.LpgHendek.setText(task.getResult().get("Hendek").toString());
                    binding.LpgKarapurcek.setText(task.getResult().get("Karapürçek").toString());
                    binding.LpgKarasu.setText(task.getResult().get("Karasu").toString());
                    binding.LpgKaynarca.setText(task.getResult().get("Kaynarca").toString());
                    binding.LpgKocaali.setText(task.getResult().get("Kocaali").toString());
                    binding.LpgPamukova.setText(task.getResult().get("Pamukova").toString());
                    binding.LpgSapanca.setText(task.getResult().get("Sapanca").toString());
                    binding.LpgSerdivan.setText(task.getResult().get("Serdivan").toString());
                    binding.LpgSogutlu.setText(task.getResult().get("Sogutlu").toString());
                    binding.LpgTarakli.setText(task.getResult().get("Taraklı").toString());

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Admin_LpgActivity.this, "Hata", Toast.LENGTH_SHORT).show();
            }
        });


    }
}


