####    Let’s consider the following array: (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610). Length of the array is 16. Jump search will find the value of 55 with the following steps assuming that the block size to be jumped is 4.

- STEP 1: Jump from index 0 to index 4;

- STEP 2: Jump from index 4 to index 8;

- STEP 3: Jump from index 8 to index 12;

- STEP 4: Since the element at index 12 is greater than 55 we will jump back a step to come to index 8.

- STEP 5: Perform linear search from index 8 to get the element 55.