class Solution {
    public int numTeams(int[] a) {
        int b=0;
        int n = a.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){

                    if(a[i] > a[j] && a[j]> a[k]){
                            b++;
                    }
                    if(a[i] < a[j] && a[j] < a[k]){
                        b++;
                    }
                }
            }
        }
    return b;
    }

}