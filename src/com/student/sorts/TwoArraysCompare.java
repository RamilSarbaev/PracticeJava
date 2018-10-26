package com.student.sorts;

public class TwoArraysCompare {

    private int compareArrays(int[] first, int[] second) {
        return Integer.compare(first.length, second.length);
    }

    public static void main(String[] args) {
        int[] first = {10, 5, 2, 3, 1};
        int[] second = {2, 12, 7, 8};

        TwoArraysCompare obj = new TwoArraysCompare();
        int result = obj.compareArrays(first, second);

        String output;

        if (result == -1) {
            output = "first array shorter than the second one";
        } else if (result == 1) {
            output = "first array longer than the second one";
        } else {
            output = "Arrays are equals";
        }

        System.out.println(output);
    }
}
