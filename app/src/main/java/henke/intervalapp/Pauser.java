package henke.intervalapp;

/**
 * Created by Henke on 2017-01-10.
 */

public class Pauser {

    private long pauseTotTime;
    private long pauseRunTime;
    private long pauseRestTime;
    private int pauseLaps;
    private boolean pauseRunning;
    private int pauseRunCounter;
    private int pauseRestCounter;
    private Run runner;
    private boolean check = false;

    public Pauser(Run runner){
        this.runner = runner;
    }

    public void pause(){
        pauseTotTime = runner.getTotTime(); //todo:vi måste hämta den tiden som återstår, inte den första tiden.
        pauseRunTime = runner.getRunTime();
        pauseRestTime = runner.getRestTime();
        pauseLaps = runner.getLapsCount();
        pauseRunning = runner.getRunning();
        pauseRunCounter = runner.getRunCounter();
        pauseRestCounter = runner.getRestCounter();
        runner.stopTimer();
        check = true;
    }

    public void unPause(){
        runner.setTotTime(pauseTotTime);
        runner.setRunTime(pauseRunTime);
        runner.setRestTime(pauseRestTime);
        runner.setLapsConstant(pauseLaps);
        runner.setRunning(pauseRunning);
        runner.setRunCounter(pauseRunCounter);
        runner.setRestCounter(pauseRestCounter);
        runner.startRun();
        check = false;
    }

    public boolean isPaused(){
        return check;
    }

    public void setCheckFalse(){
        check = false;
    }
}
