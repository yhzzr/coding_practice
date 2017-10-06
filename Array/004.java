public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array1, array2;
        if(nums1.length <= nums2.length){
            array1 = nums1;
            array2 = nums2;
        }else{
            array1 = nums2;
            array2 = nums1;
        }
        
        int min = 0;
        int max = array1.length;
        int halflen = array1.length + array2.length + 1;
        
        while( min <= max){
            int i = min + (max-min)/2;
            int j = halflen/2 - i;
            if( j > 0 && i < array1.length && array2[j-1] > array1[i]){
                min = i+1;
            }else if( i > 0 && j< array2.length && array1[i-1] > array2[j]){
                max = i-1;
            }else{
                int max_of_left, min_of_right;
                if(i==0){
                    max_of_left = array2[j-1];
                }else if(j==0){
                    max_of_left = array1[i-1];
                }else{
                    max_of_left = Math.max(array1[i-1], array2[j-1]);
                }
                if( (array1.length + array2.length) %2 == 1)
                    return max_of_left;
                
                if(i==array1.length){
                    min_of_right = array2[j];
                }else if(j==array2.length){
                    min_of_right = array1[i];
                }else{
                    min_of_right = Math.min(array1[i],array2[j]);
                }
                return ((double)max_of_left + (double)min_of_right) / 2.0;
            }
        }
        return 0;
}