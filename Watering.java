public class Watering {
    private double width;
    private double length;
    private double gallons;
    private double hours;
    private double emitter;

    //Do we want constructor or default constructor?
    public Watering(double w, double len, double gal, double hrs, double emit) {
        width = w;
        length = len;
        gallons = gal;
        hours = hrs;
        emitter = emit;
    }

    //Setters
    public void setWidth(double w) {
        width = w;
    }

    public void setLength(double len) {
        length = len;
    }

    public void setGallons(double gal) {
        gallons = gal;
    }

    public void setEmitter(double emit) {
        emitter = emit;
    }

    public void setHours(double hrs) {
        hours = hrs;
    }

    //Getters
    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getGallons() {
        return gallons;
    }

    public double getEmitter() {
        return emitter;
    }

    public double getArea() {
        return length * width;
    }
}