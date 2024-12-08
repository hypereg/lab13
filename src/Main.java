import controller.WorkerController;
import model.Dyrektor;
import model.Pracownik;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private WorkerController workerController;

    public static void main(String[] args) {
        workerController = new WorkerController(this);
    }
}