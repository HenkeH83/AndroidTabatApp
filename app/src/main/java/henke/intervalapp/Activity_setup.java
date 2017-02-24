package henke.intervalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_setup extends AppCompatActivity {

    private Run runner;
    private Button done;
    private EditText setRun, setRest, setLaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        setRun = (EditText) findViewById(R.id.setRun);
        setRest = (EditText) findViewById(R.id.setRest);
        setLaps = (EditText) findViewById(R.id.setLap);
        done = (Button) findViewById(R.id.btnDone);
        runner = new Run();
    }

    /**
     * Gets values from EditText and sets Run variables.
     * Exits to MainActivity.
     * @param view
     */
    public void doneButton(View view){
        if(!isInt(setRun.getText().toString())
                || !isInt(setRest.getText().toString())
                || !isInt(setLaps.getText().toString())){
            Toast.makeText(this, "Set all numbers", Toast.LENGTH_SHORT).show();
        } else {
            runner.setRunTime(Long.parseLong(setRun.getText().toString()));
            runner.setRestTime(Long.parseLong(setRest.getText().toString()));
            runner.setLapsConstant(Integer.parseInt(setLaps.getText().toString()));
            Intent change = new Intent(this, MainActivity.class);
            startActivity(change);
        }
    }

    /**
     * Checks the input from user.
     * @param text
     * @return True if Interger, false if not :)
     */
    public boolean isInt(String text){
        try{
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException exc){
            return false;
        }
    }



}
