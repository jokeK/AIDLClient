package com.aidlclient;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.aidlservice.IBankManager;

public class BankManager {
    private IBankManager iBankManager;
    private BankManager() {
    }
    private static class Manager{
        private static BankManager manager = new BankManager();
    }
    public static BankManager getIntence(){
        return Manager.manager;
    }
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("TAG","客户端端创建成功");
            iBankManager = IBankManager.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void connectService(Context context){
        Intent intent = new Intent();
        intent.setAction("com.aidlservice.Service.BookService");
        intent.setPackage("com.aidlservice");
        context.bindService(intent,conn, Service.BIND_AUTO_CREATE);
    }
    public IBankManager getIBankManager() {
        return iBankManager;
    }
    public void unBinderService(Context context){
        context.unbindService(conn);
    }


}

