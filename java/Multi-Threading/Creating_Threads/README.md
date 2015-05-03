Two ways to implement threads in java

1. extends Thread
2. implements Runnable (and pass it to the constructor of the Tread class)

Note class Thread has methods to allow more control over threads than Runnable.
E.g. Methods: interrupt(), isAlive(), getState()