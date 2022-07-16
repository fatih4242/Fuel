package com.example.fuel.View;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Toast;

        import com.example.fuel.R;

        import com.example.fuel.databinding.ActivityAdminDizelBinding;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.firestore.DocumentReference;
        import com.google.firebase.firestore.DocumentSnapshot;
        import com.google.firebase.firestore.FirebaseFirestore;

        import java.util.HashMap;

public class Admin_DizelActivity extends AppCompatActivity {


    ActivityAdminDizelBinding binding;
    FirebaseFirestore db;

    DocumentReference documentDizelReference  = FirebaseFirestore.getInstance()
            .collection("FuelStation")
            .document("Shell")
            .collection("Sakarya")
            .document("Dizel");






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        binding = ActivityAdminDizelBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getFirebaseData();


        binding.updateBtn.setOnClickListener(view1 -> {

            FirebaseUpdateMethod();
        });
    }
    private void FirebaseUpdateMethod() {

        HashMap<String, Object> hashMap=new HashMap<>();
        hashMap.put("Adapazarı",binding.dizelAdapazari.getText().toString());
        hashMap.put("Akyazi",binding.dizelAkyazi.getText().toString());
        hashMap.put("Arifiye",binding.dizelArifiye.getText().toString());
        hashMap.put("Erenler",binding.dizelErenler.getText().toString());
        hashMap.put("Ferizli",binding.dizelFerizli.getText().toString());
        hashMap.put("Geyve",binding.dizelGeyve.getText().toString());
        hashMap.put("Hendek",binding.dizelHendek.getText().toString());
        hashMap.put("Karapürçek",binding.dizelKarapurcek.getText().toString());
        hashMap.put("Karasu",binding.dizelKarasu.getText().toString());
        hashMap.put("Kaynarca",binding.dizelKaynarca.getText().toString());
        hashMap.put("Kocaali",binding.dizelKocaali.getText().toString());
        hashMap.put("Pamukova",binding.dizelPamukova.getText().toString());
        hashMap.put("Sapanca",binding.dizelSapanca.getText().toString());
        hashMap.put("Serdivan",binding.dizelSerdivan.getText().toString());
        hashMap.put("Sogutlu",binding.dizelSogutlu.getText().toString());
        hashMap.put("Taraklı",binding.dizelTarakli.getText().toString());


        documentDizelReference.update(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Admin_DizelActivity.this, "Succesfull update", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Admin_DizelActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getFirebaseData() {

        //Benzin
        documentDizelReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    binding.dizelAdapazari.setText(task.getResult().get("Adapazarı").toString());
                    binding.dizelAkyazi.setText(task.getResult().get("Akyazi").toString());
                    binding.dizelArifiye.setText(task.getResult().get("Arifiye").toString());
                    binding.dizelErenler.setText(task.getResult().get("Erenler").toString());
                    binding.dizelFerizli.setText(task.getResult().get("Ferizli").toString());
                    binding.dizelGeyve.setText(task.getResult().get("Geyve").toString());
                    binding.dizelHendek.setText(task.getResult().get("Hendek").toString());
                    binding.dizelKarapurcek.setText(task.getResult().get("Karapürçek").toString());
                    binding.dizelKarasu.setText(task.getResult().get("Karasu").toString());
                    binding.dizelKaynarca.setText(task.getResult().get("Kaynarca").toString());
                    binding.dizelKocaali.setText(task.getResult().get("Kocaali").toString());
                    binding.dizelPamukova.setText(task.getResult().get("Pamukova").toString());
                    binding.dizelSapanca.setText(task.getResult().get("Sapanca").toString());
                    binding.dizelSerdivan.setText(task.getResult().get("Serdivan").toString());
                    binding.dizelSogutlu.setText(task.getResult().get("Sogutlu").toString());
                    binding.dizelTarakli.setText(task.getResult().get("Taraklı").toString());

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Admin_DizelActivity.this, "Hata", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

