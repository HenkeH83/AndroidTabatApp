package henke.intervalapp;

/**
 * Created by Henke on 2017-01-11.
 */

public class Stopper {

    private long stopTotTime;
    private long stopRunTime;
    private long stopRestTime;
    private int stopLaps;
    private boolean stopRunning;
    private int stopRunCounter;
    private int stopRestCounter;
    private Run runner;
    private MainActivity main;

    public Stopper(Run runner, MainActivity main){
        this.main = main;
        this.runner = runner;
    }

    public void setStop(){
        stopTotTime = runner.getTotTime();
        stopRunTime = runner.getRunTime();
        stopRestTime = runner.getRestTime();
        stopLaps = runner.getLapsCount();
        stopRunning = runner.getRunning();
        stopRunCounter = runner.getRunCounter();
        stopRestCounter = runner.getRestCounter();
    }

    public void stop(){
        runner.setTotTime(stopTotTime);
        runner.setRunTime(stopRunTime);
        runner.setRestTime(stopRestTime);
        runner.setLapsConstant(stopLaps);
        runner.setLapsCount(stopLaps);
        runner.setRunning(stopRunning);
        runner.setRunCounter(stopRunCounter);
        runner.setRestCounter(stopRestCounter);
        runner.stopTimer();
        runner.setIsStartedFalse();
        main.setTime(stopRunTime);
        main.setActivity("High Intensity"); //todo: ändra text till start text, om det skall vara någon annan.
        main.setLap();
    }
}


