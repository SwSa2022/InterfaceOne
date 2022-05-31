package de.msgdavid.compactstring;

import java.util.*;
import java.lang.*;

class AsciiCharSequence implements java.lang.CharSequence /* extends/implements */ {
    // implementation
    private final byte[] myArray;

    AsciiCharSequence(byte[] array) {
        this.myArray = array;
//            oder so:
//        this.myArray = array.clone();
    }

    @Override
    public int length() {
        return myArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char)(myArray[index] & 0xff);
    }

    @Override
    public CharSequence subSequence(int from, int to) {
        int length = to- from;
        byte[] bytes = new byte[length];
        for(int i=0, j=from; i<length; i++,j++) {
            bytes[i] = myArray[j];
        }
        return  new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        return new String(this.myArray);
    }
}

public class Main {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer);//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Jello!
    }
}


/*
import java.util.*;
import java.lang.*;

class AsciiCharSequence implements java.lang.CharSequence // extends/implements
{
// implementation
private byte[] myArray;
public final byte[] copyOfRange;


        AsciiCharSequence(byte[] copyOfRange) {
        this.copyOfRange = copyOfRange;
        }

public void ByteArray(byte[] myArray) {
        this.myArray = myArray;
        }

@Override
public int length() {
        for (int i = 0; i < myArray.length; ) {
        i++;
        }
        return myArray.length;
        }

@Override
public char charAt(int index) {
        for (index = 0; index < myArray.length - 1; ) {
        try {
        return (char) myArray[index];
        } catch (ArrayIndexOutOfBoundsException ae) {
        System.out.println(ae);
        }
        }
        return (char) myArray[index];
        }

@Override
public CharSequence subSequence(int from, int to) {
        CharSequence cs = new AsciiCharSequence(Arrays.copyOfRange(myArray, from, to));
        return cs;
        }

@Override
public String toString() {
        try {
        return new String(this.copyOfRange);
        }
        catch (NullPointerException npe) {
        System.out.println(npe);
        }
        return new String(this.copyOfRange);
        }
        }
 */