interface IData {
    void show();
}

class DataManager implements IData {
    @Override
    public void show() {
        System.out.println("Show Data");
    }
}

public class Solution {
    public static void main(String[] args) {
        DataManager d = new DataManager();
        d.show();
    }
}