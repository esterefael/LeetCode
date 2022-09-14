// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> s = new Stack<>();
//         for(int a: asteroids){
//             if(a > 0/* || !s.isEmpty() && s.peek() < 0*/){
//                 s.push(a);
//                 continue;
//             }
//             while(!s.isEmpty() && s.peek() > 0 && s.peek() < -a)
//                 s.pop();
//             if(!s.isEmpty() && s.peek() > -a)
//                 continue;
//             if(!s.isEmpty() && s.peek() == -a)
//                 s.pop();
//             else
//                 s.push(a);                
//         }
//         int n = s.size();
//         int[] res = new int[n];
//         for(int i = n - 1; i >= 0; i--)
//             res[i] = s.pop();
//         return res;
//     }
// }
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int a: asteroids){
            if(a > 0){
                s.push(a);
                continue;
            }
            while(!s.isEmpty() && s.peek() > 0 && s.peek() < -a)
                s.pop();
            if(!s.isEmpty() && s.peek() > -a)
                continue;
            if(!s.isEmpty() && s.peek() == -a)
                s.pop();
            else
                s.push(a);                
        }
        int n = s.size();
        int[] res = new int[n];
        for(int i = n - 1; i >= 0; i--)
            res[i] = s.pop();
        return res;
    }
}