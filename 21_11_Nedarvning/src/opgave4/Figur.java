
package opgave4;

public class Figur {
    
    private double xPos;
    private double yPos;
    
    public Figur(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public double getXPos() {
        return xPos;
    }
    
    public void setXPos(double xPos) {
        this.xPos = xPos;
    }
    
    public double getYPos() {
        return yPos;
    }
    
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }
    
    public double beregnAreal() {
        return 0;
    }

    public void parallelForskyd(double forskydning) {
        setXPos(getXPos() + forskydning);
        setYPos(getYPos() + forskydning);
    }
    
}
