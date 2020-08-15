/**
 @descriptions
 @author wushen
 @create 2020-08-09 16:54
 */
public class Demo {
        public static void main(String[] args){
            int x = 1;
            for(show('a'); show('b') && x<3; show('c')){
                show('d');
                x++;
            }
        }
        public static boolean show(char ch){
            System.out.print(ch);
            return true;
        }
}
