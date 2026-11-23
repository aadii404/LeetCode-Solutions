// method 1 brute force

// class ProductOfNumbers {
//     List<Integer> list;

//     public ProductOfNumbers() {
//         list = new ArrayList<>();
//     }
    
//     public void add(int num) {
//         list.add(num);
//     }
    
//     public int getProduct(int k) {
//         int prod = 1;

//         int i = list.size() - 1;
//         while(k > 0){
//             prod *= list.get(i);
//             i--;
//             k--;
//         }

//         return prod;
//     }
// }

// method - 2 optimal using prefix array of product
// follow up 

class ProductOfNumbers {
    List<Integer> pre;

    public ProductOfNumbers() {
        pre = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            pre.clear();
        }else if(pre.isEmpty()){
            pre.add(num);
        }else{
            pre.add(num * pre.get(pre.size() - 1));
        }
    }
    
    public int getProduct(int k) {
        int n = pre.size();

        if(k > n) return 0;
        if(k == n) return pre.get(n - 1);

        return pre.get(n - 1) / pre.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */