- Merge sort is a divide & conquer algorithm. It divides the input array into two halves, calls itself for the two halves & then merge the two sorted halves.

- Mergesort(arr[], l, r)
if(r > l)
  
  -- Find the middle point to divide the array into two halves.
        
        middle m = (l + r)/2
   
  -- Call mergeSort for first half:
  
        Call mergeSort(arr, l, m)
        
  -- Call mergeSort for second half:
  
        Call mergeSort(arr, m+1, r)
        
  -- Merge the two halves sorted in step 2 and 3:
  
        Call merge(arr, l, m, r)
        
- Time complexity of merge sort is - O(nlogn)         