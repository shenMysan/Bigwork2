package Dao;

import java.util.Arrays;
import java.util.Iterator;

public class Sqlist<T> implements  Iterable<T>{
    int usedSize;//顺序表实际长度
    Object[] elem;//数组
    public Sqlist(){
        this(10);
    }

    public Sqlist(int size){
        elem = new Object[size];
        usedSize = 0;
    }

    public boolean isFull(){
        if(usedSize == elem.length){
            return true;
        }else{
            return false;
        }
    }



    public boolean insert(Object val,int pos){
        if(isFull()){
            elem = Arrays.copyOf(elem, elem.length*2);        //使用Arrays.copyOf()进行扩容  ,二倍
        }
        if(pos < 0 || pos > this.usedSize){
            return false;
        }
        for(int i = this.usedSize-1;i >= pos;i--){//从后向前来依次挪动
            elem[i+1] = elem[i];
        }
        elem[pos] = val;
        this.usedSize++;
        return true;
    }

    public boolean unpdate(Object val,int pos){
        if(isFull()){
            elem = Arrays.copyOf(elem, elem.length*2);        //使用Arrays.copyOf()进行扩容  ,二倍
        }
        if(pos < 0 || pos > this.usedSize){
            return false;
        }

        elem[pos] = val;

        return true;
    }

    public boolean isEmpty(){
        if(this.usedSize == 0){
            return true;
        }
        return false;
    }


    public boolean insert(Object val){
        if(isFull()){
            elem = Arrays.copyOf(elem, elem.length*2);        //使用Arrays.copyOf()进行扩容  ,二倍
        }


        elem[usedSize] = val;
        this.usedSize++;
        return true;
    }

    public int search(Object key){
        //存在顺序表为空
        if(isEmpty()){
            return -1;
        }
        int pos = -1;
        for(int i = 0;i < this.usedSize;i++){
            if(elem[i] == key){
                pos = i;
            }
        }
        return pos;
    }



    public void delete(Object val){
        int pos = search(val);
        if(pos == -1){
            System.out.println("无指定元素");
        }else{
            for(int i = pos;i < this.usedSize-1;i++){
                elem[i] = elem[i+1];
            }
            this.usedSize--;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }


    //    创建一个内部类实现Iterator接口
    public class SIterator implements Iterator{
        //        定义一个遍历的游标
        private int cusor;
        public SIterator(){
//            初始化为0索引位置
            this.cusor=0;
        }
        //重写两个方法
        @Override
        public boolean hasNext() {
//            这个方法判断是否超出最大索引，如果超出会停止遍历
            return cusor<usedSize;
        }

        @Override
        public Object next() {
//            这个方法会遍历得每个元素
            return elem[cusor++];
        }
    }
/*
       for(Object ls:sqlist){
        System.out.println("遍历元素---"+ls);
    }
*/


}
