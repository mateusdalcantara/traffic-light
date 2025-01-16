package com.mateusdalcantara.application;

/**
 * Represents a traffic light system that cycles through RED, YELLOW, and GREEN lights.
 *
 * This class simulates a traffic light by displaying the current light and changing it after
 * specific time intervals. The traffic light starts with the RED light and cycles through
 * RED, YELLOW, and GREEN indefinitely.
 *
 */
public class TrafficLight {

    /**
     * The current light of the traffic light.
     */
    private Light currentLight;

    /**
     * Enum representing the different states of a traffic light.
     *
     * The possible states are:
     *
     *   {@link Light#RED} - Red light
     *   {@link Light#YELLOW} - Yellow light
     *   {@link Light#GREEN} - Green light
     *
     */
    private enum Light {
        RED, YELLOW, GREEN
    }

    /**
     * Constructs a new {@code TrafficLight} with the initial state set to {@link Light#RED}.
     */
    public TrafficLight() {
        currentLight = Light.RED; // The traffic light starts with the red light.
    }

    /**
     * Changes the current light to the next state in the traffic light cycle.
     *
     * The traffic light transitions from:
     *
     *   {@link Light#RED} to {@link Light#GREEN}
     *   {@link Light#YELLOW} to {@link Light#RED}
     *   {@link Light#GREEN} to {@link Light#YELLOW}
     *
     */
    private void changeLight() {
        switch (currentLight) {
            case RED:
                currentLight = Light.GREEN;
                break;
            case YELLOW:
                currentLight = Light.RED;
                break;
            case GREEN:
                currentLight = Light.YELLOW;
                break;
        }
    }

    /**
     * Displays the current light of the traffic light to the console.
     *
     * The display will print one of the following messages:
     *
     *   "Red light" for {@link Light#RED}
     *   "Yellow light" for {@link Light#YELLOW}
     *   "Green light" for {@link Light#GREEN}
     *
     */
    private void displayLight() {
        switch (currentLight) {
            case RED:
                System.out.println("Red light");
                break;
            case YELLOW:
                System.out.println("Yellow light");
                break;
            case GREEN:
                System.out.println("Green light");
                break;
        }
    }

    /**
     * Starts the traffic light cycle, continuously switching between the lights and
     * displaying the current light.
     *
     * The traffic light cycle proceeds as follows:
     *
     *   {@link Light#RED} for 5 seconds
     *   {@link Light#YELLOW} for 2 seconds
     *   {@link Light#GREEN} for 5 seconds
     *
     */
    public void start() {
        while (true) {
            displayLight();

            // Time intervals for each light (in milliseconds)
            try {
                switch (currentLight) {
                    case RED:
                        Thread.sleep(5000);  // Red light for 5 seconds
                        break;
                    case YELLOW:
                        Thread.sleep(2000);  // Yellow light for 2 seconds
                        break;
                    case GREEN:
                        Thread.sleep(5000);  // Green light for 5 seconds
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            changeLight(); // Change the light
        }
    }

    /**
     * Main method to run the traffic light simulation.
     * This method initializes a {@code TrafficLight} instance and starts the cycle.
     */
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start();
    }
}