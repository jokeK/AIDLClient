// IBookManager.aidl
package com.aidlservice;

// Declare any non-default types here with import statements
import com.aidlservice.MyBank.Bank;
interface IBankManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    List<Bank> getBanks();
    //in 表示数据只能由客户端流向服务端，
    //out 表示数据只能由服务端流向客户端，
    //而 inout 则表示数据可在服务端与客户端之间双向流通。
    //inout不要乱用，用的不好会加大系统开销。
    void addBank(in Bank bank);
}
