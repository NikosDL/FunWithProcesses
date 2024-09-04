package nec.FunWithProcesses;

public class AnimatorCentral implements Runnable {
    private MainView mainView;
    
    public AnimatorCentral(MainView mainView) {
        this.mainView = mainView;
    }
    
    @Override
    public void run() {
        this.mainView.repaintView();
    }
}
