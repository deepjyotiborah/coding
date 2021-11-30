package com.deep.algoritms.sorting.insertionSort;

import com.deep.algoritms.sorting.selectionSort.SelectionSort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class InsertionSort {

    private void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 7,5};
        System.out.println("Before Sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        System.out.println("After sort - ");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

        String date = "2017-05-02";
        String oldFormat = "yyyy-MM-dd";
        String newFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
        try {
            Date newDate = sdf.parse(date);
            sdf.applyPattern(newFormat);
            //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
           // System.out.println("====>>> " + );

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
                    .withZone(ZoneId.of("UTC"));
            formatter.parse(sdf.format(newDate), Instant::from);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
