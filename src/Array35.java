/**
 * @ProjectName: leetCodeInJava
 * @PackageName: PACKAGE_NAME
 * @ClassName: Array35
 * @Description:
 * @author: chenliang
 * @date: 2021/4/7 11:50 下午
 * @Copyright: digital china software Inc 2021
 */
public class Array35 {
    public static void main(String[] args) {
        int[] arr={1,4};
        System.out.println(searchInsert(arr,3));
    }

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public static  int insertIndex(int[] arr,int num){
        //暴力法 时间复杂度O(n) 空间复杂度O(1)
        //考虑处插入的位置:最前,中间,重复替换,最后
        for (int i = 0; i < arr.length; i++) {
                //假设是升序的
                if(arr[i]>=num){
                    return  i;
                }
        }
        return  arr.length;
    }

    //时间复杂度
    /* 常见时间复杂度量级
常数阶O(1)
对数阶O(logN)
线性阶O(n)
线性对数阶O(nlogN)
平方阶O(n?)
立方阶O(n?)
K次方阶O(n^k)
指数阶(2^n)
    */

    //二分发
    //边界处理方式
    public static  int searchInsert(int arr[],int target){
        int len=arr.length;
        int left=0;
        int right=len-1;
        while (left<=right){            // 当left==right，区间[left, right]依然有效
            int middle=(left+right)/2; //中间的值 防止溢出
            if(arr[middle]>target){
                right=middle-1;  //target在左区间
            }else if(arr[middle]<target){
                left=middle+1;                 //target在右区间
            }else {
                return  middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1


        // 当left>right时 插入的位置都在right+1
        return right+1;

    }


}
