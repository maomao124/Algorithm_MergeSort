/**
 * Project name(项目名称)：算法_归并排序
 * Package(包名): PACKAGE_NAME
 * Class(类名): MergeSort
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)：
 * 归并排序算法是在分治算法基础上设计出来的一种排序算法，它可以对指定序列完成升序（由小到大）或降序（由大到小）排序，对应的时间复杂度为O(nlogn)。
 * 归并排序算法实现排序的思路是：
 * 将整个待排序序列划分成多个不可再分的子序列，每个子序列中仅有 1 个元素；
 * 所有的子序列进行两两合并，合并过程中完成排序操作，最终合并得到的新序列就是有序序列。
 * 使用归并排序算法对 {7, 5, 2, 4, 1, 6, 3, 0} 实现升序排序的过程是：
 * 1) 将 {7, 5, 2, 4, 1, 6, 3, 0} 分割成多个子序列，每个子序列中仅包含 1 个元素
 * 整个序列不断地被一分为二，最终被分割成 {7}、{5}、{2}、{4}、{1}、{6}、{3}、{0} 这几个序列。
 * 2) 将 {7}、{5}、{2}、{4}、{1}、{6}、{3}、{0} 以“两两合并”的方式重新整合为一个有序序列，
 */

public class MergeSort
{
    public static void sort(int[] arr)
    {
        merge_sort(arr, 1, arr.length);
    }

    public static void merge_sort(int[] arr, int low, int high)
    {
        // 如果数组不存在或者 [low.high] 区域不合理
        if (arr == null || low >= high)
        {
            return;
        }
        //对[low,high]区域进行分割
        int mid = (low + high) / 2;
        merge_sort(arr, low, mid);        //左边
        merge_sort(arr, mid + 1, high);         //右边
        //对分割的 [low,mid] 和 [mid+1,high] 区域进行归并
        merge(arr, low, mid, high);
    }

    //实现归并排序算法的归并操作
    public static void merge(int[] arr, int low, int mid, int high)
    {
        int numL = mid - low + 1;
        int numR = high - mid;
        //创建 2 个数组，分别存储 [low,mid] 和 [mid+1,high]区域内的元素
        int[] leftarr = new int[numL + 1];
        int[] rightarr = new int[numR + 1];
        int i;
        for (i = 0; i < numL; i++)
        {
            leftarr[i] = arr[low - 1 + i];
        }
        //将 leftarr 数组中最后一个元素设置为足够大的数。
        leftarr[i] = 2147483647;
        for (i = 0; i < numR; i++)
        {
            rightarr[i] = arr[mid + i];
        }
        //将 rightarr 数组中最后一个元素设置为足够大的数。
        rightarr[i] = 2147483647;
        int j = 0;
        i = 0;
        //对 leftarr 和 rightarr 数组中存储的 2 个区域的元素做归并操作
        for (int k = low; k <= high; k++)
        {
            if (leftarr[i] <= rightarr[j])
            {
                arr[k - 1] = leftarr[i];
                i++;
            }
            else
            {
                arr[k - 1] = rightarr[j];
                j++;
            }
        }
        print(arr);
    }

    private static void print(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
