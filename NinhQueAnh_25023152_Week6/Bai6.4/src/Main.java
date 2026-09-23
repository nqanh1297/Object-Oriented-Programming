public class Main {
    static void main(String[] args) {
        int[] arr=  {5, 2, 9, 1};

        Sorter sorter=new SorterAdapter(new LegacySorter());

        int[] result = sorter.sort(arr);

        for( int i: result) {
            System.out.print(i+ " " );
        }
    }
}
