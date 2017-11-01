package datastructure;

import com.juran.examplemovie.module.utils.LogBase;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 线性表
 * @date 10:25 2017/10/31
 */
public class LinearList extends LogBase {
    public static void main(String[] args) {
        int[] oldArray = new int[10];
        int[] newArray = new int[20];
        for (int i = 1; i <= 10; i++) {
            oldArray[i] = i;
        }
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        System.out.print(newArray);
    }

    /**
     * 数组插入数据
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        int[] oldArray = new int[10];

        if (index > oldArray.length || index < 0) {
            logger.info("插入的位置不合法");
        }
        if (index > oldArray.length) {
            int[] newArray = new int[20];
            System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
            for (int i = newArray.length - 1; i >= index; i--) {
                newArray[i + 1] = newArray[i];
            }
        }
        for (int i = oldArray.length - 1; i >= index; i--) {
            oldArray[i + 1] = oldArray[i];
        }
        oldArray[index] = e;

    }
}
