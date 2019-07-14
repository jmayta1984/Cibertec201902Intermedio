package pe.edu.cibertec.testing;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FizzBuzzActivity extends AppCompatActivity {

    TextInputEditText etNumber;
    Button btExecute;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fizz_buzz);
        initView();
        setListeners();
    }

    private void setListeners() {
        btExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(etNumber.getText().toString());
                FizzBuzz fizzBuzz = new FizzBuzz();

                String message = fizzBuzz.execute(number);
                tvMessage.setText(message);
            }
        });
    }

    private void initView() {
        etNumber = findViewById(R.id.etNumber);
        btExecute = findViewById(R.id.btExecute);
        tvMessage = findViewById(R.id.tvMessage);
    }
}
