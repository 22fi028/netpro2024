import java.io.Serializable;

public class Product implements Serializable {

    int nop;
    String name;

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    public String getName() {
        return name;
    }

    public void setName(String present) {
        this.name = present;
    }

}