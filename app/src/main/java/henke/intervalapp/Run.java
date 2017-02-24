package henke.intervalapp;

import android.os.Vibrator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Henke on 2017-01-10.
 */

public class Run extends AppCompatActivity {


    private static long runTime;
    private static long restTime;
    private static int lapsConstant;
    private int lapsCount;
    private long totTime; // möjliga problem med totTimeem sen
    private long totTimer;
    private int restCounter = 0;
    private int runCounter = 0;
    boolean running = true;
    boolean started = false;
    private CountDownTimer counter;
    private Vibrator v;
    private MainActivity main;

    public Run(){

    }

    /**
     * Constructor for first instance created in MainActivity
     * @param main An instance of the MainActivity
     *
     */
    public Run (MainActivity main, Vibrator v) {
        this.main = main;
        this.v = v;
        lapsCount = lapsConstant;
        totTime = (runTime + restTime) * lapsConstant + lapsConstant; // här blir det problem

    }

    /**
     * The method that "makes the app run" :)
     */
    public void startRun(){ // todo: Tägg till Toast, och skapa en inräknings grej.
        started = true;
        main.setLap();
        counter = new CountDownTimer(totTime*1000 , 1000) {
            //@Override
            public void onTick(long time) {
                totTimer--;
                    if (running) {
                        main.setActivity("High Intensity");
                        main.setTime(runTime - runCounter);
                        if((runTime - runCounter) == 3 || (runTime - runCounter) == 2){
                            v.vibrate(500);
                        }
                        if((runTime - runCounter) == 1){
                            v.vibrate(1000);
                        }
                        runCounter++;
                        if (runTime - runCounter == 0) {
                            running = false;
                            runCounter = 0;
                        }
                    } else {
                        main.setActivity("Low Intensity");
                        main.setTime(restTime - restCounter);
                        if((restTime - restCounter) == 3 || (restTime - restCounter) == 2){
                            v.vibrate(500);
                        }
                        if((restTime - restCounter) == 1){
                            v.vibrate(1000);
                        }
                        restCounter++;
                        if (restTime - restCounter == 0) {
                            lapsCount--;
                            main.setLap();
                            running = true;
                            restCounter = 0;
                        }
                    }
            }
            @Override
            public void onFinish() {
                Toast.makeText(main, "You'r Done!\nGreat Work!", Toast.LENGTH_LONG).show();
                main.stopper.stop();
                v.vibrate(1000);
            }
        };
        counter.start();
    }

    public void stopTimer(){

        counter.cancel();
    }

    public boolean isStarted(){
        return started;
    }

    public void setIsStartedFalse(){
        started = false;
    }

    public void setRunTime(long time) {
        runTime = time;
    }

    public void setRestTime(long time) {
        restTime = time;
    }

    public void setLapsConstant(int laps) {
        lapsConstant = laps;
    }

    public void setLapsCount(int laps){
        lapsCount = laps;
    }

    public void setRunning(Boolean bool){
        running = bool;
    }

    public void setRunCounter(int number){
        runCounter = number;
    }

    public void setRestCounter(int number){
        restCounter = number;
    }

    public void setTotTime(long number){
        totTime = number;
    }

    public void setTotTimer(){
        totTimer = totTime;
    }

    public long getRunTime(){
        return runTime;
    }

    public long getRestTime(){
        return restTime;
    }

    public int getLapsCount() {
        return lapsCount;
    }

    public boolean getRunning(){
        return running;
    }

    public int getRunCounter(){
        return runCounter;
    }

    public int getRestCounter() {
        return restCounter;
    }

    public long getTotTime(){
        return totTime;
    }

    public long getTotTimer(){
        return totTimer;
    }


}
