package Threads.ProducerConsumer;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        int data;

        while(true) {
            // Consume the data from the buffer. We are not using the consumed
            // data for any other purpose here
            data = buffer.consume();
        }
    }
}
