package com.jia.board.geek.array;

public class Array {

    public int[] data;
    /**
     * 数组长度
     */
    public int n;
    /**
     * 数组中实际个数
     */
    public int count;

    /**
     * 构造函数
     *
     * @param capacity 数组大小
     */
    public Array(int capacity) {
        this.n = capacity;
        this.data = new int[capacity];
        this.count = 0;
    }

    /**
     * 不支持动态扩容
     * @param index 索引（从0计算）
     * @param value 值
     * @return
     */
    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("数组已满");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("索引不合法");
            return false;
        }

        for (int i = count; i > index; --i) {
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    /**
     * 需要进行动态扩容时的操作
     */
    public void addCapacity(){
        n = n * 2;
        int[] newData = new int[n];
        for (int i=0; i<count; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 支持动态扩容
     */
    public boolean insert1(int index, int value){
        if (count == n){
            // 进行扩容操作
            addCapacity();
        }

        if (index < 0 || index > count){
            System.out.println("索引不合法");
            return false;
        }

        for (int i=count; i>index; i++){
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Array array = new Array(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        System.out.println(array.n);
        System.out.println(array.data.length);
        array.insert1(5, 1);
        array.printAll();
        System.out.println(array.n);
        System.out.println(array.data.length);

    }


}
