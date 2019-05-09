package javabasic;

public class NewArray {
    public  static  void generalUse(int []args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
    public  static void newBehaviour(int ...args){
        //可以使用0个或者多个参数调用该方法
        System.out.println("length:"+" "+args.length);
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
  /*  public  static void newBehaviour(int a,int ...args){  此处会报错，以为与上面的重复，不知道该调用哪一个
        //可以使用0个或者多个参数调用该方法
        System.out.println("length:"+" "+args.length);
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }*/
    public  static  void newBehaviour1(int a,int b, int ...args){
        //动态参数只能作为最后一个参数，这样的话前两个匹配，剩下的全部属于动态参数
        System.out.println("new2");
        System.out.println(a+"  "+b);
        for (int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
    public static void main(String[] args){
        int[] a={1,2,3};
       // generalUse();//不传参数会报错,传 null会报空指针异常
        newBehaviour();//不传参数不会变错，而且不会报空指针异常,显式的传null也会报空指针异常
        generalUse(a);
        newBehaviour(a);
        newBehaviour(1,2,3,4,5); //可以识别动态的参数个数  ,动态参数重载会导致模糊的问题,容易报错
        newBehaviour1(1,2,3,4,5,6,7);


    }
}
