import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(float temperature);
}

// Concrete Observer
class Display implements Observer {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println(name + " Display: Temperature updated to " + temperature + "°C");
    }
}

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Main
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Display phoneDisplay = new Display("Phone");
        Display tvDisplay = new Display("TV");

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        weatherStation.setTemperature(25.0f);
        weatherStation.setTemperature(30.0f);
    }
}
