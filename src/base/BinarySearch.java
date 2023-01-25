package base;

/**
 * 二分查找
 * @author <a href="https://github.com/Cocowwy">Cocowwy</a>
 * @since 2023/1/25
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 7, 8};
        // 非递归
        System.out.println((binarySearchUnRecursion(nums, 1) == 0));
        System.out.println((binarySearchUnRecursion(nums, 2) == 1));
        System.out.println((binarySearchUnRecursion(nums, 3) == 2));
        System.out.println((binarySearchUnRecursion(nums, 6) == 3));
        System.out.println((binarySearchUnRecursion(nums, 7) == 4));
        System.out.println((binarySearchUnRecursion(nums, 8) == 5));
        System.out.println((binarySearchUnRecursion(nums, 10) == -1));
        System.out.println((binarySearchUnRecursion(nums, 0) == -1));
        System.out.println("\n\n");
        // 递归
        System.out.println((binarySearchRecursion(nums, 1, 0, nums.length - 1) == 0));
        System.out.println((binarySearchRecursion(nums, 2, 0, nums.length - 1) == 1));
        System.out.println((binarySearchRecursion(nums, 3, 0, nums.length - 1) == 2));
        System.out.println((binarySearchRecursion(nums, 6, 0, nums.length - 1) == 3));
        System.out.println((binarySearchRecursion(nums, 7, 0, nums.length - 1) == 4));
        System.out.println((binarySearchRecursion(nums, 8, 0, nums.length - 1) == 5));
        System.out.println((binarySearchRecursion(nums, 10, 0, nums.length - 1) == -1));
        System.out.println((binarySearchRecursion(nums, 0, 0, nums.length - 1) == -1));
    }

    /**
     * 递归版二分查找
     */
    public static int binarySearchRecursion(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return binarySearchRecursion(nums, target, left, right);
    }

    /**
     * 非递归版二分查找
     */
    public static int binarySearchUnRecursion(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

}
