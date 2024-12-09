import controller.BackupController;
import controller.WorkerController;

import view.BackupView;
import view.MenuView;
import view.WorkerView;

public class Main {
    public static void main(String[] args) {
        WorkerController workerController = new WorkerController();
        BackupController backupController = new BackupController();

        WorkerView workerView = new WorkerView(workerController);
        BackupView backupView = new BackupView(backupController, workerController);

        MenuView menuView = new MenuView(workerView, backupView);
        menuView.showMenu();
    }
}