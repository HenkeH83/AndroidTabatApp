package henke.intervalapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Run runner;
    private Pauser pauser;
    Stopper stopper;
    private TextView activity,timer,laps;
    private Button start, stop, setup, pause;
    private Vibrator v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        runner = new Run(this, v);
        pauser = new Pauser(runner);
        stopper = new Stopper(runner, this);
        activity = (TextView) findViewById(R.id.activity);
        timer = (TextView) findViewById(R.id.timer);
        laps = (TextView) findViewById(R.id.laps);
        start = (Button)  findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        pause = (Button) findViewById(R.id.pause);
        setup = (Button) findViewById(R.id.setup);
     }

    /**
     * Changes activity to setup.
     * @param view
     */
    public void showSetup(View view){
        Intent enterSetup = new Intent(this, Activity_setup.class);
        startActivity(enterSetup);
    }

    /**
     * Stops the Activity
     * @param view
     */
    public void stopButton(View view){
        stopper.stop();
        if(pauser.isPaused()) {
            pauser.setCheckFalse();
            pause.setText("Pause");
        }
    }

    /**
     * Pauses the activity, and then calls it back up.
     * @param view
     */
    public void pauseButton(View view){
        if(!pauser.isPaused()) {
            pause.setText("Resume");
            runner.setTotTimer();
            pauser.pause();
        } else {
            pause.setText("Pause");
            pauser.unPause();
        }
    }

    /**
     * Starts the activity.
     * @param view
     */
    public void startButton (View view){
        if(!runner.isStarted()) {
            stopper.setStop();
            runner.startRun();
        } else{

        }
    }

    public void setActivity(String state){
        activity.setText(state);
    }

    public void setTime(long time) {
        timer.setText("" + time);
    }

    public void setLap() {
        laps.setText("" + runner.getLapsCount());
    }


    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
