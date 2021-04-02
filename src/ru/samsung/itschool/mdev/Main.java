package ru.samsung.itschool.mdev;

public class Main {

    private volatile boolean flag = false;

    // поток интерфейса
    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Stopping GUI!");
        }
    };

    // поток логики игры
    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {

            }
            System.out.println("Stopping game!");
        }
    };

    void toStart() {
        new Thread(gui).start();
        System.out.println("Starting GUI!");
        new Thread(logic).start();
        System.out.println("Starting game!");
    }

    public static void main(String[] args) {
        new Main().toStart();
    }
}
