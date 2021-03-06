package id.zainalfahrudin.hitungluas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        txtLuas = (TextView)findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                if (panjang.length()<1){
                    edtPanjang.setError("tidak boleh kosong");
                    txtLuas.setText("");
                }else if (!isDouble(panjang)){
                    edtPanjang.setError("inputan harus angka");
                    txtLuas.setText("");
                }else if (lebar.length()<1){
                    edtPanjang.setError(null);
                    edtLebar.setError("tidak boleh kosong");
                    txtLuas.setText("");
                }else if (!isDouble(lebar)){
                    edtLebar.setError("inputan harus angka");
                    txtLuas.setText("");
                }else{
                    edtLebar.setError(null);
                    edtPanjang.setError(null);
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);

                    double luas = p * l;

                    txtLuas.setText("Luas : "+luas);

                }
            }
        });
    }


    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
